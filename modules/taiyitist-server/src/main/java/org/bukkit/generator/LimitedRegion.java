package org.bukkit.generator;

import java.util.List;
import org.bukkit.Location;
import org.bukkit.RegionAccessor;
import org.bukkit.World;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

/**
 * A limited region is used in world generation for features which are
 * going over a chunk. For example, trees or ores.
 *
 * Use {@link #getBuffer()} to know how much you can go beyond the central
 * chunk. The buffer zone may or may not be already populated.
 *
 * The coordinates are <b>absolute</b> from the world origin.
 */
public interface LimitedRegion extends RegionAccessor {

    /**
     * Gets the buffer around the central chunk which is accessible.
     * The returned value is in normal world coordinate scale.
     * <p>
     * For example: If the method returns 16 you have a working area of 48x48.
     *
     * @return The buffer in X and Z direction
     */
    int getBuffer();

    /**
     * Checks if the given {@link Location} is in the region.
     *
     * @param location the location to check
     * @return true if the location is in the region, otherwise false.
     */
    boolean isInRegion(@NotNull Location location);

    /**
     * Checks if the given coordinates are in the region.
     *
     * @param x X-coordinate to check
     * @param y Y-coordinate to check
     * @param z Z-coordinate to check
     * @return true if the coordinates are in the region, otherwise false.
     */
    boolean isInRegion(int x, int y, int z);

    /**
     * Gets a list of all tile entities in the limited region including the
     * buffer zone.
     *
     * @return a list of tile entities.
     */
    @NotNull
    List<BlockState> getTileEntities();

    default void setBlockData(@NotNull Vector vector, @NotNull BlockData data) {
        setBlockData(vector.getBlockX(), vector.getBlockY(), vector.getBlockZ(), data);
    }

    void setBlockState(int x, int y, int z, @NotNull BlockState state);

    default void setBlockState(@NotNull Vector location, @NotNull BlockState state) {
        setBlockState(location.getBlockX(), location.getBlockY(), location.getBlockZ(), state);
    }

    @NotNull
    default BlockState getBlockState(@NotNull Vector location) {
        return getBlockState(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    void scheduleBlockUpdate(int x, int y, int z);

    default void scheduleBlockUpdate(@NotNull Vector location) {
        scheduleBlockUpdate(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    void scheduleFluidUpdate(int x, int y, int z);

    default void scheduleFluidUpdate(@NotNull Vector location) {
        scheduleFluidUpdate(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    @NotNull
    World getWorld();

    @NotNull
    default BlockData getBlockData(@NotNull Vector vector) {
        return getBlockData(vector.getBlockX(), vector.getBlockY(), vector.getBlockZ());
    }

    int getCenterChunkX();

    default int getCenterBlockX() {
        return getCenterChunkX() << 4;
    }

    int getCenterChunkZ();

    default int getCenterBlockZ() {
        return getCenterChunkZ() << 4;
    }
}
