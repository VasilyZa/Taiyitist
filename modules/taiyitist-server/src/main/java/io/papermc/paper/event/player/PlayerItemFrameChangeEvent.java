package io.papermc.paper.event.player;

import org.bukkit.Material;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerItemFrameChangeEvent extends PlayerEvent implements Cancellable {
   private static final HandlerList HANDLERS = new HandlerList();
   private boolean cancelled;
   private final ItemFrame itemFrame;
   private ItemStack itemStack;
   private final PlayerItemFrameChangeEvent.ItemFrameChangeAction action;

   public PlayerItemFrameChangeEvent(
      @NotNull Player player, @NotNull ItemFrame itemFrame, @NotNull ItemStack itemStack, @NotNull PlayerItemFrameChangeEvent.ItemFrameChangeAction action
   ) {
      super(player);
      this.itemFrame = itemFrame;
      this.itemStack = itemStack;
      this.action = action;
   }

   @NotNull
   public ItemFrame getItemFrame() {
      return this.itemFrame;
   }

   @NotNull
   public ItemStack getItemStack() {
      return this.itemStack;
   }

   public void setItemStack(@Nullable ItemStack itemStack) {
      this.itemStack = itemStack == null ? new ItemStack(Material.AIR) : itemStack;
   }

   @NotNull
   public PlayerItemFrameChangeEvent.ItemFrameChangeAction getAction() {
      return this.action;
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
      return HANDLERS;
   }

   @NotNull
   public static HandlerList getHandlerList() {
      return HANDLERS;
   }

   public static enum ItemFrameChangeAction {
      PLACE,
      REMOVE,
      ROTATE;
   }
}
