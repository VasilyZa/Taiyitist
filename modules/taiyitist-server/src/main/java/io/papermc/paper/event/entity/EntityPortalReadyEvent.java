package io.papermc.paper.event.entity;

import org.bukkit.PortalType;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EntityPortalReadyEvent extends EntityEvent implements Cancellable {
   private static final HandlerList HANDLER_LIST = new HandlerList();
   private World targetWorld;
   private final PortalType portalType;
   private boolean cancelled;

   public EntityPortalReadyEvent(@NotNull Entity entity, @Nullable World targetWorld, @NotNull PortalType portalType) {
      super(entity);
      this.targetWorld = targetWorld;
      this.portalType = portalType;
   }

   @Nullable
   public World getTargetWorld() {
      return this.targetWorld;
   }

   public void setTargetWorld(@Nullable World targetWorld) {
      this.targetWorld = targetWorld;
   }

   @NotNull
   public PortalType getPortalType() {
      return this.portalType;
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
   @Override
   public HandlerList getHandlers() {
      return HANDLER_LIST;
   }

   @NotNull
   public static HandlerList getHandlerList() {
      return HANDLER_LIST;
   }
}
