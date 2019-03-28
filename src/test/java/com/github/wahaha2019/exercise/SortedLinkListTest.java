package com.github.wahaha2019.exercise;

import org.junit.jupiter.api.Test;

import static com.github.wahaha2019.exercise.SortedLinkList.merge;
import static com.github.wahaha2019.exercise.SortedLinkList.newIntSerial;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SortedLinkListTest {

  @Test
  void create() {
    SortedLinkList<Integer> list = newIntSerial(5);
    assertEquals(list.getSize(), 5);
    assertEquals(list.toString(), "LinkedList{size=5,data={0,1,2,3,4}}");
    list = newIntSerial(1, 2, 5);
    assertEquals(list.getSize(), 5);
    assertEquals(list.toString(), "LinkedList{size=5,data={1,3,5,7,9}}");
  }

  @Test
  void insert() {
    SortedLinkList<Integer> list1 = new SortedLinkList<Integer>();
    for (int i = 0; i < 10; i++) {
      list1.insert(i);
    }
    SortedLinkList list2 = newIntSerial(10);
    assertEquals(list1, list2);
    assertEquals(list1.hashCode(), list2.hashCode());
    SortedLinkList<Integer> list3 = new SortedLinkList<Integer>();
    for (int i = 9; i >= 0; i--) {
      list3.insert(i);
    }
    assertEquals(list3, list2);
    assertEquals(list3.hashCode(), list2.hashCode());
  }

  @Test
  void merge2() {
    assertEquals(new SortedLinkList(), merge(new SortedLinkList(), new SortedLinkList()));
    SortedLinkList<Integer> src1 = SortedLinkList.newIntSerial(0, 2, 5);
    SortedLinkList<Integer> result = merge(src1, new SortedLinkList());
    System.out.println(src1);
    assertEquals(result, src1);
    result = merge(new SortedLinkList(), src1);
    assertEquals(result, src1);
    SortedLinkList<Integer> src2 = SortedLinkList.newIntSerial(1, 2, 5);
    System.out.println(src2);
    result = merge(src1, src2);
    System.out.println(result);
    SortedLinkList<Integer> serial = SortedLinkList.newIntSerial(10);
    assertEquals(result, serial);
    assertEquals(result.hashCode(), serial.hashCode());
  }
}