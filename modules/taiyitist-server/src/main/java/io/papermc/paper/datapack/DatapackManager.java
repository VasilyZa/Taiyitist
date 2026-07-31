package io.papermc.paper.datapack;

import java.util.Collection;
import org.checkerframework.checker.nullness.qual.NonNull;

public interface DatapackManager {
   @NonNull
   Collection<Datapack> getPacks();

   @NonNull
   Collection<Datapack> getEnabledPacks();
}
