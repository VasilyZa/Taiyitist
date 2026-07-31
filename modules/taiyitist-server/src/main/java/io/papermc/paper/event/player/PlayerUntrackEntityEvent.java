package io.papermc.paper.event.player;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerUntrackEntityEvent extends PlayerEvent {
   private static final HandlerList handlers = new HandlerList();
   private final Entity entity;

   public PlayerUntrackEntityEvent(@NotNull Player player, @NotNull Entity entity) {
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
}
