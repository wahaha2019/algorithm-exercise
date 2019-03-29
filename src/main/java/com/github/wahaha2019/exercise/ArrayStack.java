package com.github.wahaha2019.exercise;

import org.jetbrains.annotations.NotNull;

public class ArrayStack<E> {
  private transient Object[] data;
  private int size;
  private int pos;

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
    data[pos] = ele;
    pos++;
    size++;
    return true;
  }

  public E pop() {
    if (size == 0) {
      return null;
    }
    pos--;
    E ele = (E) data[pos];
    size--;
    return ele;
  }
}
