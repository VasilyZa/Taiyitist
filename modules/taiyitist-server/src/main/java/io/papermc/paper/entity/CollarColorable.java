package io.papermc.paper.entity;

import org.bukkit.DyeColor;
import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public interface CollarColorable extends LivingEntity {
   @NotNull
   DyeColor getCollarColor();

   void setCollarColor(@NotNull DyeColor var1);
}
