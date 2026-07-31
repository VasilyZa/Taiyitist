package io.papermc.paper.event.entity;

import org.bukkit.DyeColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EntityDyeEvent extends EntityEvent implements Cancellable {
   private static final HandlerList HANDLER_LIST = new HandlerList();
   private DyeColor dyeColor;
   private final Player player;
   private boolean cancel;

   public EntityDyeEvent(@NotNull Entity entity, @NotNull DyeColor dyeColor, @Nullable Player player) {
      super(entity);
      this.dyeColor = dyeColor;
      this.player = player;
   }

   @NotNull
   public DyeColor getColor() {
      return this.dyeColor;
   }

   public void setColor(@NotNull DyeColor dyeColor) {
      this.dyeColor = dyeColor;
   }

   @Nullable
   public Player getPlayer() {
      return this.player;
   }

   @Override
   public boolean isCancelled() {
      return this.cancel;
   }

   @Override
   public void setCancelled(boolean cancel) {
      this.cancel = cancel;
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
