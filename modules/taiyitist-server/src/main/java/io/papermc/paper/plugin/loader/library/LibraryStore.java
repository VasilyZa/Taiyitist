package io.papermc.paper.plugin.loader.library;

import java.nio.file.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public interface LibraryStore {
   void addLibrary(@NotNull Path var1);
}
