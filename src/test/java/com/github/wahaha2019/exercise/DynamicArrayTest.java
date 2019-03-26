/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.github.wahaha2019.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicArrayTest {

  @Test
  public void testCreation() {
    int capacity = 256;
    DynamicArray array = new DynamicArray(capacity);
    assertTrue(array.isEmpty());
    assertEquals(array.getSize(), 0);
    assertEquals(array.getCapacity(), capacity);
    int size = 128;
    array.setSize(size);
    assertFalse(array.isEmpty());
    assertEquals(array.getSize(), size);
    assertEquals(array.getCapacity(), capacity);
    size = 4096;
    array.setSize(size);
    assertTrue(array.isFull());
    assertFalse(array.isEmpty());
    assertEquals(array.getSize(), size);
    assertEquals(array.getCapacity(), size);
  }

  @Test
  public void testClear() {
    int capacity = 256;
    DynamicArray array = new DynamicArray(capacity);
    int size = 128;
    array.setSize(size);
    array.clear();
    assertTrue(array.isEmpty());
    assertEquals(array.getSize(), 0);
    assertEquals(array.getCapacity(), capacity);
  }

  @Test
  public void testGet() {
    int capacity = 256;
    DynamicArray array = new DynamicArray(capacity);
    assertThrows(IndexOutOfBoundsException.class, () -> {
      Object ele = array.get(0);
    });
  }

  @Test
  public void testSet() {
    int capacity = 256;
    DynamicArray array = new DynamicArray<String>(capacity);
    assertThrows(IndexOutOfBoundsException.class, () -> {
      array.set(0, "0");
    });
    array.setSize(1);
    array.set(0, "0");
    assertEquals(array.get(0), "0");
    array.setSize(2);
    assertNull(array.get(1));
    array.set(1, "1");
    assertEquals(array.get(1), "1");
  }

  @Test
  public void testInsert() {
    int capacity = 3;
    DynamicArray array = new DynamicArray<String>(capacity);
    array.setSize(1);
    array.set(0, "1");
    array.insert(0, "0");
    assertEquals(array.get(0), "0");
    assertEquals(array.get(1), "1");
    assertEquals(array.getSize(), 2);
    array.insert(1, "b");
    assertEquals(array.get(0), "0");
    assertEquals(array.get(1), "b");
    assertEquals(array.get(2), "1");
    assertEquals(array.getSize(), 3);
    array.insert(2, "B");
    assertEquals(array.get(0), "0");
    assertEquals(array.get(1), "b");
    assertEquals(array.get(2), "B");
    assertEquals(array.get(3), "1");
    assertEquals(array.getSize(), 4);
  }

  @Test
  public void testDelete() {
    DynamicArray array = newIntSerial(3);
    array.delete(0);
    assertEquals(array.get(0), 1);
    assertEquals(array.get(1), 2);
    assertEquals(array.getSize(), 2);
    array = newIntSerial(3);
    array.delete(1);
    assertEquals(array.get(0), 0);
    assertEquals(array.get(1), 2);
    assertEquals(array.getSize(), 2);
    array = newIntSerial(3);
    array.delete(2);
    assertEquals(array.get(0), 0);
    assertEquals(array.get(1), 1);
    assertEquals(array.getSize(), 2);
  }

  @Test
  public void testAppend() {
    DynamicArray array = newIntSerial(3);
    array.append(3);
    assertEquals(array.get(0), 0);
    assertEquals(array.get(1), 1);
    assertEquals(array.get(2), 2);
    assertEquals(array.get(3), 3);
    assertEquals(array.getSize(), 4);
  }

  @Test
  public void testDeleteToTop() {
    DynamicArray array = newIntSerial(3);
    array.deleteToTop(1);
    assertEquals(array.get(0), 2);
    assertEquals(array.getSize(), 1);
    array = newIntSerial(3);
    array.deleteToTop(0);
    assertEquals(array.get(0), 1);
    assertEquals(array.get(1), 2);
    assertEquals(array.getSize(), 2);
    array = newIntSerial(5);
    array.deleteToTop(2);
    assertEquals(array.get(0), 3);
    assertEquals(array.get(1), 4);
    assertEquals(array.getSize(), 2);
    array = newIntSerial(5);
    array.deleteToTop(3);
    assertEquals(array.get(0), 4);
    assertEquals(array.getSize(), 1);
    array = newIntSerial(5);
    array.deleteToTop(4);
    assertTrue(array.isEmpty());
  }

  @Test
  public void testDeleteToEnd() {
    DynamicArray array = newIntSerial(3);
    array.deleteToEnd(1);
    assertEquals(array.get(0), 0);
    assertEquals(array.getSize(), 1);
    array = newIntSerial(5);
    array.deleteToEnd(0);
    assertTrue(array.isEmpty());
  }

  @Test
  public void testEquals() {
    DynamicArray array1 = newIntSerial(3);
    DynamicArray array2 = newIntSerial(5);
    assertNotEquals(array1, array2);
    array2.setSize(3);
    assertEquals(array1, array2);
  }

  @Test
  public void testHash() {
    DynamicArray array1 = newIntSerial(3);
    DynamicArray array2 = newIntSerial(5);
    array2.setSize(3);
    assertEquals(array1.hashCode(), array2.hashCode());
  }

  @Test
  public void testToString() {
    DynamicArray array1 = newIntSerial(3);
    DynamicArray array2 = newIntSerial(5);
    array2.setSize(3);
    System.out.println(array1.toString());
    assertEquals(array1.toString(), "DynamicArray{size=3,data={0,1,2}}");
    assertEquals(array1.toString(), array2.toString());
  }

  private DynamicArray newIntSerial(int size) {
    DynamicArray array = new DynamicArray<String>(size);
    array.setSize(size);
    for (int i = 0; i < size; i++) {
      array.set(i, i);
    }
    return array;
  }

}
