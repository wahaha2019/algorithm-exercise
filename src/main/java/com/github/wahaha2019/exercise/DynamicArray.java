/*
 * This Java source file was generated by the Gradle 'init' task.
 */

package com.github.wahaha2019.exercise;

/**
 * DynamicArray is not thread safe. element can be null.
 *
 */
public class DynamicArray<E> {
    private static final int DEFAULT_CAPACITY = 256;
    private int size;
    private Object[] data;

    public DynamicArray(int capacity) {
        data = new Object[capacity];
        size = 0;
    }

    public DynamicArray() {
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

    public void setSize(int size) {
        if (size > getCapacity()) {
            Object[] newData = new Object[size];
            for (int i = 0; i < this.size; i++) {
                newData[i] = data[i];
                data[i] = null;
            }
            data = newData;
        }
        this.size = size;
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
        checkIndex(i);
        if (size + 1 <= getCapacity()) {
            for (int j = i; j < size; j++) {
                data[j+1] = data[j];
            }
            data[i] = ele;
        } else {
            Object[] newData = new Object[getCapacity() << 1];
            for (int j = i; j < size; j++) {
                newData[j+1] = data[j];
                data[j] = null;
            }
            newData[i] = ele;
            for (int j = 0; j < i; j++) {
                newData[j] = data[j];
                data[j] = null;
            }
            data = newData;
        }
        size ++;
    }

    private void checkIndex(int i) {
        if (i >= size || i < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}
