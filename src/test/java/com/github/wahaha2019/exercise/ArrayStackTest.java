package com.github.wahaha2019.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {

  @Test
  void push_pop() {
    ArrayStack<Integer> queue = new ArrayStack<>(5);
    for (int i = 0; i < 5; i++) {
      assertTrue(queue.push(i));
    }
    assertEquals(queue.getSize(), 5);
    assertFalse(queue.push(5));
    for (int i = 4; i >= 0; i--) {
      assertEquals(queue.pop(), i);
    }
    assertEquals(queue.getSize(), 0);
    assertNull(queue.pop());
  }
}