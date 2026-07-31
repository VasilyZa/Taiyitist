package io.papermc.paper.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class PlayerStopUsingItemEvent extends PlayerEvent {
   private static final HandlerList handlers = new HandlerList();
   @NotNull
   private final ItemStack item;
   private final int ticksHeldFor;

   public PlayerStopUsingItemEvent(@NotNull Player player, @NotNull ItemStack item, int ticksHeldFor) {
      super(player);
      this.item = item;
      this.ticksHeldFor = ticksHeldFor;
   }

   @NotNull
   public ItemStack getItem() {
      return this.item;
   }

   public int getTicksHeldFor() {
      return this.ticksHeldFor;
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
