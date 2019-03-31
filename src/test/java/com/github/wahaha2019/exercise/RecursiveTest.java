package com.github.wahaha2019.exercise;

import org.junit.jupiter.api.Test;

import static com.github.wahaha2019.exercise.Recursive.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RecursiveTest {

  @Test
  public void fib() {
    assertEquals(fibonacci(0), 0);
    assertEquals(fibonacci(1), 1);
    assertEquals(fibonacci(2), 1);
    assertEquals(fibonacci(3), 2);
    assertEquals(fibonacci(4), 3);
    assertEquals(fibonacci(5), 5);
    assertEquals(fibonacci(6), 8);
    assertEquals(fibonacci(7), 13);
    assertEquals(fibonacci(8), 21);
    assertEquals(fibonacci(9), 34);
    assertEquals(fibonacci(10), 55);
  }

  @Test
  public void _factorial() {
    assertEquals(factorial(1), 1);
    assertEquals(factorial(2), 2);
    assertEquals(factorial(3), 6);
    assertEquals(factorial(4), 24);
    assertEquals(factorial(5), 120);
    assertEquals(factorial(6), 720);
    assertEquals(factorial(7), 5040);
    assertEquals(factorial(8), 40320);
    assertEquals(factorial(9), 362880);
    assertEquals(factorial(10), 3628800);
  }

  @Test
  public void huge_factorial() {
    assertThrows(ArithmeticException.class, () -> {
      factorial(53);
    });
  }

  @Test
  public void _complete_permutate() {
    final ArrayList<Integer> numbers = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      numbers.append(i);
    }
    final ArrayList<ArrayList<Integer>> list = complete_permutate(numbers);
    assertEquals(list.size, 24);
    System.out.println(list);
  }

}