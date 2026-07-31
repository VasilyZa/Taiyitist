package io.papermc.paper.advancement;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.translation.Translatable;
import net.kyori.adventure.util.Index;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface AdvancementDisplay {
   @NotNull
   AdvancementDisplay.Frame frame();

   @NotNull
   Component title();

   @NotNull
   Component description();

   @NotNull
   ItemStack icon();

   boolean doesShowToast();

   boolean doesAnnounceToChat();

   boolean isHidden();

   @Nullable
   NamespacedKey backgroundPath();

   @NotNull
   Component displayName();

   public static enum Frame implements Translatable {
      CHALLENGE("challenge", NamedTextColor.DARK_PURPLE),
      GOAL("goal", NamedTextColor.GREEN),
      TASK("task", NamedTextColor.GREEN);

      public static final Index<String, AdvancementDisplay.Frame> NAMES = Index.create(AdvancementDisplay.Frame.class, frame -> frame.name);
      private final String name;
      private final TextColor color;

      private Frame(String name, TextColor color) {
         this.name = name;
         this.color = color;
      }

      @NotNull
      public TextColor color() {
         return this.color;
      }

      @NotNull
      public String translationKey() {
         return "advancements.toast." + this.name;
      }
   }
}
