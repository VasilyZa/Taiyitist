package io.papermc.paper.entity;

import org.jetbrains.annotations.ApiStatus.Experimental;

@Experimental
public sealed interface TeleportFlag permits TeleportFlag.EntityState, TeleportFlag.Relative {
   @Experimental
   public static enum EntityState implements TeleportFlag {
      RETAIN_PASSENGERS,
      RETAIN_VEHICLE,
      RETAIN_OPEN_INVENTORY;
   }

   @Experimental
   public static enum Relative implements TeleportFlag {
      X,
      Y,
      Z,
      YAW,
      PITCH;
   }
}
