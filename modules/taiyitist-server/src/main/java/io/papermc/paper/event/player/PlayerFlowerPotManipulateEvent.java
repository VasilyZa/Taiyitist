package io.papermc.paper.event.player;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class PlayerFlowerPotManipulateEvent extends PlayerEvent implements Cancellable {
   private static final HandlerList handlers = new HandlerList();
   @NotNull
   private final Block flowerpot;
   @NotNull
   private final ItemStack item;
   private final boolean placing;
   private boolean cancel = false;

   public PlayerFlowerPotManipulateEvent(@NotNull Player player, @NotNull Block flowerpot, @NotNull ItemStack item, boolean placing) {
      super(player);
      this.flowerpot = flowerpot;
      this.item = item;
      this.placing = placing;
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
   public Block getFlowerpot() {
      return this.flowerpot;
   }

   @NotNull
   public ItemStack getItem() {
      return this.item;
   }

   public boolean isPlacing() {
      return this.placing;
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
