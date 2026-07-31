package io.papermc.paper.event.entity;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.event.entity.PotionSplashEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

public class WaterBottleSplashEvent extends PotionSplashEvent {
   @NotNull
   private final Set<LivingEntity> rehydrate;
   @NotNull
   private final Set<LivingEntity> extinguish;

   public WaterBottleSplashEvent(
      @NotNull ThrownPotion potion,
      @NotNull Map<LivingEntity, Double> affectedEntities,
      @NotNull Set<LivingEntity> rehydrate,
      @NotNull Set<LivingEntity> extinguish
   ) {
      super(potion, affectedEntities);
      this.rehydrate = rehydrate;
      this.extinguish = extinguish;
   }

   @NotNull
   @Unmodifiable
   public Collection<LivingEntity> getToDamage() {
      return this.affectedEntities.entrySet().stream().filter(entry -> entry.getValue() > 0.0).map(Entry::getKey).collect(Collectors.toUnmodifiableSet());
   }

   public void doNotDamageAsWaterSensitive(@NotNull LivingEntity entity) {
      this.affectedEntities.remove(entity);
   }

   public void damageAsWaterSensitive(@NotNull LivingEntity entity) {
      this.affectedEntities.put(entity, 1.0);
   }

   @NotNull
   public Collection<LivingEntity> getToRehydrate() {
      return this.rehydrate;
   }

   @NotNull
   public Collection<LivingEntity> getToExtinguish() {
      return this.extinguish;
   }

   @Deprecated
   @NotNull
   @Override
   public Collection<LivingEntity> getAffectedEntities() {
      return super.getAffectedEntities();
   }

   @Deprecated
   @Override
   public double getIntensity(@NotNull LivingEntity entity) {
      return super.getIntensity(entity);
   }

   @Deprecated
   @Override
   public void setIntensity(@NotNull LivingEntity entity, double intensity) {
      super.setIntensity(entity, intensity);
   }
}
