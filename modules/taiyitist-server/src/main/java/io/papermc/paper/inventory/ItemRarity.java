package io.papermc.paper.inventory;

import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.jetbrains.annotations.NotNull;

public enum ItemRarity {
   COMMON(NamedTextColor.WHITE),
   UNCOMMON(NamedTextColor.YELLOW),
   RARE(NamedTextColor.AQUA),
   EPIC(NamedTextColor.LIGHT_PURPLE);

   TextColor color;

   private ItemRarity(TextColor color) {
      this.color = color;
   }

   @NotNull
   public TextColor getColor() {
      return this.color;
   }
}
