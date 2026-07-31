package io.papermc.paper.event.player;

import java.util.Set;
import org.bukkit.block.Sign;
import org.bukkit.block.sign.Side;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class PlayerSignCommandPreprocessEvent extends PlayerCommandPreprocessEvent {
   private final Sign sign;
   private final Side side;

   @Internal
   public PlayerSignCommandPreprocessEvent(
      @NotNull Player player, @NotNull String message, @NotNull Set<Player> recipients, @NotNull Sign sign, @NotNull Side side
   ) {
      super(player, message, recipients);
      this.sign = sign;
      this.side = side;
   }

   @NotNull
   public Sign getSign() {
      return this.sign;
   }

   @NotNull
   public Side getSide() {
      return this.side;
   }
}
