package io.papermc.paper.tag;

import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.Tag;
import org.jetbrains.annotations.NotNull;

public abstract class BaseTag<T extends Keyed, C extends BaseTag<T, C>> implements Tag<T> {
   protected final NamespacedKey key;
   protected final Set<T> tagged;
   private final List<Predicate<T>> globalPredicates;
   private boolean locked = false;

   public BaseTag(@NotNull Class<T> clazz, @NotNull NamespacedKey key, @NotNull Predicate<T> filter) {
      this(clazz, key, (T[])(new Keyed[0]));
      this.add(filter);
   }

   public BaseTag(@NotNull Class<T> clazz, @NotNull NamespacedKey key, @NotNull T... values) {
      this(clazz, key, Lists.newArrayList(values));
   }

   public BaseTag(@NotNull Class<T> clazz, @NotNull NamespacedKey key, @NotNull Collection<T> values) {
      this(clazz, key, values, o -> true);
   }

   public BaseTag(@NotNull Class<T> clazz, @NotNull NamespacedKey key, @NotNull Collection<T> values, @NotNull Predicate<T>... globalPredicates) {
      this.key = key != null ? key : NamespacedKey.randomKey();
      this.tagged = (Set<T>)(clazz.isEnum() ? this.createEnumSet(clazz) : new HashSet<>());
      this.tagged.addAll(values);
      this.globalPredicates = Lists.newArrayList(globalPredicates);
   }

   private Set<T> createEnumSet(Class<? extends T> enumClass) {
      assert enumClass.isEnum();
      @SuppressWarnings({"unchecked", "rawtypes"})
      Set<T> result = EnumSet.noneOf((Class) enumClass);
      return result;
   }

   @NotNull
   public C lock() {
      this.locked = true;
      return (C)this;
   }

   public boolean isLocked() {
      return this.locked;
   }

   private void checkLock() {
      if (this.locked) {
         throw new UnsupportedOperationException("Tag (" + this.key + ") is locked");
      }
   }

   @NotNull
   @Override
   public NamespacedKey getKey() {
      return this.key;
   }

   @NotNull
   @Override
   public Set<T> getValues() {
      return Collections.unmodifiableSet(this.tagged);
   }

   @Override
   public boolean isTagged(@NotNull T item) {
      return this.tagged.contains(item);
   }

   @NotNull
   public C add(@NotNull Tag<T>... tags) {
      for (Tag<T> tag : tags) {
         this.add(tag.getValues());
      }

      return (C)this;
   }

   @NotNull
   public C add(@NotNull T... values) {
      this.checkLock();
      this.tagged.addAll(Lists.newArrayList(values));
      return (C)this;
   }

   @NotNull
   public C add(@NotNull Collection<T> collection) {
      this.checkLock();
      this.tagged.addAll(collection);
      return (C)this;
   }

   @NotNull
   public C add(@NotNull Predicate<T> filter) {
      return this.add(
         this.getAllPossibleValues()
            .stream()
            .filter(this.globalPredicates.stream().reduce(Predicate::or).orElse(t -> true))
            .filter(filter)
            .collect(Collectors.toSet())
      );
   }

   @NotNull
   public C contains(@NotNull String with) {
      return this.add(value -> this.getName(value).contains(with));
   }

   @NotNull
   public C endsWith(@NotNull String with) {
      return this.add(value -> this.getName(value).endsWith(with));
   }

   @NotNull
   public C startsWith(@NotNull String with) {
      return this.add(value -> this.getName(value).startsWith(with));
   }

   @NotNull
   public C not(@NotNull Tag<T>... tags) {
      for (Tag<T> tag : tags) {
         this.not(tag.getValues());
      }

      return (C)this;
   }

   @NotNull
   public C not(@NotNull T... values) {
      this.checkLock();
      this.tagged.removeAll(Lists.newArrayList(values));
      return (C)this;
   }

   @NotNull
   public C not(@NotNull Collection<T> values) {
      this.checkLock();
      this.tagged.removeAll(values);
      return (C)this;
   }

   @NotNull
   public C not(@NotNull Predicate<T> filter) {
      this.not(
         this.getAllPossibleValues()
            .stream()
            .filter(this.globalPredicates.stream().reduce(Predicate::or).orElse(t -> true))
            .filter(filter)
            .collect(Collectors.toSet())
      );
      return (C)this;
   }

   @NotNull
   public C notContains(@NotNull String with) {
      return this.not(value -> this.getName(value).contains(with));
   }

   @NotNull
   public C notEndsWith(@NotNull String with) {
      return this.not(value -> this.getName(value).endsWith(with));
   }

   @NotNull
   public C notStartsWith(@NotNull String with) {
      return this.not(value -> this.getName(value).startsWith(with));
   }

   @NotNull
   public C ensureSize(@NotNull String label, int size) {
      long actual = this.tagged.stream().filter(this.globalPredicates.stream().reduce(Predicate::or).orElse(t -> true)).count();
      if ((long)size != actual) {
         throw new IllegalStateException(this.key.toString() + ": " + label + " - Expected " + size + " values, got " + actual);
      } else {
         return (C)this;
      }
   }

   @NotNull
   protected abstract Set<T> getAllPossibleValues();

   @NotNull
   protected abstract String getName(@NotNull T var1);
}
