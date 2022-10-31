package a.seleznev.nsu;

import java.util.Objects;

/**
 * Edge class implementation.
 */
public class Edge<T extends Comparable<T>> {
  private final Vertex<T> start, end;
  private final int weight;

  /**
   * Edge constructor. Edge: Start -> End.
   *
   * @param start  the start of the edge
   * @param end    the end of the edge
   * @param weight the weight of the edge
   */
  public Edge(Vertex<T> start, Vertex<T> end, int weight) {
    this.start = start;
    this.end = end;
    this.weight = weight;
  }

  /**
   * Function that returns the start of the edge.
   *
   * @return the vertex where the edge starts
   */
  public Vertex<T> getStart() {
    return start;
  }

  /**
   * Function that returns the end of the edge.
   *
   * @return the vertex where the edge ends
   */
  public Vertex<T> getEnd() {
    return end;
  }

  /**
   * Function that returns the weight of the current edge.
   *
   * @return the weight of the edge
   */
  public int getWeight() {
    return weight;
  }

  /**
   * Overriding the equals of edges for correct comparison.
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
    Edge<?> obj = (Edge<?>) o;
    return Objects.equals(start, obj.start)
        && Objects.equals(end, obj.end)
        && Objects.equals(weight, obj.weight);
  }

  /**
   * Overriding the hashCode for correct comparison.
   *
   * @return hash of graph
   */
  @Override
  public int hashCode() {
    return Objects.hash(start, end, weight);
  }
}