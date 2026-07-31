package io.papermc.paper.entity;

import net.kyori.adventure.util.TriState;
import org.jetbrains.annotations.NotNull;

public interface Frictional {
   @NotNull
   TriState getFrictionState();

   void setFrictionState(@NotNull TriState var1);
}
