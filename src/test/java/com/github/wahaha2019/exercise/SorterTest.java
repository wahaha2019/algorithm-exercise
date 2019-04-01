package com.github.wahaha2019.exercise;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SorterTest {

  @Test
  void bubble() {
    int[] a = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    System.out.println(Arrays.toString(Sorter.bubble(a)));
    assertEquals(Arrays.toString(Sorter.bubble(a)), "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]");
    a = new int[]{0, 1};
    assertEquals(Arrays.toString(Sorter.bubble(a)), "[0, 1]");
    a = new int[]{1, 0};
    assertEquals(Arrays.toString(Sorter.bubble(a)), "[0, 1]");
    a = new int[]{9, 0, 1, 2, 3, 4, 5, 6, 7, 8};
    assertEquals(Arrays.toString(Sorter.bubble(a)), "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]");
    a = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    assertEquals(Arrays.toString(Sorter.bubble(a)), "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]");
  }

}