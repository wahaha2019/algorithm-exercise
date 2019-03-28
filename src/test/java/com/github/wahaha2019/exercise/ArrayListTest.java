/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.github.wahaha2019.exercise;

import org.junit.jupiter.api.Test;

import java.io.*;

import static com.github.wahaha2019.exercise.ArrayList.newIntSerial;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

  @Test
  public void create() {
    int capacity = 256;
    ArrayList list = new ArrayList(capacity);
    assertTrue(list.isEmpty());
    assertEquals(list.getSize(), 0);
    assertEquals(list.getCapacity(), capacity);
    int size = 128;
    list.setSize(size);
    assertFalse(list.isEmpty());
    assertEquals(list.getSize(), size);
    assertEquals(list.getCapacity(), capacity);
    size = 4096;
    list.setSize(size);
    assertTrue(list.isFull());
    assertFalse(list.isEmpty());
    assertEquals(list.getSize(), size);
    assertEquals(list.getCapacity(), size);
  }

  @Test
  public void _clone() {
    ArrayList list1 = newIntSerial(5);
    ArrayList list2 = list1.clone();
    assertEquals(list1, list2);
  }

  @Test
  public void serialize() throws IOException, ClassNotFoundException {
    ArrayList list1 = newIntSerial(5);
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream os = new ObjectOutputStream(bos);
    os.writeObject(list1);
    os.close();
    ArrayList list2 = (ArrayList) new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray())).readObject();
    assertEquals(list1, list2);
  }

  @Test
  public void clear() {
    int capacity = 256;
    ArrayList list = new ArrayList(capacity);
    int size = 128;
    list.setSize(size);
    list.clear();
    assertTrue(list.isEmpty());
    assertEquals(list.getSize(), 0);
    assertEquals(list.getCapacity(), capacity);
  }

  @Test
  public void get() {
    int capacity = 256;
    ArrayList list = new ArrayList(capacity);
    assertThrows(IndexOutOfBoundsException.class, () -> {
      Object ele = list.get(0);
    });
  }

  @Test
  public void set() {
    int capacity = 256;
    ArrayList<String> list = new ArrayList<>(capacity);
    assertThrows(IndexOutOfBoundsException.class, () -> {
      list.set(0, "0");
    });
    list.setSize(1);
    list.set(0, "0");
    assertEquals(list.get(0), "0");
    list.setSize(2);
    assertNull(list.get(1));
    list.set(1, "1");
    assertEquals(list.get(1), "1");
  }

  @Test
  public void insert() {
    int capacity = 3;
    ArrayList<String> list = new ArrayList<>(capacity);
    list.insert(0, "0");
    assertEquals(list.get(0), "0");
    assertEquals(list.getSize(), 1);
    list.setSize(1);
    list.set(0, "1");
    list.insert(0, "0");
    assertEquals(list.get(0), "0");
    assertEquals(list.get(1), "1");
    assertEquals(list.getSize(), 2);
    list.insert(1, "b");
    assertEquals(list.get(0), "0");
    assertEquals(list.get(1), "b");
    assertEquals(list.get(2), "1");
    assertEquals(list.getSize(), 3);
    list.insert(2, "B");
    assertEquals(list.get(0), "0");
    assertEquals(list.get(1), "b");
    assertEquals(list.get(2), "B");
    assertEquals(list.get(3), "1");
    assertEquals(list.getSize(), 4);
    ArrayList list2 = newIntSerial(10);
    ArrayList<Integer> list3 = new ArrayList<Integer>(10);
    list3.append(9);
    for (int i = 8; i >= 0; i--) {
      list3.insert(0, i);
    }
    assertEquals(list3, list2);
    assertEquals(list3.hashCode(), list2.hashCode());
  }

  @Test
  public void delete() {
    ArrayList list = newIntSerial(3);
    list.delete(0);
    assertEquals(list.get(0), 1);
    assertEquals(list.get(1), 2);
    assertEquals(list.getSize(), 2);
    list = newIntSerial(3);
    list.delete(1);
    assertEquals(list.get(0), 0);
    assertEquals(list.get(1), 2);
    assertEquals(list.getSize(), 2);
    list = newIntSerial(3);
    list.delete(2);
    assertEquals(list.get(0), 0);
    assertEquals(list.get(1), 1);
    assertEquals(list.getSize(), 2);
  }

  @Test
  public void append() {
    ArrayList list = newIntSerial(3);
    list.append(3);
    assertEquals(list.get(0), 0);
    assertEquals(list.get(1), 1);
    assertEquals(list.get(2), 2);
    assertEquals(list.get(3), 3);
    assertEquals(list.getSize(), 4);
  }

  @Test
  public void deleteToTop() {
    ArrayList list = newIntSerial(3);
    list.deleteToTop(1);
    assertEquals(list.get(0), 2);
    assertEquals(list.getSize(), 1);
    list = newIntSerial(3);
    list.deleteToTop(0);
    assertEquals(list.get(0), 1);
    assertEquals(list.get(1), 2);
    assertEquals(list.getSize(), 2);
    list = newIntSerial(5);
    list.deleteToTop(2);
    assertEquals(list.get(0), 3);
    assertEquals(list.get(1), 4);
    assertEquals(list.getSize(), 2);
    list = newIntSerial(5);
    list.deleteToTop(3);
    assertEquals(list.get(0), 4);
    assertEquals(list.getSize(), 1);
    list = newIntSerial(5);
    list.deleteToTop(4);
    assertTrue(list.isEmpty());
  }

  @Test
  public void deleteToEnd() {
    ArrayList list = newIntSerial(3);
    list.deleteToEnd(1);
    assertEquals(list.get(0), 0);
    assertEquals(list.getSize(), 1);
    list = newIntSerial(5);
    list.deleteToEnd(0);
    assertTrue(list.isEmpty());
  }

  @Test
  public void equals() {
    ArrayList list1 = newIntSerial(3);
    ArrayList list2 = newIntSerial(5);
    assertNotEquals(list1, list2);
    list2.setSize(3);
    assertEquals(list1, list2);
  }

  @Test
  public void hash() {
    ArrayList list1 = newIntSerial(3);
    ArrayList list2 = newIntSerial(5);
    list2.setSize(3);
    assertEquals(list1.hashCode(), list2.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(new ArrayList().toString(), "ArrayList{size=0,data={}}");
    ArrayList list1 = newIntSerial(3);
    ArrayList list2 = newIntSerial(5);
    list2.setSize(3);
    System.out.println(list1);
    assertEquals(list1.toString(), "ArrayList{size=3,data={0,1,2}}");
    assertEquals(list1.toString(), list2.toString());
  }

}
