package com.github.wahaha2019.exercise;

import org.junit.jupiter.api.Test;

import static com.github.wahaha2019.exercise.LinkedList.newIntSerial;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

  @Test
  public void clear() {
    LinkedList list = newIntSerial(10);
    assertEquals(list.getSize(), 10);
    list.clear();
    assertTrue(list.isEmpty());
    assertEquals(list.getSize(), 0);
  }

  @Test
  public void reverse() {
    LinkedList list = newIntSerial(5);
    list.reverse();
    assertEquals(list.toString(), "LinkedList{size=5,data={4,3,2,1,0}}");
  }

  @Test
  public void get() {
    LinkedList list = new LinkedList();
    assertTrue(list.isEmpty());
    assertThrows(IndexOutOfBoundsException.class, () -> {
      Object ele = list.get(0);
    });
  }

  @Test
  public void set() {
    LinkedList<String> list = new LinkedList<>();
    list.append("0");
    assertEquals(list.get(0), "0");
    list.append("1");
    assertEquals(list.get(1), "1");
    list.set(0, "00");
    assertEquals(list.get(0), "00");
    list.set(1, "11");
    assertEquals(list.get(1), "11");
  }

  @Test
  public void insert() {
    LinkedList list = new LinkedList<String>();
    list.insert(0, "1");
    assertEquals(list.get(0), "1");
    assertEquals(list.getSize(), 1);
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
    System.out.println(list);
    assertEquals(list.get(0), "0");
    assertEquals(list.get(1), "b");
    assertEquals(list.get(2), "B");
    assertEquals(list.get(3), "1");
    assertEquals(list.getSize(), 4);
    LinkedList list2 = newIntSerial(10);
    LinkedList<Integer> list3 = new LinkedList<Integer>();
    for (int i = 9; i >= 0; i--) {
      list3.insert(0, i);
    }
    assertEquals(list3, list2);
    assertEquals(list3.hashCode(), list2.hashCode());
  }

  @Test
  public void delete() {
    LinkedList list = newIntSerial(3);
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
    LinkedList list = newIntSerial(3);
    list.append(3);
    assertEquals(list.get(0), 0);
    assertEquals(list.get(1), 1);
    assertEquals(list.get(2), 2);
    assertEquals(list.get(3), 3);
    assertEquals(list.getSize(), 4);
  }

  @Test
  public void equals() {
    LinkedList list1 = newIntSerial(3);
    LinkedList list2 = newIntSerial(5);
    assertNotEquals(list1, list2);
    list2.delete(3);
    list2.delete(3);
    assertEquals(list1, list2);
  }

  @Test
  public void hash() {
    LinkedList list1 = newIntSerial(3);
    LinkedList list2 = newIntSerial(5);
    list2.delete(3);
    list2.delete(3);
    assertEquals(list1.hashCode(), list2.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(new LinkedList().toString(), "LinkedList{size=0,data={}}");
    LinkedList list1 = newIntSerial(3);
    LinkedList list2 = newIntSerial(5);
    list2.delete(3);
    list2.delete(3);
    System.out.println(list1);
    assertEquals(list1.toString(), "LinkedList{size=3,data={0,1,2}}");
    assertEquals(list1.toString(), list2.toString());
  }

}