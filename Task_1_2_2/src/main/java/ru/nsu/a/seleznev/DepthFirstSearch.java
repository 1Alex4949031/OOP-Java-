package ru.nsu.a.seleznev;

import java.util.ArrayDeque;
import java.util.ConcurrentModificationException;
import java.util.Deque;
import java.util.Iterator;

/**
 * Depth-First-Search iterator for current node.
 * That node is the root of under-tree we want to iterate.
 */
public class DepthFirstSearch<T> implements Iterator<T> {


  private final Deque<Node<T>> stack = new ArrayDeque<>();

  private final Node<T> root;
  private final int countMod;

  /**
   * Depth-First-Search implemented with stack.
   */
  public DepthFirstSearch(Node<T> node) {
    root = node;
    countMod = node.getCountMod();
    stack.push(root);
  }

  @Override
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  @Override
  public T next() {
    Node<T> next = stack.pop();
    if (countMod != next.getCountMod(root)) {
      throw new ConcurrentModificationException();
    }
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
