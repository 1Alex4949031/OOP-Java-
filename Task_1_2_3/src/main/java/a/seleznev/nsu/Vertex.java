package a.seleznev.nsu;

public class Vertex<T> {
  private final T name;

  public Vertex(T name) {
    this.name = name;
  }

  public T getName() {
    return name;
  }
}
