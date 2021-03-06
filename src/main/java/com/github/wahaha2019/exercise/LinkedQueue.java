package com.github.wahaha2019.exercise;

import org.jetbrains.annotations.NotNull;

public class LinkedQueue<E> {
  protected int capacity;
  protected int size;
  protected Node head;
  protected Node tail;

  protected static class Node<E> {
    protected E data;
    protected Node<E> next;

    public Node(E ele) {
      data = ele;
    }
  }

  public LinkedQueue(int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException("Queue capacity must greater than 0");
    }
    this.capacity = capacity;
  }

  public int getCapacity() {
    return capacity;
  }

  public int getSize() {
    return size;
  }

  public boolean in(@NotNull E ele) {
    if (size == capacity) {
      return false;
    }
    Node<E> newTail = new Node(ele);
    if (size == 0) {
      head = newTail;
    } else {
      tail.next = newTail;
    }
    tail = newTail;
    size++;
    return true;
  }

  public E out() {
    if (size == 0) {
      return null;
    }
    E headEle = (E) head.data;
    Node<E> newHead = head.next;
    if (size == 1) {
      tail = null;
    }
    head = newHead;
    size--;
    return headEle;
  }

}
