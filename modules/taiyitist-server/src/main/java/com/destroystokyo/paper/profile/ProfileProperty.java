package com.destroystokyo.paper.profile;

import com.google.common.base.Preconditions;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ProfileProperty {
   private final String name;
   private final String value;
   private final String signature;

   public ProfileProperty(@NotNull String name, @NotNull String value) {
      this(name, value, null);
   }

   public ProfileProperty(@NotNull String name, @NotNull String value, @Nullable String signature) {
      this.name = (String)Preconditions.checkNotNull(name, "ProfileProperty name can not be null");
      this.value = (String)Preconditions.checkNotNull(value, "ProfileProperty value can not be null");
      this.signature = signature;
   }

   @NotNull
   public String getName() {
      return this.name;
   }

   @NotNull
   public String getValue() {
      return this.value;
   }

   @Nullable
   public String getSignature() {
      return this.signature;
   }

   public boolean isSigned() {
      return this.signature != null;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (o != null && this.getClass() == o.getClass()) {
         ProfileProperty that = (ProfileProperty)o;
         return Objects.equals(this.name, that.name) && Objects.equals(this.value, that.value) && Objects.equals(this.signature, that.signature);
      } else {
         return false;
      }
   }

   @Override
   public int hashCode() {
      return Objects.hash(this.name);
   }
}
