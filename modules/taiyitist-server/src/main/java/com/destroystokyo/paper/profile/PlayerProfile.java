package com.destroystokyo.paper.profile;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import org.bukkit.profile.PlayerTextures;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface PlayerProfile extends org.bukkit.profile.PlayerProfile {
   @Nullable
   @Override
   String getName();

   @Deprecated(
      forRemoval = true
   )
   @NotNull
   String setName(@Nullable String var1);

   @Nullable
   UUID getId();

   @Deprecated(
      forRemoval = true
   )
   @Nullable
   UUID setId(@Nullable UUID var1);

   @NotNull
   @Override
   PlayerTextures getTextures();

   @Override
   void setTextures(@Nullable PlayerTextures var1);

   @NotNull
   Set<ProfileProperty> getProperties();

   boolean hasProperty(@Nullable String var1);

   void setProperty(@NotNull ProfileProperty var1);

   void setProperties(@NotNull Collection<ProfileProperty> var1);

   boolean removeProperty(@Nullable String var1);

   default boolean removeProperty(@NotNull ProfileProperty property) {
      return this.removeProperty(property.getName());
   }

   default boolean removeProperties(@NotNull Collection<ProfileProperty> properties) {
      boolean removed = false;

      for (ProfileProperty property : properties) {
         if (this.removeProperty(property)) {
            removed = true;
         }
      }

      return removed;
   }

   void clearProperties();

   @Override
   boolean isComplete();

   boolean completeFromCache();

   boolean completeFromCache(boolean var1);

   boolean completeFromCache(boolean var1, boolean var2);

   default boolean complete() {
      return this.complete(true);
   }

   boolean complete(boolean var1);

   boolean complete(boolean var1, boolean var2);

   @NotNull
   @Override
   CompletableFuture<PlayerProfile> update();

   default boolean hasTextures() {
      return this.hasProperty("textures");
   }
}
