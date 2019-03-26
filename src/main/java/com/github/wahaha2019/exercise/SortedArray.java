package com.github.wahaha2019.exercise;

import javax.annotation.Nonnull;

/**
 * SortedArray is not thread safe. element can not be null.
 */
public class SortedArray<E extends Comparable> extends DynamicArray<E> {
  public SortedArray(int capacity) {
    super(capacity);
  }

  public void insert(@Nonnull E ele) {
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
  public void append(@Nonnull E ele) {
    if (size == 0 || ele.compareTo(data[size - 1]) >= 0) {
      super.append(ele);
    } else {
      throw new RuntimeException("must append an element that greater or equals than last element.");
    }
  }

  @Override
  public void set(int i, E ele) {
    throw new RuntimeException("method not supported.");
  }

  @Override
  public void insert(int i, E ele) {
    throw new RuntimeException("method not supported.");
  }
}
