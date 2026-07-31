package io.papermc.paper.plugin.loader.library;

import org.jetbrains.annotations.NotNull;

public interface ClassPathLibrary {
   void register(@NotNull LibraryStore var1) throws LibraryLoadingException;
}
