package com.github.wahaha2019.exercise;

import org.junit.jupiter.api.Test;

import java.io.*;

import static com.github.wahaha2019.exercise.SortedArrayList.merge;
import static com.github.wahaha2019.exercise.SortedArrayList.newIntSerial;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SortedArrayListTest {

  @Test
  public void _clone() {
    SortedArrayList list1 = newIntSerial(5);
    SortedArrayList list2 = list1.clone();
    assertEquals(list1, list2);
  }

  @Test
  public void serialize() throws IOException, ClassNotFoundException {
    SortedArrayList list1 = newIntSerial(5);
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream os = new ObjectOutputStream(bos);
    os.writeObject(list1);
    os.close();
    SortedArrayList list2 = (SortedArrayList) new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray())).readObject();
    assertEquals(list1, list2);
  }

  @Test
  void insert() {
    SortedArrayList<Integer> list1 = new SortedArrayList<>(1);
    for (int i = 0; i < 10; i++) {
      list1.insert(i);
    }
    ArrayList list2 = newIntSerial(10);
    assertEquals(list1, list2);
    assertEquals(list1.hashCode(), list2.hashCode());
    SortedArrayList<Integer> list3 = new SortedArrayList<>(1);
    for (int i = 9; i >= 0; i--) {
      list3.insert(i);
    }
    assertEquals(list3, list2);
    assertEquals(list3.hashCode(), list2.hashCode());
  }

  @Test
  void merge2() {
    assertEquals(new SortedArrayList(), merge(new SortedArrayList(), new SortedArrayList()));
    SortedArrayList<Integer> src1 = SortedArrayList.newIntSerial(0, 2, 5);
    SortedArrayList<Integer> result = merge(src1, new SortedArrayList());
    System.out.println(src1);
    assertEquals(result, src1);
    result = merge(new SortedArrayList(), src1);
    assertEquals(result, src1);
    SortedArrayList<Integer> src2 = SortedArrayList.newIntSerial(1, 2, 5);
    System.out.println(src2);
    result = merge(src1, src2);
    SortedArrayList<Integer> serial = SortedArrayList.newIntSerial(10);
    assertEquals(result, serial);
    assertEquals(result.hashCode(), serial.hashCode());
  }

  @Test
  void merge3() {
    SortedArrayList<Integer> src1 = SortedArrayList.newIntSerial(0, 3, 5);
    SortedArrayList<Integer> src2 = SortedArrayList.newIntSerial(1, 3, 5);
    SortedArrayList<Integer> src3 = SortedArrayList.newIntSerial(2, 3, 5);
    System.out.println(src2);
    SortedArrayList result = merge(new SortedArrayList[]{src1, src2, src3});
    System.out.println(result);
    SortedArrayList<Integer> serial = SortedArrayList.newIntSerial(15);
    assertEquals(result, serial);
    assertEquals(result.hashCode(), serial.hashCode());
  }

  @Test
  void bsearch() {
    SortedArrayList<Integer> list = new SortedArrayList<>();
    assertEquals(list.binarySearch(0), -1);

    list = SortedArrayList.fromArray(new Integer[]{1, 2, 3});
    assertEquals(list.binarySearch(1), 0);
    assertEquals(list.binarySearch(2), 1);
    assertEquals(list.binarySearch(3), 2);
    assertEquals(list.binarySearch(0), -1);
    assertEquals(list.binarySearch(4), -1);

    list = SortedArrayList.fromArray(new Integer[]{1, 2, 3, 4});
    assertEquals(list.binarySearch(1), 0);
    assertEquals(list.binarySearch(2), 1);
    assertEquals(list.binarySearch(3), 2);
    assertEquals(list.binarySearch(4), 3);
    assertEquals(list.binarySearch(0), -1);
    assertEquals(list.binarySearch(5), -1);

    list = SortedArrayList.fromArray(new Integer[]{1, 2, 3, 4, 5});
    assertEquals(list.binarySearch(1), 0);
    assertEquals(list.binarySearch(2), 1);
    assertEquals(list.binarySearch(3), 2);
    assertEquals(list.binarySearch(4), 3);
    assertEquals(list.binarySearch(5), 4);
    assertEquals(list.binarySearch(0), -1);
    assertEquals(list.binarySearch(6), -1);

    list = SortedArrayList.fromArray(new Integer[]{1, 1, 1});
    assertEquals(list.binarySearch(1), 0);
    assertEquals(list.binarySearch(0), -1);
    assertEquals(list.binarySearch(2), -1);

    list = SortedArrayList.fromArray(new Integer[]{1, 2, 2});
    assertEquals(list.binarySearch(1), 0);
    assertEquals(list.binarySearch(2), 1);
    assertEquals(list.binarySearch(0), -1);
    assertEquals(list.binarySearch(3), -1);

    list = SortedArrayList.fromArray(new Integer[]{1, 2, 2, 2});
    assertEquals(list.binarySearch(1), 0);
    assertEquals(list.binarySearch(2), 1);
    assertEquals(list.binarySearch(0), -1);
    assertEquals(list.binarySearch(3), -1);

    list = SortedArrayList.fromArray(new Integer[]{1, 2, 2, 2, 2});
    assertEquals(list.binarySearch(1), 0);
    assertEquals(list.binarySearch(2), 1);
    assertEquals(list.binarySearch(0), -1);
    assertEquals(list.binarySearch(3), -1);

    list = SortedArrayList.fromArray(new Integer[]{1, 1, 2, 2, 2});
    assertEquals(list.binarySearch(1), 0);
    assertEquals(list.binarySearch(2), 2);
    assertEquals(list.binarySearch(0), -1);
    assertEquals(list.binarySearch(3), -1);

    list = SortedArrayList.fromArray(new Integer[]{1, 1, 2, 2, 2, 2});
    assertEquals(list.binarySearch(1), 0);
    assertEquals(list.binarySearch(2), 2);
    assertEquals(list.binarySearch(0), -1);
    assertEquals(list.binarySearch(3), -1);

    list = SortedArrayList.fromArray(new Integer[]{1, 1, 2, 2, 2, 2, 2});
    assertEquals(list.binarySearch(1), 0);
    assertEquals(list.binarySearch(2), 2);
    assertEquals(list.binarySearch(0), -1);
    assertEquals(list.binarySearch(3), -1);

    list = SortedArrayList.fromArray(new Integer[]{1, 1, 1, 2, 2, 2});
    assertEquals(list.binarySearch(1), 0);
    assertEquals(list.binarySearch(2), 3);
    assertEquals(list.binarySearch(0), -1);
    assertEquals(list.binarySearch(3), -1);

    list = SortedArrayList.fromArray(new Integer[]{1, 1, 1, 2, 2, 2, 2});
    assertEquals(list.binarySearch(1), 0);
    assertEquals(list.binarySearch(2), 3);
    assertEquals(list.binarySearch(0), -1);
    assertEquals(list.binarySearch(3), -1);

    list = SortedArrayList.fromArray(new Integer[]{1, 1, 1, 2, 2, 2, 2, 2});
    assertEquals(list.binarySearch(1), 0);
    assertEquals(list.binarySearch(2), 3);
    assertEquals(list.binarySearch(0), -1);
    assertEquals(list.binarySearch(3), -1);

    list = SortedArrayList.fromArray(new Integer[]{1, 1, 1, 2, 2, 2, 2, 2, 2});
    assertEquals(list.binarySearch(1), 0);
    assertEquals(list.binarySearch(2), 3);
    assertEquals(list.binarySearch(0), -1);
    assertEquals(list.binarySearch(3), -1);
  }

  @Test
  void binarySearchLastLessEquals() {
    SortedArrayList<Integer> list = new SortedArrayList<>();
    assertEquals(list.binarySearchLastLessEquals(0), -1);

    list = SortedArrayList.fromArray(new Integer[]{1, 2, 3});
    assertEquals(list.binarySearchLastLessEquals(1), 0);
    assertEquals(list.binarySearchLastLessEquals(2), 1);
    assertEquals(list.binarySearchLastLessEquals(3), 2);
    assertEquals(list.binarySearchLastLessEquals(0), -1);
    assertEquals(list.binarySearchLastLessEquals(4), 2);

    list = SortedArrayList.fromArray(new Integer[]{1, 2, 3, 4});
    assertEquals(list.binarySearchLastLessEquals(1), 0);
    assertEquals(list.binarySearchLastLessEquals(2), 1);
    assertEquals(list.binarySearchLastLessEquals(3), 2);
    assertEquals(list.binarySearchLastLessEquals(4), 3);
    assertEquals(list.binarySearchLastLessEquals(0), -1);
    assertEquals(list.binarySearchLastLessEquals(5), 3);

    list = SortedArrayList.fromArray(new Integer[]{1, 2, 3, 4, 5});
    assertEquals(list.binarySearchLastLessEquals(1), 0);
    assertEquals(list.binarySearchLastLessEquals(2), 1);
    assertEquals(list.binarySearchLastLessEquals(3), 2);
    assertEquals(list.binarySearchLastLessEquals(4), 3);
    assertEquals(list.binarySearchLastLessEquals(5), 4);
    assertEquals(list.binarySearchLastLessEquals(0), -1);
    assertEquals(list.binarySearchLastLessEquals(6), 4);

    list = SortedArrayList.fromArray(new Integer[]{1, 1, 1});
    assertEquals(list.binarySearchLastLessEquals(1), 2);
    assertEquals(list.binarySearchLastLessEquals(0), -1);
    assertEquals(list.binarySearchLastLessEquals(2), 2);

    list = SortedArrayList.fromArray(new Integer[]{1, 2, 2});
    assertEquals(list.binarySearchLastLessEquals(1), 0);
    assertEquals(list.binarySearchLastLessEquals(2), 2);
    assertEquals(list.binarySearchLastLessEquals(0), -1);
    assertEquals(list.binarySearchLastLessEquals(3), 2);

    list = SortedArrayList.fromArray(new Integer[]{1, 2, 2, 2});
    assertEquals(list.binarySearchLastLessEquals(1), 0);
    assertEquals(list.binarySearchLastLessEquals(2), 3);
    assertEquals(list.binarySearchLastLessEquals(0), -1);
    assertEquals(list.binarySearchLastLessEquals(3), 3);

    list = SortedArrayList.fromArray(new Integer[]{1, 2, 2, 2, 2});
    assertEquals(list.binarySearchLastLessEquals(1), 0);
    assertEquals(list.binarySearchLastLessEquals(2), 4);
    assertEquals(list.binarySearchLastLessEquals(0), -1);
    assertEquals(list.binarySearchLastLessEquals(3), 4);

    list = SortedArrayList.fromArray(new Integer[]{1, 1, 2, 2, 2});
    assertEquals(list.binarySearchLastLessEquals(1), 1);
    assertEquals(list.binarySearchLastLessEquals(2), 4);
    assertEquals(list.binarySearchLastLessEquals(0), -1);
    assertEquals(list.binarySearchLastLessEquals(3), 4);

    list = SortedArrayList.fromArray(new Integer[]{1, 1, 2, 2, 2, 2});
    assertEquals(list.binarySearchLastLessEquals(1), 1);
    assertEquals(list.binarySearchLastLessEquals(2), 5);
    assertEquals(list.binarySearchLastLessEquals(0), -1);
    assertEquals(list.binarySearchLastLessEquals(3), 5);

    list = SortedArrayList.fromArray(new Integer[]{1, 1, 2, 2, 2, 2, 2});
    assertEquals(list.binarySearchLastLessEquals(1), 1);
    assertEquals(list.binarySearchLastLessEquals(2), 6);
    assertEquals(list.binarySearchLastLessEquals(0), -1);
    assertEquals(list.binarySearchLastLessEquals(3), 6);

    list = SortedArrayList.fromArray(new Integer[]{1, 1, 1, 2, 2, 2});
    assertEquals(list.binarySearchLastLessEquals(1), 2);
    assertEquals(list.binarySearchLastLessEquals(2), 5);
    assertEquals(list.binarySearchLastLessEquals(0), -1);
    assertEquals(list.binarySearchLastLessEquals(3), 5);

    list = SortedArrayList.fromArray(new Integer[]{1, 1, 1, 2, 2, 2, 2});
    assertEquals(list.binarySearchLastLessEquals(1), 2);
    assertEquals(list.binarySearchLastLessEquals(2), 6);
    assertEquals(list.binarySearchLastLessEquals(0), -1);
    assertEquals(list.binarySearchLastLessEquals(3), 6);

    list = SortedArrayList.fromArray(new Integer[]{1, 1, 1, 2, 2, 2, 2, 2});
    assertEquals(list.binarySearchLastLessEquals(1), 2);
    assertEquals(list.binarySearchLastLessEquals(2), 7);
    assertEquals(list.binarySearchLastLessEquals(0), -1);
    assertEquals(list.binarySearchLastLessEquals(3), 7);

    list = SortedArrayList.fromArray(new Integer[]{1, 1, 1, 2, 2, 2, 2, 2, 2});
    assertEquals(list.binarySearchLastLessEquals(1), 2);
    assertEquals(list.binarySearchLastLessEquals(2), 8);
    assertEquals(list.binarySearchLastLessEquals(0), -1);
    assertEquals(list.binarySearchLastLessEquals(3), 8);
  }

  @Test
  void bsearchLoop() {
    SortedArrayList<Integer> list = new SortedArrayList<>();
    assertEquals(list.binarySearchLoop(0), -1);

    list = SortedArrayList.fromArray(new Integer[]{1, 2, 3});
    assertEquals(list.binarySearchLoop(1), 0);
    assertEquals(list.binarySearchLoop(2), 1);
    assertEquals(list.binarySearchLoop(3), 2);
    assertEquals(list.binarySearchLoop(0), -1);
    assertEquals(list.binarySearchLoop(4), -1);

    list = SortedArrayList.fromArray(new Integer[]{1, 2, 3, 4});
    assertEquals(list.binarySearchLoop(1), 0);
    assertEquals(list.binarySearchLoop(2), 1);
    assertEquals(list.binarySearchLoop(3), 2);
    assertEquals(list.binarySearchLoop(4), 3);
    assertEquals(list.binarySearchLoop(0), -1);
    assertEquals(list.binarySearchLoop(5), -1);

    list = SortedArrayList.fromArray(new Integer[]{1, 2, 3, 4, 5});
    assertEquals(list.binarySearchLoop(1), 0);
    assertEquals(list.binarySearchLoop(2), 1);
    assertEquals(list.binarySearchLoop(3), 2);
    assertEquals(list.binarySearchLoop(4), 3);
    assertEquals(list.binarySearchLoop(5), 4);
    assertEquals(list.binarySearchLoop(0), -1);
    assertEquals(list.binarySearchLoop(6), -1);

    list = SortedArrayList.fromArray(new Integer[]{1, 1, 1});
    assertEquals(list.binarySearchLoop(1), 0);
    assertEquals(list.binarySearchLoop(0), -1);
    assertEquals(list.binarySearchLoop(2), -1);

    list = SortedArrayList.fromArray(new Integer[]{1, 2, 2});
    assertEquals(list.binarySearchLoop(1), 0);
    assertEquals(list.binarySearchLoop(2), 1);
    assertEquals(list.binarySearchLoop(0), -1);
    assertEquals(list.binarySearchLoop(3), -1);

    list = SortedArrayList.fromArray(new Integer[]{1, 2, 2, 2});
    assertEquals(list.binarySearchLoop(1), 0);
    assertEquals(list.binarySearchLoop(2), 1);
    assertEquals(list.binarySearchLoop(0), -1);
    assertEquals(list.binarySearchLoop(3), -1);

    list = SortedArrayList.fromArray(new Integer[]{1, 2, 2, 2, 2});
    assertEquals(list.binarySearchLoop(1), 0);
    assertEquals(list.binarySearchLoop(2), 1);
    assertEquals(list.binarySearchLoop(0), -1);
    assertEquals(list.binarySearchLoop(3), -1);

    list = SortedArrayList.fromArray(new Integer[]{1, 1, 2, 2, 2});
    assertEquals(list.binarySearchLoop(1), 0);
    assertEquals(list.binarySearchLoop(2), 2);
    assertEquals(list.binarySearchLoop(0), -1);
    assertEquals(list.binarySearchLoop(3), -1);

    list = SortedArrayList.fromArray(new Integer[]{1, 1, 2, 2, 2, 2});
    assertEquals(list.binarySearchLoop(1), 0);
    assertEquals(list.binarySearchLoop(2), 2);
    assertEquals(list.binarySearchLoop(0), -1);
    assertEquals(list.binarySearchLoop(3), -1);

    list = SortedArrayList.fromArray(new Integer[]{1, 1, 2, 2, 2, 2, 2});
    assertEquals(list.binarySearchLoop(1), 0);
    assertEquals(list.binarySearchLoop(2), 2);
    assertEquals(list.binarySearchLoop(0), -1);
    assertEquals(list.binarySearchLoop(3), -1);

    list = SortedArrayList.fromArray(new Integer[]{1, 1, 1, 2, 2, 2});
    assertEquals(list.binarySearchLoop(1), 0);
    assertEquals(list.binarySearchLoop(2), 3);
    assertEquals(list.binarySearchLoop(0), -1);
    assertEquals(list.binarySearchLoop(3), -1);

    list = SortedArrayList.fromArray(new Integer[]{1, 1, 1, 2, 2, 2, 2});
    assertEquals(list.binarySearchLoop(1), 0);
    assertEquals(list.binarySearchLoop(2), 3);
    assertEquals(list.binarySearchLoop(0), -1);
    assertEquals(list.binarySearchLoop(3), -1);

    list = SortedArrayList.fromArray(new Integer[]{1, 1, 1, 2, 2, 2, 2, 2});
    assertEquals(list.binarySearchLoop(1), 0);
    assertEquals(list.binarySearchLoop(2), 3);
    assertEquals(list.binarySearchLoop(0), -1);
    assertEquals(list.binarySearchLoop(3), -1);

    list = SortedArrayList.fromArray(new Integer[]{1, 1, 1, 2, 2, 2, 2, 2, 2});
    assertEquals(list.binarySearchLoop(1), 0);
    assertEquals(list.binarySearchLoop(2), 3);
    assertEquals(list.binarySearchLoop(0), -1);
    assertEquals(list.binarySearchLoop(3), -1);
  }

  @Test
  void binarySearchLastLessEqualsLoop() {
    SortedArrayList<Integer> list = new SortedArrayList<>();
    assertEquals(list.binarySearchLastLessEqualsLoop(0), -1);

    list = SortedArrayList.fromArray(new Integer[]{1, 2, 3});
    assertEquals(list.binarySearchLastLessEqualsLoop(1), 0);
    assertEquals(list.binarySearchLastLessEqualsLoop(2), 1);
    assertEquals(list.binarySearchLastLessEqualsLoop(3), 2);
    assertEquals(list.binarySearchLastLessEqualsLoop(0), -1);
    assertEquals(list.binarySearchLastLessEqualsLoop(4), 2);

    list = SortedArrayList.fromArray(new Integer[]{1, 2, 3, 4});
    assertEquals(list.binarySearchLastLessEqualsLoop(1), 0);
    assertEquals(list.binarySearchLastLessEqualsLoop(2), 1);
    assertEquals(list.binarySearchLastLessEqualsLoop(3), 2);
    assertEquals(list.binarySearchLastLessEqualsLoop(4), 3);
    assertEquals(list.binarySearchLastLessEqualsLoop(0), -1);
    assertEquals(list.binarySearchLastLessEqualsLoop(5), 3);

    list = SortedArrayList.fromArray(new Integer[]{1, 2, 3, 4, 5});
    assertEquals(list.binarySearchLastLessEqualsLoop(1), 0);
    assertEquals(list.binarySearchLastLessEqualsLoop(2), 1);
    assertEquals(list.binarySearchLastLessEqualsLoop(3), 2);
    assertEquals(list.binarySearchLastLessEqualsLoop(4), 3);
    assertEquals(list.binarySearchLastLessEqualsLoop(5), 4);
    assertEquals(list.binarySearchLastLessEqualsLoop(0), -1);
    assertEquals(list.binarySearchLastLessEqualsLoop(6), 4);

    list = SortedArrayList.fromArray(new Integer[]{1, 1, 1});
    assertEquals(list.binarySearchLastLessEqualsLoop(1), 2);
    assertEquals(list.binarySearchLastLessEqualsLoop(0), -1);
    assertEquals(list.binarySearchLastLessEqualsLoop(2), 2);

    list = SortedArrayList.fromArray(new Integer[]{1, 2, 2});
    assertEquals(list.binarySearchLastLessEqualsLoop(1), 0);
    assertEquals(list.binarySearchLastLessEqualsLoop(2), 2);
    assertEquals(list.binarySearchLastLessEqualsLoop(0), -1);
    assertEquals(list.binarySearchLastLessEqualsLoop(3), 2);

    list = SortedArrayList.fromArray(new Integer[]{1, 2, 2, 2});
    assertEquals(list.binarySearchLastLessEqualsLoop(1), 0);
    assertEquals(list.binarySearchLastLessEqualsLoop(2), 3);
    assertEquals(list.binarySearchLastLessEqualsLoop(0), -1);
    assertEquals(list.binarySearchLastLessEqualsLoop(3), 3);

    list = SortedArrayList.fromArray(new Integer[]{1, 2, 2, 2, 2});
    assertEquals(list.binarySearchLastLessEqualsLoop(1), 0);
    assertEquals(list.binarySearchLastLessEqualsLoop(2), 4);
    assertEquals(list.binarySearchLastLessEqualsLoop(0), -1);
    assertEquals(list.binarySearchLastLessEqualsLoop(3), 4);

    list = SortedArrayList.fromArray(new Integer[]{1, 1, 2, 2, 2});
    assertEquals(list.binarySearchLastLessEqualsLoop(1), 1);
    assertEquals(list.binarySearchLastLessEqualsLoop(2), 4);
    assertEquals(list.binarySearchLastLessEqualsLoop(0), -1);
    assertEquals(list.binarySearchLastLessEqualsLoop(3), 4);

    list = SortedArrayList.fromArray(new Integer[]{1, 1, 2, 2, 2, 2});
    assertEquals(list.binarySearchLastLessEqualsLoop(1), 1);
    assertEquals(list.binarySearchLastLessEqualsLoop(2), 5);
    assertEquals(list.binarySearchLastLessEqualsLoop(0), -1);
    assertEquals(list.binarySearchLastLessEqualsLoop(3), 5);

    list = SortedArrayList.fromArray(new Integer[]{1, 1, 2, 2, 2, 2, 2});
    assertEquals(list.binarySearchLastLessEqualsLoop(1), 1);
    assertEquals(list.binarySearchLastLessEqualsLoop(2), 6);
    assertEquals(list.binarySearchLastLessEqualsLoop(0), -1);
    assertEquals(list.binarySearchLastLessEqualsLoop(3), 6);

    list = SortedArrayList.fromArray(new Integer[]{1, 1, 1, 2, 2, 2});
    assertEquals(list.binarySearchLastLessEqualsLoop(1), 2);
    assertEquals(list.binarySearchLastLessEqualsLoop(2), 5);
    assertEquals(list.binarySearchLastLessEqualsLoop(0), -1);
    assertEquals(list.binarySearchLastLessEqualsLoop(3), 5);

    list = SortedArrayList.fromArray(new Integer[]{1, 1, 1, 2, 2, 2, 2});
    assertEquals(list.binarySearchLastLessEqualsLoop(1), 2);
    assertEquals(list.binarySearchLastLessEqualsLoop(2), 6);
    assertEquals(list.binarySearchLastLessEqualsLoop(0), -1);
    assertEquals(list.binarySearchLastLessEqualsLoop(3), 6);

    list = SortedArrayList.fromArray(new Integer[]{1, 1, 1, 2, 2, 2, 2, 2});
    assertEquals(list.binarySearchLastLessEqualsLoop(1), 2);
    assertEquals(list.binarySearchLastLessEqualsLoop(2), 7);
    assertEquals(list.binarySearchLastLessEqualsLoop(0), -1);
    assertEquals(list.binarySearchLastLessEqualsLoop(3), 7);

    list = SortedArrayList.fromArray(new Integer[]{1, 1, 1, 2, 2, 2, 2, 2, 2});
    assertEquals(list.binarySearchLastLessEqualsLoop(1), 2);
    assertEquals(list.binarySearchLastLessEqualsLoop(2), 8);
    assertEquals(list.binarySearchLastLessEqualsLoop(0), -1);
    assertEquals(list.binarySearchLastLessEqualsLoop(3), 8);
  }
}