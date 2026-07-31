package io.papermc.paper.event.player;

import org.apache.commons.lang3.Validate;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

public class PlayerPickItemEvent extends PlayerEvent implements Cancellable {
   private static final HandlerList HANDLER_LIST = new HandlerList();
   private int targetSlot;
   private int sourceSlot;
   private boolean cancelled;

   public PlayerPickItemEvent(@NotNull Player player, int targetSlot, int sourceSlot) {
      super(player);
      this.targetSlot = targetSlot;
      this.sourceSlot = sourceSlot;
   }

   @Range(
      from = 0L,
      to = 8L
   )
   public int getTargetSlot() {
      return this.targetSlot;
   }

   public void setTargetSlot(@Range(from = 0L,to = 8L) int targetSlot) {
      Validate.isTrue(targetSlot >= 0 && targetSlot <= 8, "Target slot must be in range 0 - 8 (inclusive)", new Object[0]);
      this.targetSlot = targetSlot;
   }

   @Range(
      from = 0L,
      to = 35L
   )
   public int getSourceSlot() {
      return this.sourceSlot;
   }

   public void setSourceSlot(@Range(from = 0L,to = 35L) int sourceSlot) {
      Validate.isTrue(sourceSlot >= 0 && sourceSlot <= 35, "Source slot must be in range of the players inventorys slot ids", new Object[0]);
      this.sourceSlot = sourceSlot;
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
      return HANDLER_LIST;
   }

   @NotNull
   public static HandlerList getHandlerList() {
      return HANDLER_LIST;
   }
}
