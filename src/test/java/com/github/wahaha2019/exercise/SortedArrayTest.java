package com.github.wahaha2019.exercise;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.wahaha2019.exercise.DynamicArray.newIntSerial;
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
    SortedArray<Integer> array1 = new SortedArray<Integer>(1);
    for (int i = 0; i < 10; i++) {
      array1.insert(i);
    }
    DynamicArray array2 = newIntSerial(10);
    assertEquals(array1, array2);
    assertEquals(array1.hashCode(), array2.hashCode());
    SortedArray<Integer> array3 = new SortedArray<Integer>(1);
    for (int i = 9; i >= 0; i--) {
      array3.insert(i);
    }
    assertEquals(array3, array2);
    assertEquals(array3.hashCode(), array2.hashCode());
  }

  @Test
  void append() {
    SortedArray<Integer> array1 = new SortedArray<Integer>(1);
    for (int i = 0; i < 10; i++) {
      array1.append(i);
    }
    DynamicArray array2 = newIntSerial(10);
    assertEquals(array1, array2);
    assertEquals(array1.hashCode(), array2.hashCode());
  }

  @Test
  void merge() {
    SortedArray<Integer> src1 = SortedArray.newIntSerial(0, 2, 5);
    SortedArray<Integer> result = SortedArray.merge(src1, new SortedArray(1));
    System.out.println(src1);
    assertEquals(result, src1);
    result = SortedArray.merge(new SortedArray(1), src1);
    assertEquals(result, src1);
    SortedArray<Integer> src2 = SortedArray.newIntSerial(1, 2, 5);
    System.out.println(src2);
    result = SortedArray.merge(src1, src2);
    SortedArray<Integer> serial = SortedArray.newIntSerial(10);
    assertEquals(result, serial);
    assertEquals(result.hashCode(), serial.hashCode());
  }
}