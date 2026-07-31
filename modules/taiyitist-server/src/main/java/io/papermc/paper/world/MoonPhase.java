package io.papermc.paper.world;

import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public enum MoonPhase {
   FULL_MOON(0L),
   WANING_GIBBOUS(1L),
   LAST_QUARTER(2L),
   WANING_CRESCENT(3L),
   NEW_MOON(4L),
   WAXING_CRESCENT(5L),
   FIRST_QUARTER(6L),
   WAXING_GIBBOUS(7L);

   private final long day;
   private static final Map<Long, MoonPhase> BY_DAY = new HashMap<>();

   private MoonPhase(long day) {
      this.day = day;
   }

   @NotNull
   public static MoonPhase getPhase(long day) {
      return BY_DAY.get(day % 8L);
   }

   static {
      for (MoonPhase phase : values()) {
         BY_DAY.put(phase.day, phase);
      }
   }
}
