package io.papermc.paper.event.entity;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Warden;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class WardenAngerChangeEvent extends EntityEvent implements Cancellable {
   private static final HandlerList HANDLER_LIST = new HandlerList();
   private boolean cancelled;
   private final Entity target;
   private final int oldAnger;
   private int newAnger;

   @Internal
   public WardenAngerChangeEvent(@NotNull Warden warden, @NotNull Entity target, int oldAnger, int newAnger) {
      super(warden);
      this.target = target;
      this.oldAnger = oldAnger;
      this.newAnger = newAnger;
   }

   @NotNull
   public Entity getTarget() {
      return this.target;
   }

   public int getOldAnger() {
      return this.oldAnger;
   }

   public int getNewAnger() {
      return this.newAnger;
   }

   public void setNewAnger(int newAnger) {
      if (newAnger > 150) {
         throw new IllegalArgumentException("newAnger must not be greater than 150");
      } else {
         this.newAnger = newAnger;
      }
   }

   @NotNull
   public Warden getEntity() {
      return (Warden)this.entity;
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
      return HANDLER_LIST;
   }

   @NotNull
   public static HandlerList getHandlerList() {
      return HANDLER_LIST;
   }
}
