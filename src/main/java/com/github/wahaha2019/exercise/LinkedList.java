package com.github.wahaha2019.exercise;

/**
 * LinkedList is not thread safe. element can be null.
 */
public class LinkedList<E> {
  protected int size;
  protected E data;
  protected LinkedList next;

  static LinkedList<Integer> newIntSerial(int size) {
    LinkedList<Integer> head = new LinkedList<>();
    for (int i = 0; i < size; i++) {
      head.append(i);
    }
    return head;
  }

  static LinkedList<Integer> newIntSerial(int begin, int step, int size) {
    LinkedList<Integer> head = new LinkedList<>();
    for (int i = 0; i < size; i++) {
      head.append(begin + i * step);
    }
    return head;
  }

  /**
   * create an one node list with a given element.
   *
   * @param ele the element object.
   */
  public LinkedList(E ele) {
    this.data = ele;
    this.next = null;
    this.size = 1;
  }

  /**
   * create an empty list.
   */
  public LinkedList() {
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void clear() {
    if (next != null) {
      next.clear();
    }
    size = 0;
    data = null;
    next = null;
  }

  public E get(int idx) {
    checkIndex(idx);
    LinkedList node = this;
    for (int i = 0; i < idx; i++) {
      node = node.next;
    }
    return (E) node.data;
  }

  public void set(int idx, E ele) {
    checkIndex(idx);
    LinkedList node = this;
    for (int i = 0; i < idx; i++) {
      node = node.next;
    }
    node.data = ele;
  }

  public void insert(int idx, E ele) {
    if (size == 0) {
      if (idx != 0) {
        throw new IllegalArgumentException("Index must be 0 when insert to an empty list.");
      }
    } else {
      checkIndex(idx);
    }
    if (idx == Integer.MAX_VALUE || size == Integer.MAX_VALUE) {
      throw new IllegalArgumentException("List size is max, can not insert any more.");
    }
    if (size == 0) {
      append(ele);
      return;
    }
    if (idx == 0) {
      LinkedList newNode = new LinkedList(data);
      newNode.size = size;
      newNode.next = next;
      data = ele;
      size++;
      next = newNode;
      return;
    }
    if (idx == 1) {
      LinkedList newNode = new LinkedList(ele);
      newNode.size = size;
      newNode.next = next;
      size++;
      next = newNode;
      return;
    }
    LinkedList node = this;
    for (int i = 0; i < idx - 1; i++) {
      node.size++;
      node = node.next;
    }
    LinkedList newNode = new LinkedList(ele);
    newNode.size = size;
    newNode.next = node.next;
    node.next = newNode;
  }

  public void delete(int idx) {
    checkIndex(idx);
    if (size == 0) {
      return;
    }
    if (size == 1) {
      data = null;
      size = 0;
      return;
    }
    LinkedList node = this;
    if (idx <= 1) {
      node.size = node.next.size;
      if (idx == 0) {
        node.data = node.next.data;
      }
      node.next.data = null;
      node.next = node.next.next;
      return;
    }
    for (int i = 0; i < idx - 1; i++) {
      node.size--;
      node = node.next;
    }
    node.next.data = null;
    node.next = node.next.next;
  }

  public void append(E ele) {
    if (size == 0) {
      this.data = ele;
      this.size = 1;
      return;
    }
    if (size == Integer.MAX_VALUE) {
      throw new IllegalArgumentException("List size is max, can not append any more.");
    }
    LinkedList node = this;
    LinkedList last = this;
    while (node != null) {
      if (node.next == null) {
        last = node;
      }
      node.size++;
      node = node.next;
    }
    last.next = new LinkedList(ele);
  }

  private void checkIndex(int i) {
    if (i >= size || i < 0) {
      throw new ArrayIndexOutOfBoundsException("size is " + size + "; index is " + i);
    }
  }

  public int getSize() {
    return size;
  }

  public E getData() {
    return data;
  }

  public void setData(E data) {
    this.data = data;
  }

  public LinkedList getNext() {
    return next;
  }

  public void setNext(LinkedList next) {
    this.next = next;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof LinkedList)) {
      return false;
    }
    LinkedList node2 = (LinkedList) obj;
    if (this.size != node2.size) {
      return false;
    } else if (this.size == 0 && node2.size == 0) {
      return true;
    }
    LinkedList node1 = this;
    while (node1 != null) {
      if (node1.data == null) {
        if (node2.data != null) {
          return false;
        }
      } else if (!node1.data.equals(node2.data)) {
        return false;
      }
      node1 = node1.next;
      node2 = node2.next;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    LinkedList node1 = this;
    while (node1 != null) {
      result = 31 * result + (node1.data == null ? 0 : node1.data.hashCode());
      node1 = node1.next;
    }
    result = 31 * result + size;
    return result;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder(64);
    sb.append("LinkedList{size=");
    sb.append(size);
    sb.append(",");
    sb.append("data={");
    if (size > 0) {
      LinkedList node1 = this;
      while (node1 != null) {
        sb.append(node1.data);
        if (node1.next != null) {
          sb.append(',');
        }
        node1 = node1.next;
      }
    }
    sb.append("}}");
    return sb.toString();
  }
}
