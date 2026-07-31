package io.papermc.paper.event.entity;

import org.bukkit.entity.PufferFish;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityEvent;
import org.jetbrains.annotations.NotNull;

public class PufferFishStateChangeEvent extends EntityEvent implements Cancellable {
   private static final HandlerList handlers = new HandlerList();
   private boolean cancelled;
   private int newPuffState;

   public PufferFishStateChangeEvent(@NotNull PufferFish entity, int newPuffState) {
      super(entity);
      this.newPuffState = newPuffState;
   }

   @NotNull
   public PufferFish getEntity() {
      return (PufferFish)this.entity;
   }

   public int getNewPuffState() {
      return this.newPuffState;
   }

   public boolean isInflating() {
      return this.getNewPuffState() > this.getEntity().getPuffState();
   }

   public boolean isDeflating() {
      return this.getNewPuffState() < this.getEntity().getPuffState();
   }

   @Override
   public void setCancelled(boolean cancel) {
      this.cancelled = cancel;
   }

   @Override
   public boolean isCancelled() {
      return this.cancelled;
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
