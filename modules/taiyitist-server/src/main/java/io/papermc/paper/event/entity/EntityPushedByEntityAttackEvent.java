package io.papermc.paper.event.entity;

import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityEvent;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

public class EntityPushedByEntityAttackEvent extends EntityEvent implements Cancellable {
   private static final HandlerList handlers = new HandlerList();
   @NotNull
   private final Entity pushedBy;
   @NotNull
   private final Vector acceleration;
   private boolean cancelled = false;

   public EntityPushedByEntityAttackEvent(@NotNull Entity entity, @NotNull Entity pushedBy, @NotNull Vector acceleration) {
      super(entity);
      this.pushedBy = pushedBy;
      this.acceleration = acceleration;
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

   @Override
   public boolean isCancelled() {
      return this.cancelled;
   }

   @Override
   public void setCancelled(boolean cancel) {
      this.cancelled = cancel;
   }

   @NotNull
   public Entity getPushedBy() {
      return this.pushedBy;
   }

   @NotNull
   public Vector getAcceleration() {
      return this.acceleration;
   }
}
