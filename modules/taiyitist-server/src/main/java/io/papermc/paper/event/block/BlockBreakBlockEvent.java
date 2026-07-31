package io.papermc.paper.event.block;

import java.util.List;
import org.bukkit.block.Block;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class BlockBreakBlockEvent extends BlockEvent {
   private static final HandlerList HANDLER_LIST = new HandlerList();
   private final List<ItemStack> drops;
   private final Block source;

   public BlockBreakBlockEvent(@NotNull Block block, @NotNull Block source, @NotNull List<ItemStack> drops) {
      super(block);
      this.source = source;
      this.drops = drops;
   }

   @NotNull
   public List<ItemStack> getDrops() {
      return this.drops;
   }

   @NotNull
   public Block getSource() {
      return this.source;
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
