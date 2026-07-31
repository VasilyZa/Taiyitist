package io.papermc.paper.event.player;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.server.ServerEvent;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.Experimental;
import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.ApiStatus.ScheduledForRemoval;

@Experimental
public class AsyncChatDecorateEvent extends ServerEvent implements Cancellable {
   private static final HandlerList HANDLER_LIST = new HandlerList();
   private final Player player;
   private final Component originalMessage;
   private Component result;
   private boolean cancelled;

   @Internal
   public AsyncChatDecorateEvent(boolean async, @Nullable Player player, @NotNull Component originalMessage, @NotNull Component result) {
      super(async);
      this.player = player;
      this.originalMessage = originalMessage;
      this.result = result;
   }

   @Nullable
   public Player player() {
      return this.player;
   }

   @NotNull
   public Component originalMessage() {
      return this.originalMessage;
   }

   @NotNull
   public Component result() {
      return this.result;
   }

   public void result(@NotNull Component result) {
      this.result = result;
   }

   @Deprecated(
      forRemoval = true
   )
   @ScheduledForRemoval(
      inVersion = "1.21"
   )
   @Contract(
      value = "-> false",
      pure = true
   )
   public boolean isPreview() {
      return false;
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
