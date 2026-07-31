package io.papermc.paper.event.entity;

import com.google.common.base.Preconditions;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityEvent;
import org.jetbrains.annotations.NotNull;

public class EntityMoveEvent extends EntityEvent implements Cancellable {
   private static final HandlerList handlers = new HandlerList();
   private boolean canceled;
   private Location from;
   private Location to;

   public EntityMoveEvent(@NotNull LivingEntity entity, @NotNull Location from, @NotNull Location to) {
      super(entity);
      this.from = from;
      this.to = to;
   }

   @NotNull
   public LivingEntity getEntity() {
      return (LivingEntity)this.entity;
   }

   @Override
   public boolean isCancelled() {
      return this.canceled;
   }

   @Override
   public void setCancelled(boolean cancel) {
      this.canceled = cancel;
   }

   @NotNull
   public Location getFrom() {
      return this.from;
   }

   public void setFrom(@NotNull Location from) {
      this.validateLocation(from);
      this.from = from;
   }

   @NotNull
   public Location getTo() {
      return this.to;
   }

   public void setTo(@NotNull Location to) {
      this.validateLocation(to);
      this.to = to;
   }

   public boolean hasChangedPosition() {
      return this.hasExplicitlyChangedPosition() || !this.from.getWorld().equals(this.to.getWorld());
   }

   public boolean hasExplicitlyChangedPosition() {
      return this.from.getX() != this.to.getX() || this.from.getY() != this.to.getY() || this.from.getZ() != this.to.getZ();
   }

   public boolean hasChangedBlock() {
      return this.hasExplicitlyChangedBlock() || !this.from.getWorld().equals(this.to.getWorld());
   }

   public boolean hasExplicitlyChangedBlock() {
      return this.from.getBlockX() != this.to.getBlockX() || this.from.getBlockY() != this.to.getBlockY() || this.from.getBlockZ() != this.to.getBlockZ();
   }

   public boolean hasChangedOrientation() {
      return this.from.getPitch() != this.to.getPitch() || this.from.getYaw() != this.to.getYaw();
   }

   private void validateLocation(@NotNull Location loc) {
      Preconditions.checkArgument(loc != null, "Cannot use null location!");
      Preconditions.checkArgument(loc.getWorld() != null, "Cannot use null location with null world!");
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
}
