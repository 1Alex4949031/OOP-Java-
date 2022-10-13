package ru.nsu.a.seleznev;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * Breadth-First-Search iterator.
 */
public class BreadthFirstSearch<T> implements Iterator<T> {

  private final Deque<Node<T>> queue = new ArrayDeque<>();

  /**
   * Breadth-First-Search implemented with queue.
   */
  public BreadthFirstSearch(Node<T> root) {
    queue.add(root);
  }

  @Override
  public boolean hasNext() {
    return !queue.isEmpty();
  }

  @Override
  public T next() {
    Node<T> next = queue.poll();
    queue.addAll(next != null ? next.getChildren() : null);
    assert next != null;
    return next.getValue();
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException();
  }
}
