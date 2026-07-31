package io.papermc.paper.util;

import com.google.common.base.Preconditions;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.function.Function;
import java.util.function.Predicate;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.NotNull;

public final class TransformingRandomAccessList<F, T> extends AbstractList<T> implements RandomAccess {
   final List<F> fromList;
   final Function<? super F, ? extends T> toFunction;
   final Function<? super T, ? extends F> fromFunction;

   public TransformingRandomAccessList(
      @NonNull List<F> fromList, @NonNull Function<? super F, ? extends T> toFunction, @NonNull Function<? super T, ? extends F> fromFunction
   ) {
      this.fromList = (List<F>)Preconditions.checkNotNull(fromList);
      this.toFunction = (Function<? super F, ? extends T>)Preconditions.checkNotNull(toFunction);
      this.fromFunction = (Function<? super T, ? extends F>)Preconditions.checkNotNull(fromFunction);
   }

   @Override
   public void clear() {
      this.fromList.clear();
   }

   @Override
   public T get(int index) {
      return (T)this.toFunction.apply(this.fromList.get(index));
   }

   @NotNull
   @Override
   public Iterator<T> iterator() {
      return this.listIterator();
   }

   @NotNull
   @Override
   public ListIterator<T> listIterator(int index) {
      return new TransformingRandomAccessList.TransformedListIterator<F, T>(this.fromList.listIterator(index)) {
         @Override
         T transform(F from) {
            return (T)TransformingRandomAccessList.this.toFunction.apply(from);
         }

         @Override
         F transformBack(T from) {
            return (F)TransformingRandomAccessList.this.fromFunction.apply(from);
         }
      };
   }

   @Override
   public boolean isEmpty() {
      return this.fromList.isEmpty();
   }

   @Override
   public boolean removeIf(Predicate<? super T> filter) {
      Preconditions.checkNotNull(filter);
      return this.fromList.removeIf(element -> filter.test((T)this.toFunction.apply(element)));
   }

   @Override
   public T remove(int index) {
      return (T)this.toFunction.apply(this.fromList.remove(index));
   }

   @Override
   public int size() {
      return this.fromList.size();
   }

   @Override
   public T set(int i, T t) {
      return (T)this.toFunction.apply(this.fromList.set(i, (F)this.fromFunction.apply(t)));
   }

   @Override
   public void add(int i, T t) {
      this.fromList.add(i, (F)this.fromFunction.apply(t));
   }

   abstract static class TransformedListIterator<F, T> implements ListIterator<T>, Iterator<T> {
      final Iterator<F> backingIterator;

      TransformedListIterator(ListIterator<F> backingIterator) {
         this.backingIterator = (Iterator<F>)Preconditions.checkNotNull(backingIterator);
      }

      private ListIterator<F> backingIterator() {
         return cast(this.backingIterator);
      }

      static <A> ListIterator<A> cast(Iterator<A> iterator) {
         return (ListIterator<A>)iterator;
      }

      @Override
      public final boolean hasPrevious() {
         return this.backingIterator().hasPrevious();
      }

      @Override
      public final T previous() {
         return this.transform(this.backingIterator().previous());
      }

      @Override
      public final int nextIndex() {
         return this.backingIterator().nextIndex();
      }

      @Override
      public final int previousIndex() {
         return this.backingIterator().previousIndex();
      }

      @Override
      public void set(T element) {
         this.backingIterator().set(this.transformBack(element));
      }

      @Override
      public void add(T element) {
         this.backingIterator().add(this.transformBack(element));
      }

      abstract T transform(F var1);

      abstract F transformBack(T var1);

      @Override
      public final boolean hasNext() {
         return this.backingIterator.hasNext();
      }

      @Override
      public final T next() {
         return this.transform(this.backingIterator.next());
      }

      @Override
      public final void remove() {
         this.backingIterator.remove();
      }
   }
}
