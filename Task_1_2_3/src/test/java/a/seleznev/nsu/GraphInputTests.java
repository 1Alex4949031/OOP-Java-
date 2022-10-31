package a.seleznev.nsu;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Tests for Graph class with input files.
 */
public class GraphInputTests {
  @Test
  public void listOfAdjacencyTest() throws IOException {
    File file = new File("src/test/resources/ListOfAdj.txt");
    Scanner scan = new Scanner(file);

    int N = scan.nextInt();
    int K = scan.nextInt();

    String[] vertexes = new String[N];
    String[] list = new String[K];
    int[] weights = new int[K];
    int[] edgesCount = new int[N];

    for (int i = 0; i < N; i++) {
      vertexes[i] = scan.next();
    }
    int pos = 0;
    for (int i = 0; i < N; i++) {
      scan.next();
      int count = scan.nextInt();
      edgesCount[i] = count;
      for (int j = 0; j < count; j++) {
        list[pos] = scan.next();
        weights[pos] = scan.nextInt();
        pos++;
      }
    }

    HashMap<String, Integer> act;
    Graph<String> graph = new Graph<>(vertexes, list, weights, edgesCount);
    act = graph.dijkstra("d", N);

    Writer wr = new FileWriter("src/test/resources/ListOfAdjOutput.txt");
    wr.write("Minimal distances:\n");
    wr.write(act.toString());
    wr.close();

    HashMap<String, Integer> exp = new HashMap<>();
    exp.put("a", 5);
    exp.put("b", 9);
    exp.put("c", 6);
    exp.put("d", 0);
    exp.put("e", 8);

    Assertions.assertEquals(exp, act);
  }

  @Test
  public void adjacencyMatrixTest() throws IOException {
    File file = new File("src/test/resources/AdjacencyMatrix.txt");
    Scanner scan = new Scanner(file);

    int N = scan.nextInt();
    String[] vertexes = new String[N];
    int[][] matrix = new int[N][N];

    for (int i = 0; i < N; i++) {
      vertexes[i] = scan.next();
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        matrix[i][j] = scan.nextInt();
      }
    }

    Graph<String> graph = new Graph<>(matrix, vertexes);
    HashMap<String, Integer> act;
    act = graph.dijkstra("a", N);

    Writer wr = new FileWriter("src/test/resources/AdjacencyMatrixOutput.txt");
    wr.write("Minimal distances:\n");
    wr.write(act.toString());
    wr.close();

    HashMap<String, Integer> exp = new HashMap<>();
    exp.put("a", 0);
    exp.put("b", 1);
    exp.put("c", 3);
    exp.put("d", 6);

    Assertions.assertEquals(exp, act);
  }

  @Test
  public void incidenceMatrixTest() throws IOException {
    File file = new File("src/test/resources/IncidenceMatrix.txt");
    Scanner scan = new Scanner(file);

    int N = scan.nextInt();
    int K = scan.nextInt();

    Integer[] vertexes = new Integer[N];
    int[][] matrix = new int[N + 1][K];
    for (int i = 0; i < N; i++) {
      vertexes[i] = scan.nextInt();
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < K; j++) {
        matrix[i][j] = scan.nextInt();
      }
    }

    for(int i = 0; i < K;i++){
      matrix[N][i] = scan.nextInt();
    }

    Graph<Integer> graph = new Graph<>(matrix, vertexes, K);
    HashMap<Integer, Integer> act;
    act = graph.dijkstra(1, N);

    Writer wr = new FileWriter("src/test/resources/IncidenceMatrixOutput.txt");
    wr.write("Minimal distances:\n");
    wr.write(act.toString());
    wr.close();

    HashMap<Integer, Integer> exp = new HashMap<>();
    exp.put(1, 0);
    exp.put(2, 7);
    exp.put(3, 2);
    exp.put(4, 1);

    Assertions.assertEquals(exp, act);
  }
}
