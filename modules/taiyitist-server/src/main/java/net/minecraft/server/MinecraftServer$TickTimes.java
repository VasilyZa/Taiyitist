package net.minecraft.server;

/**
 * Paper-compatible rolling tick-time sample used by plugins such as TabTPS.
 * The dollar-sign class name intentionally matches the JVM binary name of a
 * nested MinecraftServer.TickTimes class.
 */
public final class MinecraftServer$TickTimes {
    private final long[] times;

    public MinecraftServer$TickTimes(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("length must be positive");
        }
        this.times = new long[length];
    }

    public void add(int index, long time) {
        this.times[Math.floorMod(index, this.times.length)] = time;
    }

    public long[] getTimes() {
        return this.times.clone();
    }

    public double getAverage() {
        long total = 0L;
        for (long time : this.times) {
            total += time;
        }
        return ((double) total / (double) this.times.length) * 1.0E-6D;
    }
}
