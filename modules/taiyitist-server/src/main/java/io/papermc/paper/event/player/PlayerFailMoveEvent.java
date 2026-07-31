package io.papermc.paper.event.player;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerFailMoveEvent extends PlayerEvent {
   private static final HandlerList HANDLER_LIST = new HandlerList();
   private final PlayerFailMoveEvent.FailReason failReason;
   private boolean allowed;
   private boolean logWarning;
   private final Location from;
   private final Location to;

   public PlayerFailMoveEvent(
      @NotNull Player who,
      @NotNull PlayerFailMoveEvent.FailReason failReason,
      boolean allowed,
      boolean logWarning,
      @NotNull Location from,
      @NotNull Location to
   ) {
      super(who);
      this.failReason = failReason;
      this.allowed = allowed;
      this.logWarning = logWarning;
      this.from = from;
      this.to = to;
   }

   @NotNull
   public PlayerFailMoveEvent.FailReason getFailReason() {
      return this.failReason;
   }

   @NotNull
   public Location getFrom() {
      return this.from.clone();
   }

   @NotNull
   public Location getTo() {
      return this.to.clone();
   }

   public boolean isAllowed() {
      return this.allowed;
   }

   public void setAllowed(boolean allowed) {
      this.allowed = allowed;
   }

   public boolean getLogWarning() {
      return this.logWarning;
   }

   public void setLogWarning(boolean logWarning) {
      this.logWarning = logWarning;
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
      MOVED_INTO_UNLOADED_CHUNK,
      MOVED_TOO_QUICKLY,
      MOVED_WRONGLY,
      CLIPPED_INTO_BLOCK;
   }
}
