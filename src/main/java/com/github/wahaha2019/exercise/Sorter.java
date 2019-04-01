package com.github.wahaha2019.exercise;

public class Sorter {
  public static int[] bubble(int[] src) {
    if (src.length <= 1) {
      return src;
    }
    for (int i = src.length - 1; i >= 1; i--) {
      boolean found = false;
      for (int j = 0; j < i; j++) {
        if (src[j] > src[j + 1]) {
          swap(src, j, j + 1);
          if (!found) {
            found = true;
          }
        }
        if (!found) {
          break;
        }
      }
    }
    return src;
  }

  private static void swap(int[] a, int x, int y) {
    int tmp = a[x];
    a[x] = a[y];
    a[y] = tmp;
  }
}
