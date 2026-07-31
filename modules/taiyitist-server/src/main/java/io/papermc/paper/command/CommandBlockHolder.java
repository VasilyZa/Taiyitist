package io.papermc.paper.command;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface CommandBlockHolder {
   @NotNull
   String getCommand();

   void setCommand(@Nullable String var1);

   @NotNull
   Component lastOutput();

   void lastOutput(@Nullable Component var1);

   int getSuccessCount();

   void setSuccessCount(int var1);
}
