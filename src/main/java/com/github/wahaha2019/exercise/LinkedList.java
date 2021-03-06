package com.github.wahaha2019.exercise;

/**
 * LinkedList is not thread safe. element can be null.
 */
public class LinkedList<E> {
  protected int size;
  protected Node head;
  protected Node tail;

  static LinkedList<Integer> newIntSerial(int size) {
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < size; i++) {
      list.append(i);
    }
    return list;
  }

  static LinkedList<Integer> newIntSerial(int begin, int step, int size) {
    if (step <= 0) {
      throw new IllegalArgumentException("step must greater than 0");
    }
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < size; i++) {
      list.append(begin + i * step);
    }
    return list;
  }

  static LinkedList<Comparable> fromArray(Comparable[] array) {
    LinkedList<Comparable> list = new LinkedList<>();
    for (int i = 0; i < array.length; i++) {
      list.append(array[i]);
    }
    return list;
  }

  public LinkedList<Comparable> mergeSort() {
    if (size == 2) {
      Node node = head;
      Node next = node.next;
      int cmp = ((Comparable) node.data).compareTo(next.data);
      if (cmp > 0) {
        reverse();
      }
      return (LinkedList<Comparable>) this;
    } else if (size >= 3) {
      ArrayList<Node> sorted = find_ascend_list();
      if (sorted.size > 1) {
        for (int i = 0; i < sorted.size - 2; i++) {
          merge(sorted.get(i), sorted.get(i + 1), false);
          sorted.set(i + 1, head);
        }
        sorted.set(sorted.size - 2, head);
        merge(sorted.get(sorted.size - 2), sorted.get(sorted.size - 1), true);
      }
    }
    return (LinkedList<Comparable>) this;
  }

  private void merge(final Node head1, final Node head2, boolean findTail) {
    Node node1 = head1;
    Node node2 = head2;
    Node node;
    Node head = null;
    Node tail = null;
    while (node1 != null && node2 != null) {
      if (((Comparable) node1.data).compareTo(node2.data) <= 0) {
        node = node1;
        node1 = node1.next;
      } else {
        node = node2;
        node2 = node2.next;
      }
      if (head == null) {
        head = node;
      } else {
        tail.next = node;
      }
      tail = node;
    }
    this.head = head;
    if (node1 != null) {
      tail.next = node1;
      if (findTail) {
        while (node1 != null) {
          if (node1.next == null) {
            this.tail = node1;
            break;
          }
          node1 = node1.next;
        }
      }
      return;
    }
    if (node2 != null) {
      tail.next = node2;
      if (findTail) {
        while (node2 != null) {
          if (node2.next == null) {
            this.tail = node2;
            break;
          }
          node2 = node2.next;
        }
      }
    }
  }

  public ArrayList<Node> find_ascend_list() {
    final ArrayList<Node> ascend_list = new ArrayList<>();
    Node ascend_head = null;
    Node pre;
    Node node = head;
    Node next = node.next;
    int cmp = ((Comparable) node.data).compareTo(next.data);
    boolean double_descend = false;
    boolean is_ascend = cmp <= 0;
    if (is_ascend) {
      ascend_head = node;
    } else {
      double_descend = true;
    }
    pre = node;
    node = next;
    for (int i = 1; i < size - 1; i++) {
      next = node.next;
      cmp = ((Comparable) node.data).compareTo(next.data);
      if (is_ascend) {
        if (double_descend) {
          double_descend = false;
        }
        if (cmp > 0) {  //ascend to descend
          is_ascend = false;
          node.next = null;
          ascend_list.append(ascend_head);
        }
      } else {
        if (cmp <= 0) { //descend to ascend
          is_ascend = true;
          pre.next = null;
          if (double_descend) {
            ascend_list.append(pre);
          }
          ascend_head = node;
          if (double_descend) {
            double_descend = false;
          }
        } else { //double descend
          pre.next = null;
          if (double_descend) {
            ascend_list.append(pre);
          }
          if (!double_descend) {
            double_descend = true;
          }
        }
      }
      pre = node;
      node = next;
    }
    if (is_ascend) {
      ascend_list.append(ascend_head);
    } else {
      if (double_descend) {
        pre.next = null;
        ascend_list.append(pre);
      }
      ascend_list.append(tail);
    }
    return ascend_list;
  }

  public void reverse() {
    if (size <= 1) {
      return;
    }
    Node<E> pre = null;
    Node<E> node = head;
    Node<E> next;
    tail = head;
    while (true) {
      next = node.next;
      node.next = pre;
      if (next == null) {
        break;
      }
      pre = node;
      node = next;
    }
    head.next = null;
    head = node;
  }

  /**
   * create an one node list with a given element.
   *
   * @param ele the element object.
   */
  public LinkedList(E ele) {
    Node node = new Node(ele);
    head = node;
    tail = node;
    size = 1;
  }

  /**
   * create an empty list.
   */
  public LinkedList() {
  }

  protected static class Node<E> {
    protected E data;
    protected Node<E> next;

    public Node(E ele) {
      data = ele;
    }
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void clear() {
    if (isEmpty()) {
      return;
    }
    Node<E> node = head;
    Node<E> _next = null;
    while (node != null) {
      node.data = null;
      _next = node.next;
      node.next = null;
      node = _next;
    }
    head = null;
    tail = null;
    size = 0;
  }

  public E get(int idx) {
    checkIndex(idx);
    Node node = head;
    for (int i = 0; i < idx; i++) {
      node = node.next;
    }
    return (E) node.data;
  }

  public void set(int idx, E ele) {
    checkIndex(idx);
    Node node = head;
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
    Node<E> newNode = new Node(ele);
    if (idx == 0) {
      newNode.next = head;
      head = newNode;
      size++;
      return;
    }
    Node<E> node = head;
    for (int i = 0; i < idx - 1; i++) {
      node = node.next;
    }
    newNode.next = node.next;
    node.next = newNode;
    size++;
  }

  public void delete(int idx) {
    checkIndex(idx);
    if (size == 1) {
      clear();
      return;
    }
    if (idx == 0) { //delete head
      head.data = null;
      Node<E> node = head.next;
      head.next = null;
      head = node;
      size--;
      return;
    }
    Node<E> node = head;
    for (int i = 0; i < idx - 1; i++) {
      node = node.next;
    }
    if (idx == size - 1) {  //delete tail
      tail.data = null;
      node.next = null;
      tail = node;
    } else {  //delete other
      Node<E> _delete = node.next;
      node.next = _delete.next;
      _delete.data = null;
      _delete.next = null;
    }
    size--;
  }

  public void append(E ele) {
    if (size == Integer.MAX_VALUE) {
      throw new IllegalArgumentException("List size is max, can not append any more.");
    }
    Node<E> newNode = new Node(ele);
    if (size == 0) {
      head = newNode;
      tail = newNode;
      size++;
      return;
    }
    tail.next = newNode;
    tail = newNode;
    size++;
  }

  private void checkIndex(int i) {
    if (i >= size || i < 0) {
      throw new ArrayIndexOutOfBoundsException("size is " + size + "; index is " + i);
    }
  }

  public int getSize() {
    return size;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof LinkedList)) {
      return false;
    }
    LinkedList other = (LinkedList) obj;
    if (size != other.size) {
      return false;
    } else if (size - other.size == 0) {
      return true;
    }
    Node<E> node1 = head;
    Node<E> node2 = other.head;
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
    Node<E> node = head;
    while (node != null) {
      result = 31 * result + (node.data == null ? 0 : node.data.hashCode());
      node = node.next;
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
      Node<E> node = head;
      while (node != null) {
        sb.append(node.data);
        if (node.next != null) {
          sb.append(',');
        }
        node = node.next;
      }
    }
    sb.append("}}");
    return sb.toString();
  }
}
