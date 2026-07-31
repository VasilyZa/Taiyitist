package io.papermc.paper.event.entity;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Tameable;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityEvent;
import org.jetbrains.annotations.NotNull;

public class TameableDeathMessageEvent extends EntityEvent implements Cancellable {
   private static final HandlerList handlers = new HandlerList();
   private boolean cancelled;
   private Component deathMessage;

   public TameableDeathMessageEvent(@NotNull Tameable what, @NotNull Component deathMessage) {
      super(what);
      this.deathMessage = deathMessage;
   }

   public void deathMessage(@NotNull Component deathMessage) {
      this.deathMessage = deathMessage;
   }

   @NotNull
   public Component deathMessage() {
      return this.deathMessage;
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
   public Tameable getEntity() {
      return (Tameable)super.getEntity();
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
