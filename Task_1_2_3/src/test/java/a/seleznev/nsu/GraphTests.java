package a.seleznev.nsu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test for Graph class without input files.
 */
public class GraphTests {

  @Test
  public void addVertexTest() {
    Graph<String> act = new Graph<>();
    act.addVertex("Hello");

    Graph<String> exp = new Graph<>();
    exp.addVertex("Hello");

    Assertions.assertEquals(exp, act);
  }

  @Test
  public void removeVertexTest() {
    Graph<String> act = new Graph<>();
    act.addVertex("Hello");
    act.addVertex("I'm fine!");
    act.removeVertex("I'm fine!");

    Graph<String> exp = new Graph<>();
    exp.addVertex("Hello");

    Assertions.assertEquals(exp, act);
  }

  @Test
  public void complexVertexTest() {
    Graph<String> act = new Graph<>();
    act.addVertex("A");
    act.addVertex("A");
    act.addVertex("B");
    act.addVertex("C");
    act.addVertex("D");
    act.removeVertex("C");
    act.removeVertex("A");
    act.removeVertex("A");

    Graph<String> exp = new Graph<>();
    exp.addVertex("D");
    exp.addVertex("B");

    Assertions.assertEquals(exp, act);
  }

  @Test
  public void addEdgeTest() {
    Graph<String> act = new Graph<>();
    act.addVertex("A");
    act.addVertex("B");
    act.addEdge("A", "B", 10);

    Graph<String> exp = new Graph<>();
    exp.addVertex("A");
    exp.addVertex("B");
    exp.addEdge("A", "B", 10);

    Assertions.assertEquals(exp, act);
  }

  @Test
  public void removeEdgeTest() {
    Graph<String> act = new Graph<>();
    act.addVertex("A");
    act.addVertex("B");
    act.addVertex("C");
    act.addEdge("A", "B", 10);
    act.addEdge("B", "C", 10);
    act.removeEdge("A", "B");
    act.removeVertex("A");

    Graph<String> exp = new Graph<>();
    exp.addVertex("B");
    exp.addVertex("C");
    exp.addEdge("B", "C", 10);

    Assertions.assertEquals(exp, act);
  }
}
