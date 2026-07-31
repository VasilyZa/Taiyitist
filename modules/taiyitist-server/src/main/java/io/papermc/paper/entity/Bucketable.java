package io.papermc.paper.entity;

import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public interface Bucketable extends Entity {
   boolean isFromBucket();

   void setFromBucket(boolean var1);

   @NotNull
   ItemStack getBaseBucketItem();

   @NotNull
   Sound getPickupSound();
}
