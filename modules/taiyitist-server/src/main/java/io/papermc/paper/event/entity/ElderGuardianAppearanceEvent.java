package io.papermc.paper.event.entity;

import org.bukkit.entity.ElderGuardian;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityEvent;
import org.jetbrains.annotations.NotNull;

public class ElderGuardianAppearanceEvent extends EntityEvent implements Cancellable {
   private static final HandlerList handlers = new HandlerList();
   private boolean cancelled;
   private final Player affectedPlayer;

   public ElderGuardianAppearanceEvent(@NotNull Entity what, @NotNull Player affectedPlayer) {
      super(what);
      this.affectedPlayer = affectedPlayer;
   }

   @NotNull
   public Player getAffectedPlayer() {
      return this.affectedPlayer;
   }

   @NotNull
   public ElderGuardian getEntity() {
      return (ElderGuardian)this.entity;
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
