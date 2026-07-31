package io.papermc.paper.datapack;

import org.jetbrains.annotations.NotNull;

public interface Datapack {
   @NotNull
   String getName();

   @NotNull
   Datapack.Compatibility getCompatibility();

   boolean isEnabled();

   void setEnabled(boolean var1);

   public static enum Compatibility {
      TOO_OLD,
      TOO_NEW,
      COMPATIBLE;
   }
}
