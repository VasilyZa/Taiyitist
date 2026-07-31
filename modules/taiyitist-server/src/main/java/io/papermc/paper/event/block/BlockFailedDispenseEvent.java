package io.papermc.paper.event.block;

import org.bukkit.block.Block;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockEvent;
import org.jetbrains.annotations.NotNull;

public class BlockFailedDispenseEvent extends BlockEvent {
   private static final HandlerList handlers = new HandlerList();
   private boolean shouldPlayEffect = true;

   public BlockFailedDispenseEvent(@NotNull Block theBlock) {
      super(theBlock);
   }

   public boolean shouldPlayEffect() {
      return this.shouldPlayEffect;
   }

   public void shouldPlayEffect(boolean playEffect) {
      this.shouldPlayEffect = playEffect;
   }

   @Override
   public boolean callEvent() {
      super.callEvent();
      return this.shouldPlayEffect();
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
