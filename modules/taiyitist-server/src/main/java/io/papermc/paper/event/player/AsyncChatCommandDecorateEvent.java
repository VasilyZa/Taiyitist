package io.papermc.paper.event.player;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.Experimental;
import org.jetbrains.annotations.ApiStatus.Internal;

@Experimental
public class AsyncChatCommandDecorateEvent extends AsyncChatDecorateEvent {
   private static final HandlerList HANDLER_LIST = new HandlerList();

   @Internal
   public AsyncChatCommandDecorateEvent(boolean async, @Nullable Player player, @NotNull Component originalMessage, @NotNull Component result) {
      super(async, player, originalMessage, result);
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
