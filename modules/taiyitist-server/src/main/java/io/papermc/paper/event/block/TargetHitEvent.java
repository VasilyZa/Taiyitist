package io.papermc.paper.event.block;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Projectile;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.jetbrains.annotations.NotNull;

public class TargetHitEvent extends ProjectileHitEvent implements Cancellable {
   private static final HandlerList handlers = new HandlerList();
   private boolean cancelled;
   private int signalStrength;

   public TargetHitEvent(@NotNull Projectile projectile, @NotNull Block block, @NotNull BlockFace blockFace, int signalStrength) {
      super(projectile, null, block, blockFace);
      this.signalStrength = signalStrength;
   }

   @Override
   public boolean isCancelled() {
      return this.cancelled;
   }

   @Override
   public void setCancelled(boolean cancelled) {
      this.cancelled = cancelled;
   }

   @NotNull
   @Override
   public HandlerList getHandlers() {
      return handlers;
   }

   @NotNull
   public static HandlerList getHandlerList() {
      return handlers;
   }

   public int getSignalStrength() {
      return this.signalStrength;
   }

   public void setSignalStrength(int signalStrength) {
      if (signalStrength >= 0 && signalStrength <= 15) {
         this.signalStrength = signalStrength;
      } else {
         throw new IllegalArgumentException("Signal strength out of range (" + signalStrength + "), must be in range [0,15]");
      }
   }
}
