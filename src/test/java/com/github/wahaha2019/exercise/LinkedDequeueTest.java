package com.github.wahaha2019.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedDequeueTest {

  @Test
  void head_in_tail_out() {
    LinkedDequeue<Integer> queue = new LinkedDequeue<>(5);
    for (int i = 0; i < 5; i++) {
      assertTrue(queue.in_head(i));
    }
    assertEquals(queue.getSize(), 5);
    assertFalse(queue.in_head(5));
    for (int i = 0; i < 5; i++) {
      assertEquals(queue.out_tail(), i);
    }
    assertEquals(queue.getSize(), 0);
    for (int i = 0; i < 3; i++) {
      assertTrue(queue.in_head(i));
    }
    assertEquals(queue.getSize(), 3);
    for (int i = 0; i < 3; i++) {
      assertEquals(queue.out_tail(), i);
    }
    assertEquals(queue.getSize(), 0);
    for (int i = 0; i < 5; i++) {
      assertTrue(queue.in_head(i));
    }
    assertEquals(queue.getSize(), 5);
    assertFalse(queue.in_head(5));
    for (int i = 0; i < 5; i++) {
      assertEquals(queue.out_tail(), i);
    }
    assertEquals(queue.getSize(), 0);
  }

  @Test
  void tail_in_head_out() {
    LinkedDequeue<Integer> queue = new LinkedDequeue<>(5);
    for (int i = 0; i < 5; i++) {
      assertTrue(queue.in_tail(i));
    }
    assertEquals(queue.getSize(), 5);
    assertFalse(queue.in_tail(5));
    for (int i = 0; i < 5; i++) {
      assertEquals(queue.out_head(), i);
    }
    assertEquals(queue.getSize(), 0);
    for (int i = 0; i < 3; i++) {
      assertTrue(queue.in_tail(i));
    }
    assertEquals(queue.getSize(), 3);
    for (int i = 0; i < 3; i++) {
      assertEquals(queue.out_head(), i);
    }
    assertEquals(queue.getSize(), 0);
    for (int i = 0; i < 5; i++) {
      assertTrue(queue.in_tail(i));
    }
    assertEquals(queue.getSize(), 5);
    assertFalse(queue.in_tail(5));
    for (int i = 0; i < 5; i++) {
      assertEquals(queue.out_head(), i);
    }
    assertEquals(queue.getSize(), 0);
  }
}