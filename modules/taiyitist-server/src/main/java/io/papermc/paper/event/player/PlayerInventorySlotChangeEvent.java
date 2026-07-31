package io.papermc.paper.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class PlayerInventorySlotChangeEvent extends PlayerEvent {
   private static final HandlerList handlers = new HandlerList();
   private final int rawSlot;
   private final int slot;
   private final ItemStack oldItemStack;
   private final ItemStack newItemStack;
   private boolean triggerAdvancements = true;

   public PlayerInventorySlotChangeEvent(@NotNull Player player, int rawSlot, @NotNull ItemStack oldItemStack, @NotNull ItemStack newItemStack) {
      super(player);
      this.rawSlot = rawSlot;
      this.slot = player.getOpenInventory().convertSlot(rawSlot);
      this.oldItemStack = oldItemStack;
      this.newItemStack = newItemStack;
   }

   public int getRawSlot() {
      return this.rawSlot;
   }

   public int getSlot() {
      return this.slot;
   }

   @NotNull
   public ItemStack getOldItemStack() {
      return this.oldItemStack;
   }

   @NotNull
   public ItemStack getNewItemStack() {
      return this.newItemStack;
   }

   public boolean shouldTriggerAdvancements() {
      return this.triggerAdvancements;
   }

   public void setShouldTriggerAdvancements(boolean triggerAdvancements) {
      this.triggerAdvancements = triggerAdvancements;
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
