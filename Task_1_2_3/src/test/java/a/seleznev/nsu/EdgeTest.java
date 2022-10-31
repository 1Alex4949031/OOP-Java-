package a.seleznev.nsu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for Edge class.
 */
public class EdgeTest {
  @Test
  public void getWeightTest() {
    Vertex<String> v1 = new Vertex<>("A");
    Vertex<String> v2 = new Vertex<>("B");
    int weight = 10;
    Edge<String> edge = new Edge<>(v1, v2, weight);

    int act = edge.getWeight();
    int exp = 10;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void getStartTest() {
    Vertex<String> v1 = new Vertex<>("A");
    Vertex<String> v2 = new Vertex<>("B");
    int weight = 10;
    Edge<String> edge = new Edge<>(v1, v2, weight);

    Vertex act = edge.getStart();
    Vertex<String> exp = new Vertex<>("A");

    Assertions.assertEquals(exp, act);
  }

  @Test
  public void getEndTest() {
    Vertex<String> v1 = new Vertex<>("A");
    Vertex<String> v2 = new Vertex<>("B");
    int weight = 10;
    Edge<String> edge = new Edge<>(v1, v2, weight);

    Vertex act = edge.getEnd();
    Vertex<String> exp = new Vertex<>("B");

    Assertions.assertEquals(exp, act);
  }
}
