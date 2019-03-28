package com.github.wahaha2019.exercise;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.wahaha2019.exercise.ArrayList.newIntSerial;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SortedArrayTest {

  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void insert() {
    SortedArrayList<Integer> list1 = new SortedArrayList<Integer>(1);
    for (int i = 0; i < 10; i++) {
      list1.insert(i);
    }
    ArrayList list2 = newIntSerial(10);
    assertEquals(list1, list2);
    assertEquals(list1.hashCode(), list2.hashCode());
    SortedArrayList<Integer> list3 = new SortedArrayList<Integer>(1);
    for (int i = 9; i >= 0; i--) {
      list3.insert(i);
    }
    assertEquals(list3, list2);
    assertEquals(list3.hashCode(), list2.hashCode());
  }

  @Test
  void merge() {
    assertEquals(new SortedArrayList(), SortedArrayList.merge(new SortedArrayList(), new SortedArrayList()));
    SortedArrayList<Integer> src1 = SortedArrayList.newIntSerial(0, 2, 5);
    SortedArrayList<Integer> result = SortedArrayList.merge(src1, new SortedArrayList());
    System.out.println(src1);
    assertEquals(result, src1);
    result = SortedArrayList.merge(new SortedArrayList(), src1);
    assertEquals(result, src1);
    SortedArrayList<Integer> src2 = SortedArrayList.newIntSerial(1, 2, 5);
    System.out.println(src2);
    result = SortedArrayList.merge(src1, src2);
    SortedArrayList<Integer> serial = SortedArrayList.newIntSerial(10);
    assertEquals(result, serial);
    assertEquals(result.hashCode(), serial.hashCode());
  }
}