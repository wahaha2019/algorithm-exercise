package com.github.wahaha2019.exercise;

import org.jetbrains.annotations.NotNull;

/**
 * SortedArray is not thread safe. element can not be null.
 */
public class SortedArray<E extends Comparable> extends DynamicArray<E> {
  public SortedArray(int capacity) {
    super(capacity);
  }

  static SortedArray newIntSerial(int size) {
    SortedArray array = new SortedArray<String>(size);
    fillIntSerial(size, array);
    return array;
  }

  static SortedArray newIntSerial(int begin, int step, int size) {
    SortedArray array = new SortedArray<String>(size);
    fillIntSerial(begin, step, size, array);
    return array;
  }

  public static SortedArray merge(final SortedArray src1, final SortedArray src2) {
    if (src1 == null || src2 == null) {
      throw new IllegalArgumentException("Every source array must not be null.");
    }
    SortedArray result = new SortedArray<String>(src1.size + src2.size);
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
}
