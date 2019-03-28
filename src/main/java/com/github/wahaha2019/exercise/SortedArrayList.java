package com.github.wahaha2019.exercise;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * SortedArrayList is not thread safe. element can not be null.
 */
public class SortedArrayList<E extends Comparable> extends ArrayList<E> {
  private static final long serialVersionUID = -4299003191451011929L;

  public SortedArrayList(int capacity) {
    super(capacity);
  }

  public SortedArrayList() {
    super();
  }

  static SortedArrayList newIntSerial(int size) {
    SortedArrayList list = new SortedArrayList<String>(size);
    fillIntSerial(size, list);
    return list;
  }

  static SortedArrayList newIntSerial(int begin, int step, int size) {
    if (step <= 0) {
      throw new IllegalArgumentException("step must greater than 0");
    }
    SortedArrayList list = new SortedArrayList<String>(size);
    fillIntSerial(begin, step, size, list);
    return list;
  }

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

  public void insert(@NotNull E ele) {
    if (size == 0) {
      super.append(ele);
      return;
    }
    for (int i = 0; i < size; i++) {
      if (ele.compareTo(data[i]) <= 0) {
        super.insert(i, ele);
        return;
      }
    }
    super.append(ele);
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
