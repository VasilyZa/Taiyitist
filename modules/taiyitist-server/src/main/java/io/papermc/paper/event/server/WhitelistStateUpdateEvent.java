package io.papermc.paper.event.server;

import com.destroystokyo.paper.profile.PlayerProfile;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class WhitelistStateUpdateEvent extends Event implements Cancellable {
   private static final HandlerList HANDLER_LIST = new HandlerList();
   private boolean cancel = false;
   @NotNull
   private final PlayerProfile playerProfile;
   @NotNull
   private final WhitelistStateUpdateEvent.WhitelistStatus status;

   public WhitelistStateUpdateEvent(@NotNull PlayerProfile who, @NotNull WhitelistStateUpdateEvent.WhitelistStatus status) {
      this.playerProfile = who;
      this.status = status;
   }

   @NotNull
   public OfflinePlayer getPlayer() {
      return Bukkit.getOfflinePlayer(this.playerProfile.getId());
   }

   @NotNull
   public PlayerProfile getPlayerProfile() {
      return this.playerProfile;
   }

   @NotNull
   public WhitelistStateUpdateEvent.WhitelistStatus getStatus() {
      return this.status;
   }

   @Override
   public boolean isCancelled() {
      return this.cancel;
   }

   @Override
   public void setCancelled(boolean cancel) {
      this.cancel = cancel;
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

   public static enum WhitelistStatus {
      ADDED,
      REMOVED;
   }
}
