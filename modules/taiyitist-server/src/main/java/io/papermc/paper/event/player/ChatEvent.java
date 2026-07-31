package io.papermc.paper.event.player;

import io.papermc.paper.chat.ChatRenderer;
import java.util.Set;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.chat.SignedMessage;
import net.kyori.adventure.text.Component;
import org.bukkit.Warning;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

@Deprecated
@Warning(
   reason = "Listening to this event forces chat to wait for the main thread, delaying chat messages."
)
public final class ChatEvent extends AbstractChatEvent {
   private static final HandlerList HANDLERS = new HandlerList();

   @Internal
   public ChatEvent(
      @NotNull Player player,
      @NotNull Set<Audience> viewers,
      @NotNull ChatRenderer renderer,
      @NotNull Component message,
      @NotNull Component originalMessage,
      @NotNull SignedMessage signedMessage
   ) {
      super(false, player, viewers, renderer, message, originalMessage, signedMessage);
   }

   @NotNull
   @Override
   public HandlerList getHandlers() {
      return HANDLERS;
   }

   @NotNull
   public static HandlerList getHandlerList() {
      return HANDLERS;
   }
}
