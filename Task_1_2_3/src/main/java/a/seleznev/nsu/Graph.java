package a.seleznev.nsu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * Own Graph class implementation.
 *
 * @author Алексей Селезнев
 */
public class Graph<T extends Comparable<T>> {

  private final HashMap<T, Vertex<T>> vertexes;
  private final HashMap<T, List<Edge<T>>> edges;

  /**
   * Empty graph constructor presentation.
   */
  public Graph() {
    vertexes = new HashMap<>();
    edges = new HashMap<>();
  }

  /**
   * Graph constructor for Adjacency Matrix presentation.
   *
   * @param matrix    current matrix with information
   * @param vertexArr array of vertexes
   */
  public Graph(int[][] matrix, T[] vertexArr) {
    vertexes = new HashMap<>();
    edges = new HashMap<>();

    Arrays.stream(vertexArr).forEach(this::addVertex);

    for (int i = 0; i < vertexArr.length; i++) {
      for (int j = 0; j < vertexArr.length; j++) {
        addEdge(vertexArr[i], vertexArr[j], matrix[i][j]);
      }
    }
  }

  /**
   * Graph constructor for Incidence Matrix presentation.
   *
   * @param matrix     current matrix
   * @param vertexArr  array of vertexes
   * @param edgesCount number of edges
   */
  public Graph(int[][] matrix, T[] vertexArr, int edgesCount) {
    vertexes = new HashMap<>();
    edges = new HashMap<>();

    Arrays.stream(vertexArr).forEach(this::addVertex);
    for (int i = 0; i < edgesCount; i++) {
      T start = null;
      T end = null;
      int weight;
      for (int j = 0; j < vertexArr.length + 1; j++) {
        if (matrix[j][i] == 1 && j != vertexArr.length) {
          start = vertexArr[j];
        }
        if (matrix[j][i] == -1 && j != vertexArr.length) {
          end = vertexArr[j];
        }
        if (j == vertexArr.length) {
          weight = matrix[j][i];
          if (start == null || end == null || weight < 0) {
            throw new Error("Wrong matrix initialization!");
          }
          addEdge(start, end, weight);
        }
      }
    }
  }

  /**
   * Graph constructor for List of Adjacency presentation.
   *
   * @param vertexArr  array of vertexes
   * @param adjList    list of all edges
   * @param weights    array of weights
   * @param edgesCount array of number of edges for each vertex
   */
  public Graph(T[] vertexArr, T[] adjList, int[] weights, int[] edgesCount) {
    vertexes = new HashMap<>();
    edges = new HashMap<>();

    Arrays.stream(vertexArr).forEach(this::addVertex);

    int start = 0;
    int pos;
    for (int i = 0; i < vertexArr.length; i++) {
      int count = edgesCount[i];
      pos = start;
      for (int j = start; j < count + pos; j++) {
        addEdge(vertexArr[i], adjList[j], weights[j]);
        start++;
      }
    }
  }

  /**
   * Function that adds Vertex to the graph.
   *
   * @param name name of the current vertex need to added
   */
  public void addVertex(T name) {
    if (!vertexes.containsKey(name)) {
      Vertex<T> n = new Vertex<>(name);
      vertexes.put(name, n);
      edges.put(n.getName(), new ArrayList<>());
    }
  }

  /**
   * Function that removes Vertex from the graph.
   *
   * @param name name of the current vertex need to be removed
   */
  public void removeVertex(T name) {
    if (vertexes.containsKey(name)) {
      vertexes.remove(name);
      edges.remove(name);
    }
  }

  /**
   * Function that adds Edge to the graph.
   * (S(vertex1) -(edge)- E(vertex2) with weight).
   *
   * @param name1  the start of the Edge
   * @param name2  the end of the Edge
   * @param weight the weight of the Edge
   */
  public void addEdge(T name1, T name2, int weight) {
    if (!vertexes.containsKey(name1) || !vertexes.containsKey(name2)) {
      throw new UnsupportedOperationException("Error with adding!");
    }
    Vertex<T> v1 = vertexes.get(name1);
    Vertex<T> v2 = vertexes.get(name2);

    Edge<T> ne = new Edge<>(v1, v2, weight);
    edges.get(v1.getName()).add(ne);
  }

  /**
   * Function that adds Edge to the graph.
   * (S(vertex1) -(edge)- E(vertex2) with weight).
   *
   * @param name1 the start of the Edge
   * @param name2 the end of the Edge
   */
  public void removeEdge(T name1, T name2) {
    List<Edge<T>> ne = edges.get(name1);
    ne.removeIf(i -> i.getEnd().getName() == name2);
  }

  /**
   * Dijkstra's algorithm for current graph.
   * For each vertex counts the minimal distance from start vertex.
   * The value of each vertex is the minimal distance.
   *
   * @param name        start vertex
   * @param vertexCount number of vertexes
   * @return HashMap that presents the minimal distances from fixed vertex
   */
  public HashMap<T, Integer> dijkstra(T name, int vertexCount) {
    Vertex<T> start = vertexes.get(name);

    vertexes.forEach((n, v) -> v.setValue(Integer.MAX_VALUE));

    PriorityQueue<Vertex<T>> pq = new PriorityQueue<>(Comparator.comparingInt(Vertex::getValue));
    pq.add(start);

    start.setValue(0);

    HashMap<T, Integer> dist = new HashMap<>();
    dist.put(name, 0);

    HashSet<Vertex<T>> settled = new HashSet<>();
    while ((settled.size() != vertexCount) || !pq.isEmpty()) {
      Vertex<T> u = pq.remove();
      settled.add(u);
      int newDist;
      List<Edge<T>> edgesList = edges.get(u.getName());
      for (Edge<T> i : edgesList) {
        Vertex<T> st = i.getStart();
        Vertex<T> ed = i.getEnd();
        if (!settled.contains(ed) && i.getWeight() >= 0) {
          newDist = st.getValue() + i.getWeight();
          if (newDist < ed.getValue()) {
            ed.setValue(newDist);
            dist.put(ed.getName(), newDist);
          }
          pq.add(ed);
        }
      }
    }
    return dist;
  }

  /**
   * Overriding the equals of graphs for correct comparison.
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
    Graph<?> obj = (Graph<?>) o;
    return Objects.equals(edges, obj.edges)
        && Objects.equals(vertexes, obj.vertexes);
  }

  /**
   * Overriding the hashCode for correct comparison.
   *
   * @return hash of graph
   */
  @Override
  public int hashCode() {
    return Objects.hash(edges, vertexes);
  }
}