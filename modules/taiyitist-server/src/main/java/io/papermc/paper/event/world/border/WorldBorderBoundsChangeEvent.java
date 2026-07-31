package io.papermc.paper.event.world.border;

import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class WorldBorderBoundsChangeEvent extends WorldBorderEvent implements Cancellable {
   private static final HandlerList HANDLER_LIST = new HandlerList();
   private WorldBorderBoundsChangeEvent.Type type;
   private final double oldSize;
   private double newSize;
   private long duration;
   private boolean cancelled;

   public WorldBorderBoundsChangeEvent(
      @NotNull World world, @NotNull WorldBorder worldBorder, @NotNull WorldBorderBoundsChangeEvent.Type type, double oldSize, double newSize, long duration
   ) {
      super(world, worldBorder);
      this.type = type;
      this.oldSize = oldSize;
      this.newSize = newSize;
      this.duration = duration;
   }

   @NotNull
   public WorldBorderBoundsChangeEvent.Type getType() {
      return this.type;
   }

   public double getOldSize() {
      return this.oldSize;
   }

   public double getNewSize() {
      return this.newSize;
   }

   public void setNewSize(double newSize) {
      this.newSize = Math.min(6.0E7, Math.max(1.0, newSize));
   }

   public long getDuration() {
      return this.duration;
   }

   public void setDuration(long duration) {
      this.duration = Math.min(9223372036854775L, Math.max(0L, duration));
      if (duration >= 0L && this.type == WorldBorderBoundsChangeEvent.Type.INSTANT_MOVE) {
         this.type = WorldBorderBoundsChangeEvent.Type.STARTED_MOVE;
      }
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

   public static enum Type {
      STARTED_MOVE,
      INSTANT_MOVE;
   }
}
