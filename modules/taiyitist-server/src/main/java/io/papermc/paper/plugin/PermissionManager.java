package io.papermc.paper.plugin;

import java.util.List;
import java.util.Set;
import org.bukkit.permissions.Permissible;
import org.bukkit.permissions.Permission;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.Experimental;

@Experimental
public interface PermissionManager {
   @Nullable
   Permission getPermission(@NotNull String var1);

   void addPermission(@NotNull Permission var1);

   void removePermission(@NotNull Permission var1);

   void removePermission(@NotNull String var1);

   @NotNull
   Set<Permission> getDefaultPermissions(boolean var1);

   void recalculatePermissionDefaults(@NotNull Permission var1);

   void subscribeToPermission(@NotNull String var1, @NotNull Permissible var2);

   void unsubscribeFromPermission(@NotNull String var1, @NotNull Permissible var2);

   @NotNull
   Set<Permissible> getPermissionSubscriptions(@NotNull String var1);

   void subscribeToDefaultPerms(boolean var1, @NotNull Permissible var2);

   void unsubscribeFromDefaultPerms(boolean var1, @NotNull Permissible var2);

   @NotNull
   Set<Permissible> getDefaultPermSubscriptions(boolean var1);

   @NotNull
   Set<Permission> getPermissions();

   void addPermissions(@NotNull List<Permission> var1);

   void clearPermissions();
}
