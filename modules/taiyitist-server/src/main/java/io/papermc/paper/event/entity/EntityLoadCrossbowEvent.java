package io.papermc.paper.event.entity;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

public class EntityLoadCrossbowEvent extends EntityEvent implements Cancellable {
   private static final HandlerList HANDLER_LIST = new HandlerList();
   private final ItemStack crossbow;
   private final EquipmentSlot hand;
   private boolean cancelled;
   private boolean consumeItem = true;

   @Internal
   public EntityLoadCrossbowEvent(@NotNull LivingEntity entity, @NotNull ItemStack crossbow, @NotNull EquipmentSlot hand) {
      super(entity);
      this.crossbow = crossbow;
      this.hand = hand;
   }

   @NotNull
   public LivingEntity getEntity() {
      return (LivingEntity)this.entity;
   }

   @NotNull
   public ItemStack getCrossbow() {
      return this.crossbow;
   }

   @NotNull
   public EquipmentSlot getHand() {
      return this.hand;
   }

   public boolean shouldConsumeItem() {
      return this.consumeItem;
   }

   public void setConsumeItem(boolean consume) {
      this.consumeItem = consume;
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
