package io.papermc.paper.enchantments;

public enum EnchantmentRarity {
   COMMON(10),
   UNCOMMON(5),
   RARE(2),
   VERY_RARE(1);

   private final int weight;

   private EnchantmentRarity(int weight) {
      this.weight = weight;
   }

   public int getWeight() {
      return this.weight;
   }
}
