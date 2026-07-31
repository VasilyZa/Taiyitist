package io.papermc.paper.event.block;

import org.bukkit.block.Beacon;
import org.bukkit.block.Block;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockEvent;
import org.jetbrains.annotations.NotNull;

public class BeaconActivatedEvent extends BlockEvent {
   private static final HandlerList handlers = new HandlerList();

   public BeaconActivatedEvent(@NotNull Block block) {
      super(block);
   }

   @NotNull
   public Beacon getBeacon() {
      return (Beacon)this.block.getState();
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
