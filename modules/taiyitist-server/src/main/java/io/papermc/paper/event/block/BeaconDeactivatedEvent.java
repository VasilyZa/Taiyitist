package io.papermc.paper.event.block;

import org.bukkit.Material;
import org.bukkit.block.Beacon;
import org.bukkit.block.Block;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BeaconDeactivatedEvent extends BlockEvent {
   private static final HandlerList handlers = new HandlerList();

   public BeaconDeactivatedEvent(@NotNull Block block) {
      super(block);
   }

   @Nullable
   public Beacon getBeacon() {
      return this.block.getType() == Material.BEACON ? (Beacon)this.block.getState() : null;
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
