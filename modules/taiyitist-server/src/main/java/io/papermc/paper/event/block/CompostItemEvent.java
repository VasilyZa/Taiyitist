package io.papermc.paper.event.block;

import org.bukkit.block.Block;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class CompostItemEvent extends BlockEvent {
   private static final HandlerList HANDLER_LIST = new HandlerList();
   private final ItemStack item;
   private boolean willRaiseLevel;

   public CompostItemEvent(@NotNull Block composter, @NotNull ItemStack item, boolean willRaiseLevel) {
      super(composter);
      this.item = item;
      this.willRaiseLevel = willRaiseLevel;
   }

   @NotNull
   public ItemStack getItem() {
      return this.item;
   }

   public boolean willRaiseLevel() {
      return this.willRaiseLevel;
   }

   public void setWillRaiseLevel(boolean willRaiseLevel) {
      this.willRaiseLevel = willRaiseLevel;
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
