package io.papermc.paper.event.player;

import java.util.Objects;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.MerchantRecipe;
import org.jetbrains.annotations.NotNull;

public class PlayerPurchaseEvent extends PlayerEvent implements Cancellable {
   private static final HandlerList handlers = new HandlerList();
   private boolean cancelled;
   private boolean increaseTradeUses;
   private boolean rewardExp;
   private MerchantRecipe trade;

   public PlayerPurchaseEvent(@NotNull Player player, @NotNull MerchantRecipe trade, boolean rewardExp, boolean increaseTradeUses) {
      super(Objects.requireNonNull(player, "Player cannot be null!"));
      this.setTrade(trade);
      this.rewardExp = rewardExp;
      this.increaseTradeUses = increaseTradeUses;
   }

   @NotNull
   public MerchantRecipe getTrade() {
      return this.trade;
   }

   public void setTrade(@NotNull MerchantRecipe trade) {
      this.trade = Objects.requireNonNull(trade, "Trade cannot be null!");
   }

   public boolean isRewardingExp() {
      return this.rewardExp;
   }

   public void setRewardExp(boolean rewardExp) {
      this.rewardExp = rewardExp;
   }

   public boolean willIncreaseTradeUses() {
      return this.increaseTradeUses;
   }

   public void setIncreaseTradeUses(boolean increaseTradeUses) {
      this.increaseTradeUses = increaseTradeUses;
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
