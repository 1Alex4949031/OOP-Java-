package ru.nsu.a.seleznev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * The implementation of different test for correct work of Tree.
 */
public class TreeTests {

  /**
   * Add function test.
   */
  @Test
  public void addTest() {
    Node<Integer> root = new Node<>(1);
    Node<Integer> nodeA = new Node<>(2);
    root.add(nodeA);
    Integer act = root.getValue() + root.getChildren().get(0).getValue();
    Integer exp = 3;
    Assertions.assertEquals(exp, act);
  }

  /**
   * GetChildren function test.
   */
  @Test
  public void getChildrenTest() {
    Node<Integer> root = new Node<>(1);
    Node<Integer> nodeA = new Node<>(2);
    root.add(nodeA);
    Node<Integer> nodeB = new Node<>(3);
    root.add(nodeB);
    Node<Integer> nodeC = new Node<>(4);
    root.add(nodeC);
    Node<Integer> nodeD = new Node<>(5);
    root.add(nodeD);
    List<Node<Integer>> list = root.getChildren();
    List<Integer> act = new ArrayList<>();
    for (Node<Integer> i : list) {
      act.add(i.getValue());
    }
    List<Integer> exp = Arrays.asList(2, 3, 4, 5);
    Assertions.assertEquals(exp, act);
  }

  /**
   * GetValue function test.
   */
  @Test
  public void getValueTest() {
    Node<String> root = new Node<>("Hello. I'm fine!");
    String act = root.getValue();
    String exp = "Hello. I'm fine!";
    Assertions.assertEquals(exp, act);
  }

  /**
   * SetValue function test.
   */
  @Test
  public void setValueTest() {
    Node<String> root = new Node<>("Hello.");
    Node<String> nodeA = new Node<>("I'm bad!");
    nodeA.setValue("I'm fine!");
    String act = root.getValue() + nodeA.getValue();
    String exp = "Hello.I'm fine!";
    Assertions.assertEquals(act, exp);
  }

  /**
   * Remove function test.
   */
  @Test
  public void removeTest() {
    Node<Integer> act = new Node<>(1);
    Node<Integer> nodeA = new Node<>(2);
    act.add(nodeA);
    Node<Integer> nodeB = new Node<>(3);
    nodeA.add(nodeB);
    act.remove(nodeA);

    Node<Integer> exp = new Node<>(1);
    Node<Integer> nodeC = new Node<>(3);
    exp.add(nodeC);

    Assertions.assertEquals(exp, act);
  }

  /**
   * GetParent function test.
   */
  @Test
  public void getParentTest() {
    Node<Double> root = new Node<>(21.215);
    Node<Double> nodeA = new Node<>(22.215);
    root.add(nodeA);

    Double act = nodeA.getParent().getValue();
    Double exp = 21.215;
    Assertions.assertEquals(act, exp);
  }

  /**
   * Example test implementation.
   */
  @Test
  public void exampleTest() {
    Node<String> act = new Node<>("A");
    Node<String> nodeB = new Node<>("B");
    act.add(nodeB);
    Node<String> nodeC = new Node<>("AB");
    nodeB.add(nodeC);
    Node<String> nodeD = new Node<>("BB");
    nodeB.add(nodeD);

    Node<String> exp = new Node<>("A");
    Node<String> nodeE = new Node<>("B");
    exp.add(nodeE);
    Node<String> nodeF = new Node<>("AB");
    nodeE.add(nodeF);
    Node<String> nodeG = new Node<>("BB");
    nodeE.add(nodeG);

    Assertions.assertEquals(act, exp);

    nodeE.remove(nodeG);
    Assertions.assertNotEquals(act, exp);
  }

  /**
   * Breadth-First-Search test.
   */
  @Test
  public void bfsTreeTest() {
    Node<String> root = new Node<>("A");
    Node<String> nodeB = new Node<>("B");
    root.add(nodeB);
    Node<String> nodeC = new Node<>("C");
    root.add(nodeC);
    Node<String> nodeD = new Node<>("D");
    nodeB.add(nodeD);
    Node<String> nodeE = new Node<>("E");
    nodeB.add(nodeE);
    Node<String> nodeF = new Node<>("F");
    nodeC.add(nodeF);

    BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(root);
    ArrayList<String> act = new ArrayList<>();
    while (bfs.hasNext()) {
      act.add(bfs.next());
    }
    List<String> exp = Arrays.asList("A", "B", "C", "D", "E", "F");
    Assertions.assertEquals(act, exp);
  }

  /**
   * Depth-First-Search test.
   */
  @Test
  public void dfsTreeTest() {
    Node<String> root = new Node<>("A");
    Node<String> nodeB = new Node<>("B");
    root.add(nodeB);
    Node<String> nodeC = new Node<>("C");
    root.add(nodeC);
    Node<String> nodeD = new Node<>("D");
    nodeB.add(nodeD);
    Node<String> nodeE = new Node<>("E");
    nodeB.add(nodeE);
    Node<String> nodeF = new Node<>("F");
    nodeC.add(nodeF);
    DepthFirstSearch<String> dfs = new DepthFirstSearch<>(root);
    ArrayList<String> act = new ArrayList<>();
    while (dfs.hasNext()) {
      act.add(dfs.next());
    }
    List<String> exp = Arrays.asList("A", "C", "F", "B", "E", "D");
    Assertions.assertEquals(act, exp);
  }
}
