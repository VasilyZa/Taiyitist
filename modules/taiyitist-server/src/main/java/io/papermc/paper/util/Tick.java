package io.papermc.paper.util;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public final class Tick implements TemporalUnit {
   private static final Tick INSTANCE = new Tick(50L);
   private final long milliseconds;

   @NotNull
   public static Tick tick() {
      return INSTANCE;
   }

   private Tick(long length) {
      this.milliseconds = length;
   }

   @NotNull
   public static Duration of(long ticks) {
      return Duration.of(ticks, INSTANCE);
   }

   public int fromDuration(@NotNull Duration duration) {
      Objects.requireNonNull(duration, "duration cannot be null");
      return Math.toIntExact(Math.floorDiv(duration.toMillis(), this.milliseconds));
   }

   @NotNull
   @Override
   public Duration getDuration() {
      return Duration.ofMillis(this.milliseconds);
   }

   @Override
   public boolean isDurationEstimated() {
      return false;
   }

   @Override
   public boolean isDateBased() {
      return false;
   }

   @Override
   public boolean isTimeBased() {
      return true;
   }

   @NotNull
   @Override
   public <R extends Temporal> R addTo(@NotNull R temporal, long amount) {
      return (R)temporal.plus(this.getDuration().multipliedBy(amount));
   }

   @Override
   public long between(@NotNull Temporal start, @NotNull Temporal end) {
      return start.until(end, ChronoUnit.MILLIS) / this.milliseconds;
   }
}
