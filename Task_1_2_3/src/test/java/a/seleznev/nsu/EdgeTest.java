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

  @Test
  public void edgeEqualsTest() {
    Vertex<String> v1 = new Vertex<>("Hello!");
    Vertex<String> v2 = new Vertex<>("World!");
    int weight1 = 101;
    Edge<String> act1 = new Edge<>(v1, v2, weight1);

    Vertex<String> v3 = new Vertex<>("Hello!");
    Vertex<String> v4 = new Vertex<>("Friend!");
    int weight2 = 121;
    Edge<String> act2 = new Edge<>(v3, v4, weight2);

    Vertex<String> a = new Vertex<>("Hello!");
    Vertex<String> b = new Vertex<>("World!");
    int weight = 101;
    Edge<String> exp = new Edge<>(a, b, weight);

    Assertions.assertNotEquals(exp, act2);
    Assertions.assertEquals(exp, act1);
  }

  @Test
  public void complexTest() {
    Vertex<Integer> a = new Vertex<>(1100);
    Vertex<Integer> b = new Vertex<>(1001);
    int weight = 11001001;
    Edge<Integer> edge = new Edge<>(a, b, weight);

    int act1 = edge.getWeight();
    int exp1 = 11001001;
    Assertions.assertEquals(exp1, act1);

    Vertex<Integer> act2 = edge.getStart();
    Vertex<Integer> exp2 = new Vertex<>(1100);
    Assertions.assertEquals(exp2, act2);

    Vertex<Integer> act3 = edge.getEnd();
    Vertex<Integer> exp3 = new Vertex<>(1001);
    Assertions.assertEquals(exp3, act3);
  }

  @Test
  public void hashCodeTest() {
    Vertex<String> a = new Vertex<>("Hello");
    Vertex<String> b = new Vertex<>("World!");
    int weight1 = 11001001;
    Edge<String> edge1 = new Edge<>(a, b, weight1);

    Vertex<String> c = new Vertex<>("Hello");
    Vertex<String> d = new Vertex<>("World!");
    int weight2 = 11001001;
    Edge<String> edge2 = new Edge<>(a, b, weight2);

    int act = edge1.hashCode();
    int exp = edge2.hashCode();
    Assertions.assertEquals(exp, act);
  }
}
