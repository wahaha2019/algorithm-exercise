package com.github.wahaha2019.exercise;

import org.jetbrains.annotations.NotNull;

public class LinkedStack<E> {
  protected int capacity;
  protected int size;
  protected Node head;

  protected static class Node<E> {
    protected E data;
    protected Node<E> next;

    public Node(E ele) {
      data = ele;
    }
  }

  public LinkedStack(int capacity) {
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

  public boolean push(@NotNull E ele) {
    if (size == capacity) {
      return false;
    }
    Node<E> newHead = new Node(ele);
    if (size > 0) {
      newHead.next = head;
    }
    head = newHead;
    size++;
    return true;
  }

  public E pop() {
    if (size == 0) {
      return null;
    }
    E headEle = (E) head.data;
    Node<E> newHead = null;
    if (size > 1) {
      newHead = head.next;
    }
    head = newHead;
    size--;
    return headEle;
  }
}
