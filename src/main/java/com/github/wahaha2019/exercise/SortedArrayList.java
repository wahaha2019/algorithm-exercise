package com.github.wahaha2019.exercise;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * <tt>SortedArrayList</tt> is not thread safe. element can not be null.
 */
public class SortedArrayList<E extends Comparable> extends ArrayList<E> {
  private static final long serialVersionUID = -4299003191451011929L;

  /**
   * Create a new <tt>SortedArrayList</tt> with the given initial capacity.
   *
   * @param capacity The initial capacity.
   */
  public SortedArrayList(int capacity) {
    super(capacity);
  }

  /**
   * Create a new <tt>SortedArrayList</tt> with default capacity.
   */
  public SortedArrayList() {
    super();
  }

  /**
   * Create a new <tt>SortedArrayList</tt> from the given array.
   *
   * @param array The input array.
   * @return The new <tt>SortedArrayList</tt>
   */
  static SortedArrayList fromArray(final Comparable[] array) {
    SortedArrayList<Comparable> list = new SortedArrayList<>(array.length);
    for (int i = 0; i < array.length; i++) {
      list.insert(array[i]);
    }
    return list;
  }

  /**
   * Create a new <tt>SortedArrayList</tt> with an integer serial that start from 0, this method is used for testing.
   *
   * @param size The size of the new <tt>SortedArrayList</tt>.
   * @return The new <tt>SortedArrayList</tt>.
   */
  static SortedArrayList newIntSerial(int size) {
    SortedArrayList list = new SortedArrayList(size);
    fillIntSerial(size, list);
    return list;
  }

  /**
   * Create a new <tt>SortedArrayList</tt> with an integer serial with given params.
   *
   * @param begin The first value of the serial.
   * @param step  The step of the serial.
   * @param size  The size of the integer serial.
   * @return The new <tt>SortedArrayList</tt>.
   */
  static SortedArrayList newIntSerial(int begin, int step, int size) {
    if (step <= 0) {
      throw new IllegalArgumentException("step must greater than 0");
    }
    SortedArrayList<Integer> list = new SortedArrayList<>(size);
    fillIntSerial(begin, step, size, list);
    return list;
  }

  /**
   * Find the index of the first element that equals the given element.
   *
   * @param ele The element to be searched.
   * @return The index of the first element that equals the given element, if not found then -1
   */
  public int binarySearch(final Comparable ele) {
    return binarySearch(ele, 0, size);
  }

  private int binarySearch(final Comparable ele, final int start, final int size) {
    if (size <= 3) {
      for (int i = start; i < start + size; i++) {
        final int cmp = get(i).compareTo(ele);
        if (cmp == 0) {
          return i;
        } else if (cmp > 0) {
          break;
        }
      }
      return -1;
    } else {
      if (get(start + size - 1).compareTo(ele) < 0) {
        return -1;
      }
      int left_size = size / 2;
      int right_size = size - left_size;
      final int left_search = binarySearch(ele, start, left_size);
      if (left_search >= 0) {
        return left_search;
      } else {
        return binarySearch(ele, start + left_size, right_size);
      }
    }
  }

  /**
   * Merge two <tt>SortedArrayList</tt>s into a new one.
   *
   * @param src1 Source <tt>SortedArrayList</tt> 1.
   * @param src2 Source <tt>SortedArrayList</tt> 2.
   * @return Merged <tt>SortedArrayList</tt>
   */
  public static SortedArrayList merge(final SortedArrayList src1, final SortedArrayList src2) {
    if (src1 == null || src2 == null) {
      throw new IllegalArgumentException("Every source list must not be null.");
    }
    long newSize = src1.size + src2.size;
    if (newSize > Integer.MAX_VALUE) {
      throw new IllegalArgumentException("Summed size of source lists is too large.");
    }
    if (newSize == 0) {
      return new SortedArrayList(1);
    }
    SortedArrayList result = new SortedArrayList(src1.size + src2.size);
    result.size = result.getCapacity();
    int k = 0;
    for (int i = 0, j = 0; i < src1.size || j < src2.size; k++) {
      if (i >= src1.size) {
        result.data[k] = src2.get(j);
        j++;
        continue;
      }
      if (j >= src2.size) {
        result.data[k] = src1.get(i);
        i++;
        continue;
      }
      if (src1.get(i).compareTo(src2.get(j)) <= 0) {
        result.data[k] = src1.get(i);
        i++;
      } else {
        result.data[k] = src2.get(j);
        j++;
      }
    }
    return result;
  }

