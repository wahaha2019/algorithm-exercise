package com.github.wahaha2019.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedQueueTest {

  @Test
  void queue() {
    LinkedQueue<Integer> queue = new LinkedQueue<>(5);
    for (int i = 0; i < 5; i++) {
      assertTrue(queue.inqueue(i));
    }
    assertEquals(queue.getSize(), 5);
    assertFalse(queue.inqueue(5));
    for (int i = 0; i < 5; i++) {
      assertEquals(queue.dequeue(), i);
    }
    assertEquals(queue.getSize(), 0);
    for (int i = 0; i < 3; i++) {
      assertTrue(queue.inqueue(i));
    }
    assertEquals(queue.getSize(), 3);
    for (int i = 0; i < 3; i++) {
      assertEquals(queue.dequeue(), i);
    }
    assertEquals(queue.getSize(), 0);
    for (int i = 0; i < 5; i++) {
      assertTrue(queue.inqueue(i));
    }
    assertEquals(queue.getSize(), 5);
    assertFalse(queue.inqueue(5));
    for (int i = 0; i < 5; i++) {
      assertEquals(queue.dequeue(), i);
    }
    assertEquals(queue.getSize(), 0);
  }
}