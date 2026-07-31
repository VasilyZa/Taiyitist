package io.papermc.paper.event.block;

import java.util.List;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class PlayerShearBlockEvent extends PlayerEvent implements Cancellable {
   private static final HandlerList handlers = new HandlerList();
   private boolean cancelled = false;
   private final Block block;
   private final ItemStack item;
   private final EquipmentSlot hand;
   private final List<ItemStack> drops;

   public PlayerShearBlockEvent(@NotNull Player who, @NotNull Block block, @NotNull ItemStack item, @NotNull EquipmentSlot hand, @NotNull List<ItemStack> drops) {
      super(who);
      this.block = block;
      this.item = item;
      this.hand = hand;
      this.drops = drops;
   }

   @NotNull
   public Block getBlock() {
      return this.block;
   }

   @NotNull
   public ItemStack getItem() {
      return this.item;
   }

   @NotNull
   public EquipmentSlot getHand() {
      return this.hand;
   }

   @NotNull
   public List<ItemStack> getDrops() {
      return this.drops;
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
      return handlers;
   }

   @NotNull
   public static HandlerList getHandlerList() {
      return handlers;
   }
}
