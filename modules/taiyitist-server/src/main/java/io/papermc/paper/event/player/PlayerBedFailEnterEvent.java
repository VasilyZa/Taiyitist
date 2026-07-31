package io.papermc.paper.event.player;

import net.kyori.adventure.text.Component;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerBedFailEnterEvent extends PlayerEvent implements Cancellable {
   private static final HandlerList HANDLER_LIST = new HandlerList();
   private final PlayerBedFailEnterEvent.FailReason failReason;
   private final Block bed;
   private boolean willExplode;
   private Component message;
   private boolean cancelled;

   public PlayerBedFailEnterEvent(
      @NotNull Player player, @NotNull PlayerBedFailEnterEvent.FailReason failReason, @NotNull Block bed, boolean willExplode, @Nullable Component message
   ) {
      super(player);
      this.failReason = failReason;
      this.bed = bed;
      this.willExplode = willExplode;
      this.message = message;
   }

   @NotNull
   public PlayerBedFailEnterEvent.FailReason getFailReason() {
      return this.failReason;
   }

   @NotNull
   public Block getBed() {
      return this.bed;
   }

   public boolean getWillExplode() {
      return this.willExplode;
   }

   public void setWillExplode(boolean willExplode) {
      this.willExplode = willExplode;
   }

   @Nullable
   public Component getMessage() {
      return this.message;
   }

   public void setMessage(@Nullable Component message) {
      this.message = message;
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

   public static enum FailReason {
      NOT_POSSIBLE_HERE,
      NOT_POSSIBLE_NOW,
      TOO_FAR_AWAY,
      OBSTRUCTED,
      OTHER_PROBLEM,
      NOT_SAFE;

      public static final PlayerBedFailEnterEvent.FailReason[] VALUES = values();
   }
}
