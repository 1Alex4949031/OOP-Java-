package ru.nsu.seleznev.a;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for Graph class with input files.
 */
public class GraphInputTests {
  @Test
  public void listOfAdjacencyTest() throws IOException {
    try (InputStream file =
             getClass().getClassLoader().getResourceAsStream("ListOfAdj.txt")) {
      assert file != null;
      Scanner scan = new Scanner(file);

      int verCount = scan.nextInt();
      int edgesCount = scan.nextInt();

      String[] vertexes = new String[verCount];
      String[] list = new String[edgesCount];
      int[] weights = new int[edgesCount];
      int[] edgesArr = new int[verCount];

      for (int i = 0; i < verCount; i++) {
        vertexes[i] = scan.next();
      }
      int pos = 0;
      for (int i = 0; i < verCount; i++) {
        scan.next();
        int count = scan.nextInt();
        edgesArr[i] = count;
        for (int j = 0; j < count; j++) {
          list[pos] = scan.next();
          weights[pos] = scan.nextInt();
          pos++;
        }
      }

      Map<String, Integer> act;
      Graph<String> graph = new Graph<>(vertexes, list, weights, edgesArr);
      act = graph.dijkstra("d", verCount);

      try (Writer wr = new FileWriter("src/test/resources/ListOfAdjOutput.txt")) {
        wr.write("Minimal distances:\n");
        wr.write(act.toString());
      }

      HashMap<String, Integer> exp = new HashMap<>();
      exp.put("a", 5);
      exp.put("b", 9);
      exp.put("c", 6);
      exp.put("d", 0);
      exp.put("e", 8);

      Assertions.assertEquals(exp, act);
    }
  }


  @Test
  public void adjacencyMatrixTest() throws IOException {
    try (InputStream file =
             getClass().getClassLoader().getResourceAsStream("AdjacencyMatrix.txt")) {
      assert file != null;
      Scanner scan = new Scanner(file);

      int verCount = scan.nextInt();
      String[] vertexes = new String[verCount];
      int[][] matrix = new int[verCount][verCount];

      for (int i = 0; i < verCount; i++) {
        vertexes[i] = scan.next();
      }

      for (int i = 0; i < verCount; i++) {
        for (int j = 0; j < verCount; j++) {
          matrix[i][j] = scan.nextInt();
        }
      }

      Graph<String> graph = new Graph<>(matrix, vertexes);
      Map<String, Integer> act;
      act = graph.dijkstra("a", verCount);

      try (Writer wr = new FileWriter("src/test/resources/AdjacencyMatrixOutput.txt")) {
        wr.write("Minimal distances:\n");
        wr.write(act.toString());
      }

      HashMap<String, Integer> exp = new HashMap<>();
      exp.put("a", 0);
      exp.put("b", 1);
      exp.put("c", 3);
      exp.put("d", 6);

      Assertions.assertEquals(exp, act);
    }
  }

  @Test
  public void incidenceMatrixTest() throws IOException {
    try (InputStream file =
             getClass().getClassLoader().getResourceAsStream("IncidenceMatrix.txt")) {

      assert file != null;
      Scanner scan = new Scanner(file);

      int verCount = scan.nextInt();
      int edgesCount = scan.nextInt();

      Integer[] vertexes = new Integer[verCount];
      int[][] matrix = new int[verCount + 1][edgesCount];
      for (int i = 0; i < verCount; i++) {
        vertexes[i] = scan.nextInt();
      }

      for (int i = 0; i < verCount; i++) {
        for (int j = 0; j < edgesCount; j++) {
          matrix[i][j] = scan.nextInt();
        }
      }

      for (int i = 0; i < edgesCount; i++) {
        matrix[verCount][i] = scan.nextInt();
      }

      Graph<Integer> graph = new Graph<>(matrix, vertexes, edgesCount);
      Map<Integer, Integer> act;
      act = graph.dijkstra(1, verCount);

      try (Writer wr = new FileWriter("src/test/resources/IncidenceMatrixOutput.txt")) {
        wr.write("Minimal distances:\n");
        wr.write(act.toString());
      }

      HashMap<Integer, Integer> exp = new HashMap<>();
      exp.put(1, 0);
      exp.put(2, 7);
      exp.put(3, 2);
      exp.put(4, 1);

      Assertions.assertEquals(exp, act);
    }
  }
}
