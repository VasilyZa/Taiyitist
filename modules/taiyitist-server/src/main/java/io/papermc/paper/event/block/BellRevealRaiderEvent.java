package io.papermc.paper.event.block;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Raider;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockEvent;
import org.jetbrains.annotations.NotNull;

@Deprecated
public class BellRevealRaiderEvent extends BlockEvent implements Cancellable {
   private static final HandlerList handlers = new HandlerList();
   private boolean cancelled = false;
   private final Raider raider;

   public BellRevealRaiderEvent(@NotNull Block theBlock, @NotNull Entity raider) {
      super(theBlock);
      this.raider = (Raider)raider;
   }

   @NotNull
   public Raider getEntity() {
      return this.raider;
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
