package ru.nsu.a.seleznev;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Implementation of node of the tree.
 */
public class Node<T> implements Iterable<T> {
  private T value;
  private Node<T> parent;
  private final List<Node<T>> children;

  /**
   * Constructor for tree node with parent link, value and array of children of this node.
   *
   * @param value the value of current node
   */
  public Node(T value) {
    this.parent = null;
    this.value = value;
    this.children = new ArrayList<>();
  }

  /**
   * Function that returns the parent of current node.
   * If function returns null, it means that you are searching the parent of root.
   *
   * @return the parent of current node.
   */
  public Node<T> getParent() {
    return parent;
  }

  /**
   * Function that changes the parent of current node.
   *
   * @param parent parent we want to put.
   */
  public void setParent(Node<T> parent) {
    this.parent = parent;
  }

  /**
   * Function that returns the value of current node.
   *
   * @return the value of this node
   */
  public T getValue() {
    return value;
  }

  /**
   * Function that returns the list of children of current node.
   *
   * @return the list of children
   */
  public List<Node<T>> getChildren() {
    return children;
  }

  /**
   * Function that changes the value of current node.
   *
   * @param val the value we want to put to the current node.
   */
  public void setValue(T val) {
    value = val;
  }

  /**
   * Function that adds the child of current node to the array of children.
   *
   * @param child child we need to add
   */
  public void setChild(Node<T> child) {
    children.add(child);
  }

  /**
   * Function that removes child from the children array of the current node.
   *
   * @param child child we need to remove
   */
  public void removeChild(Node<T> child) {
    children.remove(child);
  }

  /**
   * Function that adds the child to current node.
   *
   * @param child child we need to add
   */
  public void add(Node<T> child) {
    child.parent = this;
    children.add(child);
  }

  /**
   * Function that removes the child from current node.
   * Set all children from the removed node to the parent of this node.
   * When current node doesn't have child we need to remove,
   * the function throws the message of exception.
   *
   * @param child node we need to remove
   */
  public void remove(Node<T> child) {
    boolean c = false;
    for (Node<T> i : children) {
      if (i == child) {
        c = true;
        break;
      }
    }
    if (!c) {
      throw new UnsupportedOperationException("Failed to remove. Parent doesn't contain this child");
    }
    for (Node<T> i : child.getChildren()) {
      this.setChild(i);
      i.setParent(this);
    }
    this.removeChild(child);
  }

  /**
   * Overriding the iterator.
   *
   * @return DepthFirstSearch iterator as default
   */
  @Override
  public Iterator<T> iterator() {
    return new DepthFirstSearch<>(this);
  }

  /**
   * Overriding the equals of nodes for correct comparison.
   *
   * @param o object we need to compare with
   * @return true if the object are equals, false otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Node<?> obj = (Node<?>) o;
    return Objects.equals(value, obj.value)
        && Objects.equals(children, obj.children);
  }

  /**
   * Overriding the hashCode for correct comparison.
   *
   * @return hash of node
   */
  @Override
  public int hashCode() {
    return Objects.hash(value, children);
  }
}