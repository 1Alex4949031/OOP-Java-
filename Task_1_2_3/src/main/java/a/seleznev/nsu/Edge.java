package a.seleznev.nsu;

public class Edge<T> {
  private final Vertex start, end;
  private final int weight;

  public Edge(Vertex<T> start, Vertex<T> end, int weight) {
    this.start = start;
    this.end = end;
    this.weight = weight;
  }

  public Vertex getStart() {
    return start;
  }

  public Vertex getEnd() {
    return end;
  }

  public int getWeight() {
    return weight;
  }
}