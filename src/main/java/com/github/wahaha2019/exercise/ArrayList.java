/*
 * This Java source file was generated by the Gradle 'init' task.
 */

package com.github.wahaha2019.exercise;

import java.io.Serializable;
import java.util.Arrays;

/**
 * ArrayList is not thread safe. element can be null.
 */
public class ArrayList<E> implements Serializable {
  private static final long serialVersionUID = 5810606339357346347L;
  private static final int DEFAULT_CAPACITY = 256;
  private transient final double expendRatio = 1.5D;
  private transient final int expendStep = 8;
  protected transient Object[] data;
  protected int size;

  static ArrayList<Integer> newIntSerial(int size) {
    ArrayList<Integer> list = new ArrayList<>(size);
    fillIntSerial(size, list);
    return list;
  }

  static void fillIntSerial(int size, ArrayList list) {
    list.setSize(size);
    for (int i = 0; i < size; i++) {
      list.data[i] = i;
    }
  }

  static void fillIntSerial(int begin, int step, int size, ArrayList list) {
    list.setSize(size);
    for (int i = 0; i < size; i++) {
      list.data[i] = begin + i * step;
    }
  }

  public ArrayList(int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException("List capacity must greater than 0");
    }
    data = new Object[capacity];
    size = 0;
  }

  public ArrayList() {
    this(DEFAULT_CAPACITY);
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean isFull() {
    return size == getCapacity();
  }

  public int getSize() {
    return size;
  }

  public void setSize(final int newSize) {
    if (newSize < 0) {
      throw new IllegalArgumentException("List size must greater than 0");
    }
    if (newSize == 0) {
      clear();
      return;
    }
    if (newSize > getCapacity()) {
      Object[] newData = new Object[newSize];
      for (int i = 0; i < size; i++) {
        newData[i] = data[i];
        data[i] = null;
      }
      data = newData;
    } else {
      for (int i = newSize; i < size; i++) {
        data[i] = null;
      }
    }
    size = newSize;
  }

  public void clear() {
    for (int i = 0; i < size; i++) {
      data[i] = null;
    }
    size = 0;
  }

  public int getCapacity() {
    return data.length;
  }

  public E get(int i) {
    checkIndex(i);
    return (E) data[i];
  }

  public void set(int i, E ele) {
    checkIndex(i);
    data[i] = ele;
  }

  public void insert(int i, E ele) {
    if (size == 0) {
      if (i != 0) {
        throw new IllegalArgumentException("Index must be 0 when insert to an empty list.");
      }
    } else {
      checkIndex(i);
    }
    if (i == Integer.MAX_VALUE || size == Integer.MAX_VALUE) {
      throw new IllegalArgumentException("List size is max, can not insert any more.");
    }
    if (size + 1 <= getCapacity()) {
      for (int j = size - 1; j >= i; j--) {
        data[j + 1] = data[j];
      }
      data[i] = ele;
    } else {
      long newCapacity = Math.round(getCapacity() * expendRatio);
      if (newCapacity <= getCapacity()) {
        newCapacity += expendStep;
      }
      if (newCapacity > Integer.MAX_VALUE) {
        newCapacity = Integer.MAX_VALUE;
      }
      Object[] newData = new Object[(int) newCapacity];
      for (int j = i; j < size; j++) {
        newData[j + 1] = data[j];
        data[j] = null;
      }
      newData[i] = ele;
      for (int j = 0; j < i; j++) {
        newData[j] = data[j];
        data[j] = null;
      }
      data = newData;
    }
    size++;
  }

  public void delete(int i) {
    checkIndex(i);
    for (int j = i; j < size - 1; j++) {
      data[j] = data[j + 1];
    }
    data[size - 1] = null;
    size--;
  }

  public void append(E ele) {
    if (getCapacity() == Integer.MAX_VALUE) {
      throw new IllegalArgumentException("List size is max, can not append any more.");
    }
    setSize(size + 1);
    data[size - 1] = ele;
  }

  public void deleteToTop(int i) {
    checkIndex(i);
    int diff = i + 1;
    int limit = size - diff;
    for (int j = 0; j < limit; j++) {
      data[j] = data[j + diff];
    }
    for (int j = limit; j < size; j++) {
      data[j] = null;
    }
    size = limit;
  }

  public void deleteToEnd(int i) {
    checkIndex(i);
    for (int j = i; j < size; j++) {
      data[j] = null;
    }
    size = i;
  }

  private void checkIndex(int i) {
    if (i >= size || i < 0) {
      throw new ArrayIndexOutOfBoundsException("size is " + size + "; index is " + i);
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof ArrayList)) {
      return false;
    }
    ArrayList other = (ArrayList) obj;
    if (this.size != other.size) {
      return false;
    } else if (this.size - other.size == 0) {
      return true;
    }
    for (int i = 0; i < size; i++) {
      if (this.data[i] == null) {
        if (other.data[i] != null) {
          return false;
        }
      } else if (!this.data[i].equals(other.data[i])) {
        return false;
      }
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    for (int i = 0; i < size; i++) {
      result = 31 * result + (data[i] == null ? 0 : data[i].hashCode());
    }
    result = 31 * result + size;
    return result;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder(64);
    sb.append("ArrayList{size=");
    sb.append(size);
    sb.append(",");
    sb.append("data={");
    for (int i = 0; i < size; i++) {
      sb.append(data[i]);
      if (i < size - 1) {
        sb.append(',');
      }
    }
    sb.append("}}");
    return sb.toString();
  }

  /**
   * Returns a shallow copy of this <tt>ArrayList</tt> instance.  (The elements themselves are not copied.)
   *
   * @return a clone of this <tt>ArrayList</tt> instance
   */
  @Override
  public ArrayList<E> clone() {
    ArrayList copy = new ArrayList();
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
