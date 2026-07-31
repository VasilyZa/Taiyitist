package io.papermc.paper.event.player;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.Internal;

public class PlayerChangeBeaconEffectEvent extends PlayerEvent implements Cancellable {
   private static final HandlerList HANDLER_LIST = new HandlerList();
   private PotionEffectType primary;
   private PotionEffectType secondary;
   private final Block beacon;
   private boolean consumeItem = true;
   private boolean isCancelled;

   @Internal
   public PlayerChangeBeaconEffectEvent(@NotNull Player player, @Nullable PotionEffectType primary, @Nullable PotionEffectType secondary, @NotNull Block beacon) {
      super(player);
      this.primary = primary;
      this.secondary = secondary;
      this.isCancelled = false;
      this.beacon = beacon;
   }

   @Nullable
   public PotionEffectType getPrimary() {
      return this.primary;
   }

   public void setPrimary(@Nullable PotionEffectType primary) {
      this.primary = primary;
   }

   @Nullable
   public PotionEffectType getSecondary() {
      return this.secondary;
   }

   public void setSecondary(@Nullable PotionEffectType secondary) {
      this.secondary = secondary;
   }

   @NotNull
   public Block getBeacon() {
      return this.beacon;
   }

   public boolean willConsumeItem() {
      return this.consumeItem;
   }

   public void setConsumeItem(boolean consumeItem) {
      this.consumeItem = consumeItem;
   }

   @Override
   public boolean isCancelled() {
      return this.isCancelled;
   }

   @Override
   public void setCancelled(boolean cancel) {
      this.isCancelled = cancel;
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
