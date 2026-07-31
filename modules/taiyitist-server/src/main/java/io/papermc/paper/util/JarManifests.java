package io.papermc.paper.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.jar.Manifest;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class JarManifests {
   private static final Map<ClassLoader, Manifest> MANIFESTS = Collections.synchronizedMap(new WeakHashMap<>());

   private JarManifests() {
   }

   @Nullable
   public static Manifest manifest(@NotNull Class<?> clazz) {
      return MANIFESTS.computeIfAbsent(clazz.getClassLoader(), classLoader -> {
         String classLocation = "/" + clazz.getName().replace(".", "/") + ".class";
         URL resource = clazz.getResource(classLocation);
         if (resource == null) {
            return null;
         } else {
            String classFilePath = resource.toString().replace("\\", "/");
            String archivePath = classFilePath.substring(0, classFilePath.length() - classLocation.length());

            try {
               Manifest var7;
               try (InputStream stream = new URL(archivePath + "/META-INF/MANIFEST.MF").openStream()) {
                  var7 = new Manifest(stream);
               }

               return var7;
            } catch (IOException var11) {
               return null;
            }
         }
      });
   }
}
