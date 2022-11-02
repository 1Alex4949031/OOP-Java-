package ru.nsu.seleznev.a;

import java.util.HashMap;
import java.util.Map;
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

  @Test
  public void dijkstraAdjacencyMatrixTest() {
    int[][] matrix = {
        {0, 10, 10, 2},
        {-1, 0, -1, -1},
        {-1, -1, 0, -1},
        {-1, 3, 12, 0}};
    Integer[] vertexArr = {1, 2, 3, 4};
    Graph<Integer> graph = new Graph<>(matrix, vertexArr);

    HashMap<Integer, Integer> exp = new HashMap<>();
    exp.put(1, 0);
    exp.put(2, 5);
    exp.put(3, 10);
    exp.put(4, 2);

    Map<Integer, Integer> act = graph.dijkstra(1, vertexArr.length);
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void dijkstraListOfAdjacencyTest() {
    Integer[] ver = {1, 2, 3, 4};
    Integer[] list = {2, 4, 3, 4, 2, 1, 3};
    int[] weights = {2, 4, 6, 1, 7, 1, 2};
    int[] edgesCount = {2, 2, 1, 2};
    Graph<Integer> graph = new Graph<>(ver, list, weights, edgesCount);

    HashMap<Integer, Integer> exp = new HashMap<>();
    exp.put(1, 0);
    exp.put(2, 2);
    exp.put(3, 5);
    exp.put(4, 3);

    Map<Integer, Integer> act = graph.dijkstra(1, ver.length);
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void dijkstraIncidenceMatrixTest() {
    int edgesCount = 4;
    int[][] matrix = {
        {1, 1, 0, 0},
        {-1, 0, 0, 1},
        {0, -1, 1, 0},
        {0, 0, -1, -1},
        {10, 1, 5, 6}};
    Integer[] vertexArr = {1, 2, 3, 4};
    Graph<Integer> graph = new Graph<>(matrix, vertexArr, edgesCount);

    HashMap<Integer, Integer> exp = new HashMap<>();
    exp.put(1, 0);
    exp.put(2, 10);
    exp.put(3, 1);
    exp.put(4, 6);

    Map<Integer, Integer> act = graph.dijkstra(1, vertexArr.length);
    Assertions.assertEquals(exp, act);
  }
}
