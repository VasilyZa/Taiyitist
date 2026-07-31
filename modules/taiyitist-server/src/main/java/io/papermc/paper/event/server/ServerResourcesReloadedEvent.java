package io.papermc.paper.event.server;

import org.bukkit.event.HandlerList;
import org.bukkit.event.server.ServerEvent;
import org.jetbrains.annotations.NotNull;

public class ServerResourcesReloadedEvent extends ServerEvent {
   public static final HandlerList HANDLER_LIST = new HandlerList();
   private final ServerResourcesReloadedEvent.Cause cause;

   public ServerResourcesReloadedEvent(@NotNull ServerResourcesReloadedEvent.Cause cause) {
      this.cause = cause;
   }

   @NotNull
   public ServerResourcesReloadedEvent.Cause getCause() {
      return this.cause;
   }

   @NotNull
   public static HandlerList getHandlerList() {
      return HANDLER_LIST;
   }

   @NotNull
   @Override
   public HandlerList getHandlers() {
      return HANDLER_LIST;
   }

   public static enum Cause {
      COMMAND,
      PLUGIN;
   }
}
