package io.papermc.paper.event.player;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

public class PrePlayerAttackEntityEvent extends PlayerEvent implements Cancellable {
   private static final HandlerList HANDLER_LIST = new HandlerList();
   @NotNull
   private final Entity attacked;
   private boolean cancelled;
   private final boolean willAttack;

   public PrePlayerAttackEntityEvent(@NotNull Player who, @NotNull Entity attacked, boolean willAttack) {
      super(who);
      this.attacked = attacked;
      this.willAttack = willAttack;
      this.cancelled = !willAttack;
   }

   @NotNull
   public Entity getAttacked() {
      return this.attacked;
   }

   public boolean willAttack() {
      return this.willAttack;
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

   @Override
   public boolean isCancelled() {
      return this.cancelled;
   }

   @Override
   public void setCancelled(boolean cancel) {
      if (this.willAttack) {
         this.cancelled = cancel;
      }
   }
}
