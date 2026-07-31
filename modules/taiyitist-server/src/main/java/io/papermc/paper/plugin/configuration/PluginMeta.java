package io.papermc.paper.plugin.configuration;

import java.util.List;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.PluginLoadOrder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.Experimental;
import org.jetbrains.annotations.ApiStatus.NonExtendable;

@NonExtendable
@Experimental
public interface PluginMeta {
   @NotNull
   String getName();

   @NotNull
   default String getDisplayName() {
      return this.getName() + " v" + this.getVersion();
   }

   @NotNull
   String getMainClass();

   @NotNull
   PluginLoadOrder getLoadOrder();

   @NotNull
   String getVersion();

   @Nullable
   String getLoggerPrefix();

   @NotNull
   List<String> getPluginDependencies();

   @NotNull
   List<String> getPluginSoftDependencies();

   @NotNull
   List<String> getLoadBeforePlugins();

   @NotNull
   List<String> getProvidedPlugins();

   @NotNull
   List<String> getAuthors();

   @NotNull
   List<String> getContributors();

   @Nullable
   String getDescription();

   @Nullable
   String getWebsite();

   @NotNull
   List<Permission> getPermissions();

   @NotNull
   PermissionDefault getPermissionDefault();

   @Nullable
   String getAPIVersion();
}
