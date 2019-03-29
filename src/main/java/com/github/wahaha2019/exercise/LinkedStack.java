package com.github.wahaha2019.exercise;

import org.jetbrains.annotations.NotNull;

public class LinkedStack<E> {
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
    Node<E> newNode = new Node(ele);
    if (size == 0) {
      head = newNode;
      tail = newNode;
      size++;
      return true;
    }
    if (size == 1) {
      tail = newNode;
      head.next = tail;
      tail.pre = head;
      size++;
      return true;
    }
    tail.next = newNode;
    newNode.pre = tail;
    tail = newNode;
    size++;
    return true;
  }

  public E pop() {
    if (size == 0) {
      return null;
    }
    E ele = (E) tail.data;
    if (size == 1) {
      head = null;
      tail = null;
      size--;
      return ele;
    }
    if (size == 2) {
      head.next = null;
      tail = head;
      size--;
      return ele;
    }
    tail.pre.next = null;
    tail = tail.pre;
    size--;
    return ele;
  }
}
