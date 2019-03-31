package com.github.wahaha2019.exercise;

public class Recursive {
  public static long fibonacci(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("n must not less than 0");
    }
    if (n == 0) {
      return 0;
    }
    return _fibonacci(n);
  }

  private static long _fibonacci(int n) {
    if (n <= 2) {
      return 1;
    } else {
      return Math.addExact(fibonacci(n - 1), fibonacci(n - 2));
    }
  }

  public static long factorial(int n) {
    if (n <= 0) {
      throw new IllegalArgumentException("n must greater than 0");
    }
    return _factorial(n);
  }

  private static long _factorial(int n) {
    if (n == 1) {
      return 1;
    } else {
      return Math.multiplyExact(n, _factorial(n - 1));
    }
  }

  public static ArrayList<ArrayList<Integer>> complete_permutate(ArrayList<Integer> numbers) {
    ArrayList<ArrayList<Integer>> result = new ArrayList();
    if (numbers.getSize() == 1) {
      result.append(numbers);
    } else {
      for (int i = 0; i < numbers.size; i++) {
        int idx = i;
        ArrayList<Integer> other = numbers.clone();
        other.delete(idx);
        ArrayList<ArrayList<Integer>> other_permutation = complete_permutate(other);
        for (int j = 0; j < other_permutation.size; j++) {
          ArrayList<Integer> per = other_permutation.get(j);
          per.append(numbers.get(idx));
          result.append(per);
        }
      }
    }
    return result;
  }

}
