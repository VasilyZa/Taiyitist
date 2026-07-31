package io.papermc.paper.event.world;

import org.bukkit.Location;
import org.bukkit.StructureType;
import org.bukkit.World;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.world.WorldEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.ScheduledForRemoval;

@Deprecated(
   forRemoval = true
)
@ScheduledForRemoval(
   inVersion = "1.21"
)
public class StructureLocateEvent extends WorldEvent implements Cancellable {
   private static final HandlerList handlers = new HandlerList();
   private final Location origin;
   private Location result = null;
   private StructureType type;
   private int radius;
   private boolean findUnexplored;
   private boolean cancelled = false;

   public StructureLocateEvent(@NotNull World world, @NotNull Location origin, @NotNull StructureType structureType, int radius, boolean findUnexplored) {
      super(world);
      this.origin = origin;
      this.type = structureType;
      this.radius = radius;
      this.findUnexplored = findUnexplored;
   }

   @NotNull
   public static HandlerList getHandlerList() {
      return handlers;
   }

   @NotNull
   @Override
   public HandlerList getHandlers() {
      return handlers;
   }

   @Nullable
   public Location getResult() {
      return this.result;
   }

   public void setResult(@Nullable Location result) {
      this.result = result;
   }

   @NotNull
   public StructureType getType() {
      return this.type;
   }

   public void setType(@NotNull StructureType type) {
      this.type = type;
   }

   @NotNull
   public Location getOrigin() {
      return this.origin;
   }

   public int getRadius() {
      return this.radius;
   }

   public void setRadius(int radius) {
      this.radius = radius;
   }

   public boolean shouldFindUnexplored() {
      return this.findUnexplored;
   }

   public void setFindUnexplored(boolean findUnexplored) {
      this.findUnexplored = findUnexplored;
   }

   @Override
   public boolean isCancelled() {
      return this.cancelled;
   }

   @Override
   public void setCancelled(boolean cancel) {
      this.cancelled = cancel;
   }
}
