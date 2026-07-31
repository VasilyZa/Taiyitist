package io.papermc.paper.math;

import org.jetbrains.annotations.NotNull;

public interface Rotations {
   Rotations ZERO = ofDegrees(0.0, 0.0, 0.0);

   @NotNull
   static Rotations ofDegrees(double x, double y, double z) {
      return new RotationsImpl(x, y, z);
   }

   double x();

   double y();

   double z();

   @NotNull
   Rotations withX(double var1);

   @NotNull
   Rotations withY(double var1);

   @NotNull
   Rotations withZ(double var1);

   @NotNull
   Rotations add(double var1, double var3, double var5);

   @NotNull
   default Rotations subtract(double x, double y, double z) {
      return this.add(-x, -y, -z);
   }
}
