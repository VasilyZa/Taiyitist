package io.papermc.paper.registry;

import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface Reference<T extends Keyed> extends Keyed {
   @NotNull
   T value();

   @Nullable
   T valueOrNull();

   @NotNull
   static <T extends Keyed> Reference<T> create(@NotNull Registry<T> registry, @NotNull NamespacedKey key) {
      return new ReferenceImpl<>(registry, key);
   }
}
