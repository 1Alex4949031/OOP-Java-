package ru.nsu.seleznev.a;

import java.util.Objects;

/**
 * Vertex class implementation.
 */
public class Vertex<T extends Comparable<T>> {
  private final T name;
  private Integer value;

  /**
   * Vertex constructor.
   *
   * @param name the name of current vertex
   */
  public Vertex(T name) {
    this.name = name;
    this.value = -1;
  }

  /**
   * Function that returns the name of the current vertex.
   *
   * @return the name of the current vertex
   */
  public T getName() {
    return name;
  }

  /**
   * Function that changes the value of the current vertex.
   *
   * @param value the new value of current vertex
   */
  public void setValue(Integer value) {
    this.value = value;
  }

  /**
   * Function that returns the value of the current vertex.
   *
   * @return the value of current vertex
   */
  public int getValue() {
    return value;
  }

  /**
   * Overriding the equals of vertexes for correct comparison.
   *
   * @param o object we need to compare with
   * @return true if the objects are equals, false otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Vertex<?> obj = (Vertex<?>) o;
    return Objects.equals(name, obj.name);
  }

  /**
   * Overriding the hashCode for correct comparison.
   *
   * @return hash of graph
   */
  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

}
