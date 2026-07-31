package io.papermc.paper.event.world.border;

import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class WorldBorderBoundsChangeFinishEvent extends WorldBorderEvent {
   private static final HandlerList HANDLER_LIST = new HandlerList();
   private final double oldSize;
   private final double newSize;
   private final double duration;

   public WorldBorderBoundsChangeFinishEvent(@NotNull World world, @NotNull WorldBorder worldBorder, double oldSize, double newSize, double duration) {
      super(world, worldBorder);
      this.oldSize = oldSize;
      this.newSize = newSize;
      this.duration = duration;
   }

   public double getOldSize() {
      return this.oldSize;
   }

   public double getNewSize() {
      return this.newSize;
   }

   public double getDuration() {
      return this.duration;
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
