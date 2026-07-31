package io.papermc.paper.event.entity;

import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class EntityDamageItemEvent extends EntityEvent implements Cancellable {
   private static final HandlerList HANDLER_LIST = new HandlerList();
   private final ItemStack item;
   private int damage;
   private boolean cancelled;

   public EntityDamageItemEvent(@NotNull Entity entity, @NotNull ItemStack item, int damage) {
      super(entity);
      this.item = item;
      this.damage = damage;
   }

   @NotNull
   public ItemStack getItem() {
      return this.item;
   }

   public int getDamage() {
      return this.damage;
   }

   public void setDamage(int damage) {
      this.damage = damage;
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
}
