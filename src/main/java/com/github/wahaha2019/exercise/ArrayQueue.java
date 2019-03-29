package com.github.wahaha2019.exercise;

import org.jetbrains.annotations.NotNull;

public class ArrayQueue<E> {
  private static final int DEFAULT_CAPACITY = 256;
  private transient final double expendRatio = 1.5D;
  private transient final int expendStep = 8;
  private transient Object[] data;
  private int size;
  private int inPos = -1;
  private int dePos = -1;

  public ArrayQueue(int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException("List capacity must greater than 0");
    }
    data = new Object[capacity];
  }

  public int getCapacity() {
    return data.length;
  }

  public int getSize() {
    return size;
  }

  public boolean inqueue(@NotNull E ele) {
    if (size == getCapacity()) {
      return false;
    }
    inPos++;
    if (inPos == getCapacity()) {
      inPos = 0;
    }
    data[inPos] = ele;
    size++;
    return true;
  }

  public E dequeue() {
    if (size == 0) {
      return null;
    }
    size--;
    dePos++;
    if (dePos == getCapacity()) {
      dePos = 0;
    }
    return (E) data[dePos];
  }
}
