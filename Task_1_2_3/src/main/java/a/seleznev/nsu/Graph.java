package a.seleznev.nsu;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Graph<T> {

  private final HashMap<T, Vertex<T>> vertexes;
  private final HashMap<T, List<Edge<T>>> edges;

  public Graph() {
    vertexes = new HashMap<>();
    edges = new HashMap<>();
  }

  public void addVertex(T name) {
    Vertex<T> n = new Vertex<>(name);
    vertexes.put(name, n);
    edges.put(n.getName(), new ArrayList<>());
  }

  public void removeVertex(T name) {
    vertexes.remove(name);
    edges.remove(name);
  }

  public void addEdge(T name1, T name2, int weight) {
    // проверки на наличие name1, name2
    Vertex<T> v1 = vertexes.get(name1);
    Vertex<T> v2 = vertexes.get(name2);

    Edge<T> ne = new Edge<>(v1, v2, weight);
    edges.get(v1.getName()).add(ne);
  }

  public void removeEdge(T name1, T name2) {
    List<Edge<T>> ne = edges.get(name1);
    ne.removeIf(i -> i.getEnd().getName() == name2);
  }

  //Adj Matrix
  public Graph(int[][] matrix, T[] vertexArr) {
    vertexes = new HashMap<>();
    edges = new HashMap<>();

    Arrays.stream(vertexArr).forEach(this::addVertex);
    //for(T i : vertexArr){
    //  addVertex(i);
    //}
    for (int i = 0; i < vertexArr.length; i++) {
      for (int j = 0; j < vertexArr.length; j++) {
        addEdge(vertexArr[i], vertexArr[j], matrix[i][j]);
      }
    }
  }

  public Graph(int[][] matrix, T[] vertexArr, int edgesCount) {
    vertexes = new HashMap<>();
    edges = new HashMap<>();

    Arrays.stream(vertexArr).forEach(this::addVertex);
    for (int i = 0; i < edgesCount; i++) {
      T start = null;
      T end = null;
      int weight = -1;
      for (int j = 0; j < vertexArr.length + 1; j++) {
        if (matrix[j][i] == 1) {
          start = vertexArr[j];
        }
        if (matrix[j][i] == -1) {
          end = vertexArr[j];
        }
        if (j == vertexArr.length) {
          weight = matrix[j][i];
          if(start == null || end == null || weight < 0){
            throw new Error("Wrong matrix initialization!");
          }
          addEdge(start, end, weight);
        }
      }
    }
  }

  public static void main(String[] args) {
    //Graph<String> graph = new Graph<>();
    //Vertex<String> a = new Vertex<>("A");
    //Vertex<String> b = new Vertex<>("B");
    //Vertex<String> c = new Vertex<>("C");
    //Vertex<String> d = new Vertex<>("D");
    //graph.addVertex("A");
    //graph.removeVertex("A");
    //graph.addVertex("B");
    //graph.addVertex("C");
    //graph.addVertex("D");
    //graph.addEdge("A", "B", 10);
    //graph.addEdge("B", "C", 10);
    //graph.addEdge("B", "A", 10);
    //graph.addEdge("B", "D", 10);
    //graph.removeEdge("A", "B");
    //graph.removeEdge("B", "C");

    //Adj matrix
    //int[][] mat = {{0, 1, 10, 0}, {1, 0, 2, 10}, {10, 2, 0, 3}, {0, 10, 3, 0}};
    //String[] mas = {"a", "b", "c", "d"};
    //Graph<String> graph1 = new Graph<>(mat, mas);

    //Inc matrix
    int[][] mat2 = {{1, 1, 0, 0, 0},
        {-1, 0, -1, 1, 0},
        {0, 0, 0, -1, -1},
        {0, -1, 1, 0, 1},
        {10, 20, 30, 40, 50}};
    Integer[] mas2 = {1,2,3,4};
    Graph<Integer> graph2 = new Graph<>(mat2,mas2, 5);
  }
}