package io.papermc.paper.text;

import java.io.IOException;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.flattener.ComponentFlattener;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.kyori.adventure.text.serializer.plain.PlainComponentSerializer;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PaperComponents {
   private PaperComponents() {
      throw new RuntimeException("PaperComponents is not to be instantiated!");
   }

   @NotNull
   public static Component resolveWithContext(@NotNull Component input, @Nullable CommandSender context, @Nullable Entity scoreboardSubject) throws IOException {
      return resolveWithContext(input, context, scoreboardSubject, true);
   }

   @NotNull
   public static Component resolveWithContext(
      @NotNull Component input, @Nullable CommandSender context, @Nullable Entity scoreboardSubject, boolean bypassPermissions
   ) throws IOException {
      return Bukkit.getUnsafe().resolveWithContext(input, context, scoreboardSubject, bypassPermissions);
   }

   @NotNull
   public static ComponentFlattener flattener() {
      return Bukkit.getUnsafe().componentFlattener();
   }

   @Deprecated(
      forRemoval = true
   )
   @NotNull
   public static PlainComponentSerializer plainSerializer() {
      return Bukkit.getUnsafe().plainComponentSerializer();
   }

   @Deprecated(
      forRemoval = true
   )
   @NotNull
   public static PlainTextComponentSerializer plainTextSerializer() {
      return Bukkit.getUnsafe().plainTextSerializer();
   }

   @Deprecated(
      forRemoval = true
   )
   @NotNull
   public static GsonComponentSerializer gsonSerializer() {
      return Bukkit.getUnsafe().gsonComponentSerializer();
   }

   @Deprecated(
      forRemoval = true
   )
   @NotNull
   public static GsonComponentSerializer colorDownsamplingGsonSerializer() {
      return Bukkit.getUnsafe().colorDownsamplingGsonComponentSerializer();
   }

   @Deprecated(
      forRemoval = true
   )
   @NotNull
   public static LegacyComponentSerializer legacySectionSerializer() {
      return Bukkit.getUnsafe().legacyComponentSerializer();
   }
}
