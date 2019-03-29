package com.github.wahaha2019.exercise;

import org.jetbrains.annotations.NotNull;

public class ArrayStack<E> {
  private transient Object[] data;
  private int size;
  private int pos = -1;

  public ArrayStack(int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException("Stack capacity must greater than 0");
    }
    data = new Object[capacity];
  }

  public int getCapacity() {
    return data.length;
  }

  public int getSize() {
    return size;
  }

  public boolean push(@NotNull E ele) {
    if (size == getCapacity()) {
      return false;
    }
    pos++;
    data[pos] = ele;
    size++;
    return true;
  }

  public E pop() {
    if (size == 0) {
      return null;
    }
    E ele = (E) data[pos];
    pos--;
    size--;
    return ele;
  }
}
