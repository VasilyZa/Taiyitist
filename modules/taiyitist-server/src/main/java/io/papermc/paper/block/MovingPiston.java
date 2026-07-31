package io.papermc.paper.block;

import org.bukkit.block.BlockFace;
import org.bukkit.block.TileState;
import org.bukkit.block.data.BlockData;
import org.jetbrains.annotations.NotNull;

public interface MovingPiston extends TileState {
   @NotNull
   BlockData getMovingBlock();

   @NotNull
   BlockFace getDirection();

   boolean isExtending();

   boolean isPistonHead();
}
