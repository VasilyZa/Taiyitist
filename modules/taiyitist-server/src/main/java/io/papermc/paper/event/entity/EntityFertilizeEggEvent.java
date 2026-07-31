package io.papermc.paper.event.entity;

import com.google.common.base.Preconditions;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EntityFertilizeEggEvent extends EntityEvent implements Cancellable {
   private static final HandlerList HANDLER_LIST = new HandlerList();
   private final LivingEntity mother;
   private final LivingEntity father;
   private final Player breeder;
   private final ItemStack bredWith;
   private int experience;
   private boolean cancel;

   public EntityFertilizeEggEvent(
      @NotNull LivingEntity mother, @NotNull LivingEntity father, @Nullable Player breeder, @Nullable ItemStack bredWith, int experience
   ) {
      super(mother);
      Preconditions.checkArgument(mother != null, "Cannot have null mother");
      Preconditions.checkArgument(father != null, "Cannot have null father");
      this.mother = mother;
      this.father = father;
      this.breeder = breeder;
      this.bredWith = bredWith;
      this.experience = experience;
   }

   @NotNull
   public LivingEntity getEntity() {
      return (LivingEntity)this.entity;
   }

   @NotNull
   public LivingEntity getMother() {
      return this.mother;
   }

   @NotNull
   public LivingEntity getFather() {
      return this.father;
   }

   @Nullable
   public Player getBreeder() {
      return this.breeder;
   }

   @Nullable
   public ItemStack getBredWith() {
      return this.bredWith;
   }

   public int getExperience() {
      return this.experience;
   }

   public void setExperience(int experience) {
      this.experience = experience;
   }

   @Override
   public boolean isCancelled() {
      return this.cancel;
   }

   @Override
   public void setCancelled(boolean cancel) {
      this.cancel = cancel;
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
