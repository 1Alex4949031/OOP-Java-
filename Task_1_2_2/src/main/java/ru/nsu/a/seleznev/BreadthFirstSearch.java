package ru.nsu.a.seleznev;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Deque;

/**
 * Breadth-First-Search iterator.
 */
public class BreadthFirstSearch<T> implements Iterator<T> {
  private final Deque<Node<T>> queue = new ArrayDeque<>();

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
