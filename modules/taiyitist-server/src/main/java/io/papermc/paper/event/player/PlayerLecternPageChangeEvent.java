package io.papermc.paper.event.player;

import org.bukkit.block.Lectern;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class PlayerLecternPageChangeEvent extends PlayerEvent implements Cancellable {
   private static final HandlerList HANDLER_LIST = new HandlerList();
   private boolean cancelled;
   private final Lectern lectern;
   private final ItemStack book;
   private final PlayerLecternPageChangeEvent.PageChangeDirection pageChangeDirection;
   private final int oldPage;
   private int newPage;

   public PlayerLecternPageChangeEvent(
      @NotNull Player player,
      @NotNull Lectern lectern,
      @NotNull ItemStack book,
      @NotNull PlayerLecternPageChangeEvent.PageChangeDirection pageChangeDirection,
      int oldPage,
      int newPage
   ) {
      super(player);
      this.lectern = lectern;
      this.book = book;
      this.pageChangeDirection = pageChangeDirection;
      this.oldPage = oldPage;
      this.newPage = newPage;
   }

   @NotNull
   public Lectern getLectern() {
      return this.lectern;
   }

   @NotNull
   public ItemStack getBook() {
      return this.book;
   }

   @NotNull
   public PlayerLecternPageChangeEvent.PageChangeDirection getPageChangeDirection() {
      return this.pageChangeDirection;
   }

   public int getOldPage() {
      return this.oldPage;
   }

   public int getNewPage() {
      return this.newPage;
   }

   public void setNewPage(int newPage) {
      this.newPage = newPage;
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
      return HANDLER_LIST;
   }

   @NotNull
   public static HandlerList getHandlerList() {
      return HANDLER_LIST;
   }

   public static enum PageChangeDirection {
      LEFT,
      RIGHT;
   }
}
