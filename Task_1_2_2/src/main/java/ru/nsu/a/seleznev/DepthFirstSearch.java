package ru.nsu.a.seleznev;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Iterator;

/**
 * Depth-First-Search iterator.
 */
public class DepthFirstSearch<T> implements Iterator<T> {

  private final Deque<Node<T>> stack = new ArrayDeque<>();

  /**
   * Depth-First-Search implemented with stack.
   */
  public DepthFirstSearch(Node<T> root) {
    stack.push(root);
  }

  @Override
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  @Override
  public T next() {
    Node<T> next = stack.pop();
    for (Node<T> i : next.getChildren()) {
      stack.push(i);
    }
    return next.getValue();
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException();
  }
}
