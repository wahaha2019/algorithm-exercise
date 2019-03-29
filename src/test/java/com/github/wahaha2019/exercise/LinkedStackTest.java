package com.github.wahaha2019.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest {

  @Test
  void push_pop() {
    LinkedStack<Integer> queue = new LinkedStack<>(5);
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