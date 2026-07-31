package io.papermc.paper.event.player;

import com.google.common.base.Preconditions;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerItemCooldownEvent extends PlayerEvent implements Cancellable {
   private static final HandlerList handlers = new HandlerList();
   @NotNull
   private final Material type;
   private boolean cancelled;
   private int cooldown;

   public PlayerItemCooldownEvent(@NotNull Player player, @NotNull Material type, int cooldown) {
      super(player);
      this.type = type;
      this.cooldown = cooldown;
   }

   @NotNull
   public Material getType() {
      return this.type;
   }

   public int getCooldown() {
      return this.cooldown;
   }

   public void setCooldown(int cooldown) {
      Preconditions.checkArgument(cooldown >= 0, "The cooldown has to be equal to or greater than 0!");
      this.cooldown = cooldown;
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
      return handlers;
   }

   @NotNull
   public static HandlerList getHandlerList() {
      return handlers;
   }
}
