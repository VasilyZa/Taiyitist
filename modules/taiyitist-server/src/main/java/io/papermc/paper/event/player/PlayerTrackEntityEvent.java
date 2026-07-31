package io.papermc.paper.event.player;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerTrackEntityEvent extends PlayerEvent implements Cancellable {
   private static final HandlerList handlers = new HandlerList();
   private final Entity entity;
   private boolean cancelled;

   public PlayerTrackEntityEvent(@NotNull Player player, @NotNull Entity entity) {
      super(player);
      this.entity = entity;
   }

   @NotNull
   public static HandlerList getHandlerList() {
      return handlers;
   }

   @NotNull
   @Override
   public HandlerList getHandlers() {
      return handlers;
   }

   @NotNull
   public Entity getEntity() {
      return this.entity;
   }

   @Override
   public boolean isCancelled() {
      return this.cancelled;
   }

   @Override
   public void setCancelled(boolean cancel) {
      this.cancelled = cancel;
   }
}
