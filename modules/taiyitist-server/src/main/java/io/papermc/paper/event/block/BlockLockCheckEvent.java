package io.papermc.paper.event.block;

import com.google.common.base.Preconditions;
import io.papermc.paper.block.LockableTileState;
import java.util.Objects;
import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.text.Component;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BlockLockCheckEvent extends BlockEvent {
   private static final HandlerList HANDLER_LIST = new HandlerList();
   private final LockableTileState state;
   private final Player player;
   private ItemStack itemStack;
   private Event.Result result = Event.Result.DEFAULT;
   private Component lockedMessage;
   private Sound lockedSound;

   public BlockLockCheckEvent(
      @NotNull Block block, @NotNull LockableTileState state, @NotNull Player player, @NotNull Component lockedMessage, @NotNull Sound lockedSound
   ) {
      super(block);
      this.state = state;
      this.player = player;
      this.lockedMessage = lockedMessage;
      this.lockedSound = lockedSound;
   }

   @NotNull
   public LockableTileState getBlockState() {
      return this.state;
   }

   @NotNull
   public Player getPlayer() {
      return this.player;
   }

   @NotNull
   public ItemStack getKeyItem() {
      return Objects.requireNonNullElseGet(this.itemStack, this.player.getInventory()::getItemInMainHand);
   }

   public void setKeyItem(@NotNull ItemStack stack) {
      Preconditions.checkNotNull(stack, "stack is null");
      this.itemStack = stack;
   }

   public void resetKeyItem() {
      this.itemStack = null;
   }

   public boolean isUsingCustomKeyItemStack() {
      return this.itemStack != null;
   }

   @NotNull
   public Event.Result getResult() {
      return this.result;
   }

   public void setResult(@NotNull Event.Result result) {
      this.result = result;
   }

   public void denyWithMessageAndSound(@Nullable Component lockedMessage, @Nullable Sound lockedSound) {
      this.result = Event.Result.DENY;
      this.lockedMessage = lockedMessage;
      this.lockedSound = lockedSound;
   }

   @Nullable
   public Component getLockedMessage() {
      return this.lockedMessage;
   }

   public void setLockedMessage(@Nullable Component lockedMessage) {
      this.lockedMessage = lockedMessage;
   }

   @Nullable
   public Sound getLockedSound() {
      return this.lockedSound;
   }

   public void setLockedSound(@Nullable Sound lockedSound) {
      this.lockedSound = lockedSound;
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
