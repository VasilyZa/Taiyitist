package io.papermc.paper.potion;

import java.util.Objects;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.NonExtendable;

@NonExtendable
public class PotionMix implements Keyed {
   private final NamespacedKey key;
   private final ItemStack result;
   private final RecipeChoice input;
   private final RecipeChoice ingredient;

   public PotionMix(@NotNull NamespacedKey key, @NotNull ItemStack result, @NotNull RecipeChoice input, @NotNull RecipeChoice ingredient) {
      this.key = key;
      this.result = result;
      this.input = input;
      this.ingredient = ingredient;
   }

   @NotNull
   @Override
   public NamespacedKey getKey() {
      return this.key;
   }

   @NotNull
   public ItemStack getResult() {
      return this.result;
   }

   @NotNull
   public RecipeChoice getInput() {
      return this.input;
   }

   @NotNull
   public RecipeChoice getIngredient() {
      return this.ingredient;
   }

   @Override
   public String toString() {
      return "PotionMix{result=" + this.result + ", base=" + this.input + ", addition=" + this.ingredient + "}";
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (o != null && this.getClass() == o.getClass()) {
         PotionMix potionMix = (PotionMix)o;
         return this.key.equals(potionMix.key)
            && this.result.equals(potionMix.result)
            && this.input.equals(potionMix.input)
            && this.ingredient.equals(potionMix.ingredient);
      } else {
         return false;
      }
   }

   @Override
   public int hashCode() {
      return Objects.hash(this.key, this.result, this.input, this.ingredient);
   }
}
