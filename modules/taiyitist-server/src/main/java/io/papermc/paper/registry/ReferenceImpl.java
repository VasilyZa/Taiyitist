package io.papermc.paper.registry;

import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

record ReferenceImpl<T extends Keyed>(@NotNull Registry<T> registry, @NotNull NamespacedKey key) implements Reference<T> {
   @NotNull
   @Override
   public T value() {
      return this.registry.get(this.key);
   }

   @Nullable
   @Override
   public T valueOrNull() {
      return this.registry.get(this.key);
   }

   @NotNull
   @Override
   public NamespacedKey getKey() {
      return this.key;
   }
}
