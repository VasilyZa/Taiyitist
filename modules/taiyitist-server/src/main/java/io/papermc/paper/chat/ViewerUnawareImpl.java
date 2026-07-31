package io.papermc.paper.chat;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

sealed class ViewerUnawareImpl implements ChatRenderer, ChatRenderer.ViewerUnaware permits ViewerUnawareImpl.Default {
   private final ChatRenderer.ViewerUnaware unaware;
   @Nullable
   private Component message;

   ViewerUnawareImpl(ChatRenderer.ViewerUnaware unaware) {
      this.unaware = unaware;
   }

   @NotNull
   @Override
   public Component render(@NotNull Player source, @NotNull Component sourceDisplayName, @NotNull Component message, @NotNull Audience viewer) {
      return this.render(source, sourceDisplayName, message);
   }

   @NotNull
   @Override
   public Component render(@NotNull Player source, @NotNull Component sourceDisplayName, @NotNull Component message) {
      if (this.message == null) {
         this.message = this.unaware.render(source, sourceDisplayName, message);
      }

      return this.message;
   }

   static final class Default extends ViewerUnawareImpl implements ChatRenderer.Default {
      Default(ChatRenderer.ViewerUnaware unaware) {
         super(unaware);
      }
   }
}
