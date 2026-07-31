package io.papermc.paper.math;

import org.jetbrains.annotations.NotNull;

record RotationsImpl(double x, double y, double z) implements Rotations {
   @NotNull
   public RotationsImpl withX(double x) {
      return new RotationsImpl(x, this.y, this.z);
   }

   @NotNull
   public RotationsImpl withY(double y) {
      return new RotationsImpl(this.x, y, this.z);
   }

   @NotNull
   public RotationsImpl withZ(double z) {
      return new RotationsImpl(this.x, this.y, z);
   }

   @NotNull
   public RotationsImpl add(double x, double y, double z) {
      return new RotationsImpl(this.x + x, this.y + y, this.z + z);
   }
}
