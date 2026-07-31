package io.papermc.paper.chat;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.ApiStatus.OverrideOnly;

@FunctionalInterface
public interface ChatRenderer {
   @OverrideOnly
   @NotNull
   Component render(@NotNull Player var1, @NotNull Component var2, @NotNull Component var3, @NotNull Audience var4);

   @NotNull
   static ChatRenderer defaultRenderer() {
      return new ViewerUnawareImpl.Default(
         (source, sourceDisplayName, message) -> Component.translatable("chat.type.text", new ComponentLike[]{sourceDisplayName, message})
      );
   }

   @NotNull
   static ChatRenderer viewerUnaware(@NotNull ChatRenderer.ViewerUnaware renderer) {
      return new ViewerUnawareImpl(renderer);
   }

   @Internal
   public sealed interface Default extends ChatRenderer, ChatRenderer.ViewerUnaware permits ViewerUnawareImpl.Default {
   }

   public interface ViewerUnaware {
      @OverrideOnly
      @NotNull
      Component render(@NotNull Player var1, @NotNull Component var2, @NotNull Component var3);
   }
}
