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
}