package com.github.wahaha2019.exercise;

public class Browser<String> {
  LinkedStack<String> back = new LinkedStack<>(99);
  LinkedStack<String> forward = new LinkedStack<>(99);

  public Browser() {
  }

  public void click(String url) {
    back.push(url);
    browse(url);
  }

  public void back() {
    String url = (String) back.pop();
    if (url != null) {
      forward.push(url);
      browse(url);
    }
  }

  public void forward() {
    String url = (String) forward.pop();
    if (url != null) {
      back.push(url);
      browse(url);
    }
  }

  public void browse(String url) {
    System.out.println("browsing:" + url);
  }
}
