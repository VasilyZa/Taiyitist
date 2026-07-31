package io.papermc.paper.event.world;

import io.papermc.paper.math.Position;
import io.papermc.paper.util.TransformingRandomAccessList;
import io.papermc.paper.world.structure.ConfiguredStructure;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.world.WorldEvent;
import org.bukkit.generator.structure.Structure;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnmodifiableView;

public class StructuresLocateEvent extends WorldEvent implements Cancellable {
   private static final HandlerList HANDLER_LIST = new HandlerList();
   private final Location origin;
   private StructuresLocateEvent.Result result;
   private List<Structure> structures;
   private List<ConfiguredStructure> legacy$structures;
   private int radius;
   private boolean findUnexplored;
   private boolean cancelled;

   public StructuresLocateEvent(@NotNull World world, @NotNull Location origin, @NotNull List<Structure> structures, int radius, boolean findUnexplored) {
      super(world);
      this.origin = origin;
      this.setStructures(structures);
      this.radius = radius;
      this.findUnexplored = findUnexplored;
   }

   @NotNull
   public Location getOrigin() {
      return this.origin;
   }

   @Nullable
   public StructuresLocateEvent.Result getResult() {
      return this.result;
   }

   public void setResult(@Nullable StructuresLocateEvent.Result result) {
      this.result = result;
   }

   @Deprecated(
      forRemoval = true
   )
   @NotNull
   public List<ConfiguredStructure> getConfiguredStructures() {
      return this.legacy$structures;
   }

   @Deprecated(
      forRemoval = true
   )
   public void setConfiguredStructures(@NotNull List<ConfiguredStructure> configuredStructures) {
      this.setStructures(configuredStructures.stream().map(ConfiguredStructure::toModern).toList());
   }

   @NotNull
   @UnmodifiableView
   public List<Structure> getStructures() {
      return Collections.unmodifiableList(this.structures);
   }

   public void setStructures(@NotNull List<Structure> structures) {
      this.structures = structures;
      this.legacy$structures = new TransformingRandomAccessList<>(this.structures, ConfiguredStructure::fromModern, ConfiguredStructure::toModern);
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

   @NotNull
   @Override
   public HandlerList getHandlers() {
      return HANDLER_LIST;
   }

   @NotNull
   public static HandlerList getHandlerList() {
      return HANDLER_LIST;
   }

   public static record Result(@NotNull Position pos, @NotNull Structure structure) {
      @Deprecated(
         forRemoval = true
      )
      public Result(@NotNull Location position, @NotNull ConfiguredStructure configuredStructure) {
         this(position, configuredStructure.toModern());
      }

      @Deprecated(
         forRemoval = true
      )
      @NotNull
      public ConfiguredStructure configuredStructure() {
         return Objects.requireNonNull(ConfiguredStructure.fromModern(this.structure), "Please use the newer Structure API");
      }

      @Deprecated(
         forRemoval = true
      )
      @NotNull
      public Location position() {
         return this.pos.toLocation(null);
      }
   }
}
