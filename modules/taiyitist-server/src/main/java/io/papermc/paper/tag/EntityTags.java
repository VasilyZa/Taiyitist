package io.papermc.paper.tag;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.EntityType;

public class EntityTags {
   public static final EntitySetTag UNDEADS = new EntitySetTag(keyFor("undeads"))
      .add(
         new EntityType[]{
            EntityType.DROWNED,
            EntityType.HUSK,
            EntityType.PHANTOM,
            EntityType.SKELETON,
            EntityType.SKELETON_HORSE,
            EntityType.STRAY,
            EntityType.WITHER,
            EntityType.WITHER_SKELETON,
            EntityType.ZOGLIN,
            EntityType.ZOMBIE,
            EntityType.ZOMBIE_HORSE,
            EntityType.ZOMBIE_VILLAGER,
            EntityType.ZOMBIFIED_PIGLIN
         }
      )
      .ensureSize("UNDEADS", 13)
      .lock();
   public static final EntitySetTag HORSES = new EntitySetTag(keyFor("horses")).contains("HORSE").ensureSize("HORSES", 3).lock();
   public static final EntitySetTag MINECARTS = new EntitySetTag(keyFor("minecarts")).contains("MINECART").ensureSize("MINECARTS", 7).lock();
   public static final EntitySetTag SPLITTING_MOBS = new EntitySetTag(keyFor("splitting_mobs"))
      .add(new EntityType[]{EntityType.SLIME, EntityType.MAGMA_CUBE})
      .ensureSize("SLIMES", 2)
      .lock();
   public static final EntitySetTag WATER_BASED = new EntitySetTag(keyFor("water_based"))
      .add(
         new EntityType[]{
            EntityType.AXOLOTL,
            EntityType.DOLPHIN,
            EntityType.SQUID,
            EntityType.GLOW_SQUID,
            EntityType.GUARDIAN,
            EntityType.ELDER_GUARDIAN,
            EntityType.TURTLE,
            EntityType.COD,
            EntityType.SALMON,
            EntityType.PUFFERFISH,
            EntityType.TROPICAL_FISH
         }
      )
      .ensureSize("WATER_BASED", 11)
      .lock();

   private static NamespacedKey keyFor(String key) {
      return new NamespacedKey("paper", key + "_settag");
   }
}
