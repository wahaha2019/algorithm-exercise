package com.github.wahaha2019.exercise;

import org.jetbrains.annotations.NotNull;

public class SortedLinkList<E extends Comparable> extends LinkedList<E> {

  /**
   * Generate an SortedLinkList of integer serial from 0 to (size - 1).
   *
   * @param size
   * @return SortedLinkList
   */
  static SortedLinkList<Integer> newIntSerial(int size) {
    SortedLinkList<Integer> head = new SortedLinkList<>();
    for (int i = 0; i < size; i++) {
      head._append(i);
    }
    return head;
  }

  static SortedLinkList<Integer> newIntSerial(int begin, int step, int size) {
    if (step <= 0) {
      throw new IllegalArgumentException("step must greater than 0");
    }
    SortedLinkList<Integer> head = new SortedLinkList<>();
    for (int i = 0; i < size; i++) {
      head._append(begin + i * step);
    }
    return head;
  }

  /**
   * merge two SortedLinkLists.
   *
   * @param src1 source SortedLinkList 1
   * @param src2 source SortedLinkList 2
   * @return new SortedLinkList
   */
  public static SortedLinkList merge(@NotNull final SortedLinkList src1, @NotNull final SortedLinkList src2) {
    if (src1 == null || src2 == null) {
      throw new IllegalArgumentException("Every source list must not be null.");
    }
    long newSize = src1.size + src2.size;
    if (newSize > Integer.MAX_VALUE) {
      throw new IllegalArgumentException("Summed size of source lists is too large.");
    }
    SortedLinkList result = new SortedLinkList<String>();
    if (newSize == 0) {
      return result;
    }
    Node node1 = src1.head;
    Node node2 = src2.head;
    while (node1 != null || node2 != null) {
      if (node2 == null) {
        if (node1 != null) {
          result._append((Comparable) node1.data);
          node1 = node1.next;
        }
        continue;
      }
      if (node1 == null) {
        if (node2 != null) {
          result._append((Comparable) node2.data);
          node2 = node2.next;
        }
        continue;
      }
      if (((Comparable) node1.data).compareTo(node2.data) <= 0) {
        result._append((Comparable) node1.data);
        node1 = node1.next;
      } else {
        result._append((Comparable) node2.data);
        node2 = node2.next;
      }
    }
    return result;
  }

  /**
   * create an one node list with a given element.
   *
   * @param ele the element object, must be not null.
   */
  public SortedLinkList(@NotNull E ele) {
    super(ele);
  }

  /**
   * create an empty sorted list.
   */
  public SortedLinkList() {
    super();
  }

  /**
   * insert an element to the list.
   *
   * @param ele the element object.
   */
  public void insert(@NotNull E ele) {
    if (size == 0) {
      super.append(ele);
      return;
    } else if (size == 1) {
      if (ele.compareTo(head.data) <= 0) {
        super.insert(0, ele);
      } else {
        super.append(ele);
      }
    } else {
      Node<E> node = head;
      int idx = 0;
      while (ele.compareTo(node.data) > 0 && node.next != null) {
        idx++;
        if (ele.compareTo(node.next.data) <= 0) {
          break;
        }
        node = node.next;
      }
      if (node.next != null) {
        super.insert(idx, ele);
      } else {
        super.append(ele);
      }
    }
  }

  private void _append(@NotNull E ele) {
    super.append(ele);
  }

  @Override
  @Deprecated
  public void set(int idx, E ele) {
    throw new RuntimeException("method not supported.");
  }

  @Override
  @Deprecated
  public void insert(int idx, E ele) {
    throw new RuntimeException("method not supported.");
  }

  @Override
  @Deprecated
  public void append(E ele) {
    throw new RuntimeException("method not supported.");
  }
}
