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
    SortedArrayList<Integer> aist1 = new SortedArrayList<Integer>(1);
    for (int i = 0; i < 10; i++) {
      aist1.insert(i);
    }
    ArrayList aist2 = newIntSerial(10);
    assertEquals(aist1, aist2);
    assertEquals(aist1.hashCode(), aist2.hashCode());
    SortedArrayList<Integer> aist3 = new SortedArrayList<Integer>(1);
    for (int i = 9; i >= 0; i--) {
      aist3.insert(i);
    }
    assertEquals(aist3, aist2);
    assertEquals(aist3.hashCode(), aist2.hashCode());
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