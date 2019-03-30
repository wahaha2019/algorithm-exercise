package com.github.wahaha2019.exercise;

import org.jetbrains.annotations.NotNull;

public class LinkedDequeue<E> {
  protected int capacity;
  protected int size;
  protected Node head;
  protected Node tail;

  protected static class Node<E> {
    protected E data;
    protected Node<E> pre;
    protected Node<E> next;

    public Node(E ele) {
      data = ele;
    }
  }

  public LinkedDequeue(int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException("Stack capacity must greater than 0");
    }
    this.capacity = capacity;
  }

  public int getCapacity() {
    return capacity;
  }

  public int getSize() {
    return size;
  }

  public boolean in_head(@NotNull E ele) {
    if (size == capacity) {
      return false;
    }
    Node<E> newHead = new Node(ele);
    if (size == 0) {
      tail = newHead;
    } else {
      newHead.next = head;
      head.pre = newHead;
    }
    head = newHead;
    size++;
    return true;
  }

  public E out_head() {
    if (size == 0) {
      return null;
    }
    E headEle = (E) head.data;
    Node<E> newHead = null;
    if (size == 1) {
      tail = null;
    } else {
      newHead = head.next;
      newHead.pre = null;
    }
    head = newHead;
    size--;
    return headEle;
  }

  public boolean in_tail(@NotNull E ele) {
    if (size == capacity) {
      return false;
    }
    Node<E> newTail = new Node(ele);
    if (size == 0) {
      head = newTail;
      tail = newTail;
      size++;
      return true;
    }
    if (size == 1) {
      tail = newTail;
      head.next = tail;
      tail.pre = head;
      size++;
      return true;
    }
    tail.next = newTail;
    newTail.pre = tail;
    tail = newTail;
    size++;
    return true;
  }

  public E out_tail() {
    if (size == 0) {
      return null;
    }
    E tailEle = (E) tail.data;
    if (size == 1) {
      head = null;
      tail = null;
      size--;
      return tailEle;
    }
    if (size == 2) {
      head.next = null;
      tail = head;
      size--;
      return tailEle;
    }
    tail.pre.next = null;
    tail = tail.pre;
    size--;
    return tailEle;
  }
}
