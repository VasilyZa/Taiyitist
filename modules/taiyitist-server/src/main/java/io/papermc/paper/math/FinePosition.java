package io.papermc.paper.math;

import org.bukkit.util.NumberConversions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Experimental;

@Experimental
public interface FinePosition extends Position {
   @Override
   default int blockX() {
      return NumberConversions.floor(this.x());
   }

   @Override
   default int blockY() {
      return NumberConversions.floor(this.y());
   }

   @Override
   default int blockZ() {
      return NumberConversions.floor(this.z());
   }

   @Override
   default boolean isBlock() {
      return false;
   }

   @Override
   default boolean isFine() {
      return true;
   }

   @NotNull
   @Override
   default BlockPosition toBlock() {
      return new BlockPositionImpl(this.blockX(), this.blockY(), this.blockZ());
   }

   @NotNull
   default FinePosition offset(int x, int y, int z) {
      return this.offset((double)x, (double)y, (double)z);
   }

   @NotNull
   @Override
   default FinePosition offset(double x, double y, double z) {
      return (FinePosition)(x == 0.0 && y == 0.0 && z == 0.0 ? this : new FinePositionImpl(this.x() + x, this.y() + y, this.z() + z));
   }
}
