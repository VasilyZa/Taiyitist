package io.papermc.paper.entity;

import org.bukkit.entity.Fish;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface SchoolableFish extends Fish {
   void startFollowing(@NotNull SchoolableFish var1);

   void stopFollowing();

   int getSchoolSize();

   int getMaxSchoolSize();

   @Nullable
   SchoolableFish getSchoolLeader();
}
