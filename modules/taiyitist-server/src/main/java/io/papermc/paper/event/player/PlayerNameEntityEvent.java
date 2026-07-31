package io.papermc.paper.event.player;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerNameEntityEvent extends PlayerEvent implements Cancellable {
   private LivingEntity entity;
   private Component name;
   private boolean persistent;
   private boolean cancelled;
   private static final HandlerList HANDLER_LIST = new HandlerList();

   public PlayerNameEntityEvent(@NotNull Player player, @NotNull LivingEntity entity, @NotNull Component name, boolean persistent) {
      super(player);
      this.entity = entity;
      this.name = name;
      this.persistent = persistent;
   }

   @Nullable
   public Component getName() {
      return this.name;
   }

   public void setName(@Nullable Component name) {
      this.name = name;
   }

   @NotNull
   public LivingEntity getEntity() {
      return this.entity;
   }

   public void setEntity(@NotNull LivingEntity entity) {
      this.entity = entity;
   }

   public boolean isPersistent() {
      return this.persistent;
   }

   public void setPersistent(boolean persistent) {
      this.persistent = persistent;
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
