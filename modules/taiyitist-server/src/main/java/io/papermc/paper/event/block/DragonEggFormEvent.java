package io.papermc.paper.event.block;

import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.boss.DragonBattle;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockFormEvent;
import org.jetbrains.annotations.NotNull;

public class DragonEggFormEvent extends BlockFormEvent implements Cancellable {
   private static final HandlerList handlers = new HandlerList();
   private final DragonBattle dragonBattle;
   private boolean cancelled;

   public DragonEggFormEvent(@NotNull Block block, @NotNull BlockState newState, @NotNull DragonBattle dragonBattle) {
      super(block, newState);
      this.dragonBattle = dragonBattle;
   }

   @Override
   public boolean isCancelled() {
      return this.cancelled;
   }

   @Override
   public void setCancelled(boolean cancelled) {
      this.cancelled = cancelled;
   }

   @NotNull
   public DragonBattle getDragonBattle() {
      return this.dragonBattle;
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