  /**
   * Merge multiple <tt>SortedArrayList</tt>s into a new one.
   *
   * @param src Source <tt>SortedArrayList</tt>s.
   * @return Merged <tt>SortedArrayList</tt>
   */
  public static SortedArrayList merge(@NotNull final SortedArrayList[] src) {
    long newSize = 0;
    SortedArrayList[] source = new SortedArrayList[src.length];
    int count = 0;
    for (int i = 0; i < src.length; i++) {
      if (src[i] == null) {
        throw new IllegalArgumentException("Every source list must not be null.");
      }
      if (src[i].size > 0) {
        newSize += src[i].size;
        source[count] = src[i];
        count++;
      }
    }
    if (newSize > Integer.MAX_VALUE) {
      throw new IllegalArgumentException("Summed size of source lists is too large.");
    }
    if (src.length <= 1) {
      throw new IllegalArgumentException("Count of source lists must greater than 1");
    }
    source = Arrays.copyOf(source, count);
    if (newSize == 0) {
      return new SortedArrayList(1);
    }
    if (source.length == 2) {
      return merge(source[0], source[1]);
    }
    SortedArrayList result = new SortedArrayList((int) newSize);
    result.size = result.getCapacity();
    int k = 0;
    int[] idx = new int[count];
    while (true) {
      int i = 0;
      Comparable minEle = null;
      for (; i < count; i++) {
        if (idx[i] < source[i].size) {
          minEle = source[i].get(idx[i]);
          break;
        }
      }
      if (minEle == null) {
        break;
      }
      int pos = i;
      for (int j = i; j < count; j++) {
        if (idx[j] < source[j].size) {
          if (source[j].get(idx[j]).compareTo(minEle) < 0) {
            minEle = source[j].get(idx[j]);
            pos = j;
          }
        }
      }
      idx[pos]++;
      result.data[k] = minEle;
      k++;
    }
    return result;
  }

  /**
   * Insert an element into this <tt>SortedArrayList</tt>.
   *
   * @param ele The element.
   */
  public void insert(@NotNull E ele) {
    if (size == 0) {
      super.append(ele);
      return;
    }
    for (int i = size - 1; i >= 0; i--) {
      if (ele.compareTo(data[i]) >= 0) {
        if (i == size - 1) {
          super.append(ele);
        } else {
          super.insert(i + 1, ele);
        }
        return;
      }
    }
    super.insert(0, ele);
  }

  @Override
  public E get(int i) {
    return (E) super.get(i);
  }

  @Override
  @Deprecated
  public void append(@NotNull E ele) {
    throw new RuntimeException("method not supported.");
  }

  @Override
  @Deprecated
  public void set(int i, E ele) {
    throw new RuntimeException("method not supported.");
  }

  @Override
  @Deprecated
  public void insert(int i, E ele) {
    throw new RuntimeException("method not supported.");
  }

  /**
   * Returns a shallow copy of this <tt>ArrayList</tt> instance.  (The elements themselves are not copied.)
   *
   * @return a clone of this <tt>ArrayList</tt> instance
   */
  @Override
  public SortedArrayList<E> clone() {
    SortedArrayList copy = new SortedArrayList();
    copy.size = size;
    copy.data = Arrays.copyOf(data, size);
    return copy;
  }

  private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
    s.defaultWriteObject();
    for (int i = 0; i < size; i++) {
      s.writeObject(data[i]);
    }
  }

  private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
    s.defaultReadObject();
    if (size > 0) {
      data = new Object[size];
      for (int i = 0; i < size; i++) {
        data[i] = s.readObject();
      }
    }
  }

}
