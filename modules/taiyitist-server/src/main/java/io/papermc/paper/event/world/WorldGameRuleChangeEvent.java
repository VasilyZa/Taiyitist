package io.papermc.paper.event.world;

import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.world.WorldEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class WorldGameRuleChangeEvent extends WorldEvent implements Cancellable {
   private static final HandlerList HANDLER_LIST = new HandlerList();
   private final CommandSender commandSender;
   private final GameRule<?> gameRule;
   private String value;
   private boolean cancelled;

   public WorldGameRuleChangeEvent(@NotNull World world, @Nullable CommandSender commandSender, @NotNull GameRule<?> gameRule, @NotNull String value) {
      super(world);
      this.commandSender = commandSender;
      this.gameRule = gameRule;
      this.value = value;
   }

   @Nullable
   public CommandSender getCommandSender() {
      return this.commandSender;
   }

   @NotNull
   public GameRule<?> getGameRule() {
      return this.gameRule;
   }

   @NotNull
   public String getValue() {
      return this.value;
   }

   public void setValue(@NotNull String value) {
      this.value = value;
   }

   @Override
   public boolean isCancelled() {
      return this.cancelled;
   }

   @Override
   public void setCancelled(boolean cancel) {
      this.cancelled = cancel;
   }

   @NotNull
   @Override
   public HandlerList getHandlers() {
      return HANDLER_LIST;
   }

   @NotNull
   public static HandlerList getHandlerList() {
      return HANDLER_LIST;
   }
}
