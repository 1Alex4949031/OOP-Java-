package ru.nsu.a.seleznev;

import java.util.ArrayDeque;
import java.util.ConcurrentModificationException;
import java.util.Deque;
import java.util.Iterator;

/**
 * Breadth-First-Search iterator for current node.
 * That node is the root of under-tree we want to iterate.
 */
public class BreadthFirstSearch<T> implements Iterator<T> {
  private final int countMod;
  private final Node<T> root;

  private final Deque<Node<T>> queue = new ArrayDeque<>();

  /**
   * Breadth-First-Search implemented with queue.
   */
  public BreadthFirstSearch(Node<T> node) {
    root = node;
    countMod = node.getCountMod();
    queue.add(root);
  }

  @Override
  public boolean hasNext() {
    return !queue.isEmpty();
  }

  @Override
  public T next() {
    Node<T> next = queue.poll();
    assert next != null;
    if (countMod != next.getCountMod(root)) {
      throw new ConcurrentModificationException();
    }
    queue.addAll(next.getChildren());
    return next.getValue();
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException();
  }
}
