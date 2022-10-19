package ru.nsu.a.seleznev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * The implementation of different test for correct work of Tree.
 */
public class TreeTests {

  @Test
  public void addTest() {
    Node<Integer> root = new Node<>(1);
    Node<Integer> nodeA = new Node<>(2);
    root.add(nodeA);
    Integer act = root.getValue() + root.getChildren().get(0).getValue();
    Integer exp = 3;
    Assertions.assertEquals(exp, act);
  }


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


  @Test
  public void getValueTest() {
    Node<String> root = new Node<>("Hello. I'm fine!");
    String act = root.getValue();
    String exp = "Hello. I'm fine!";
    Assertions.assertEquals(exp, act);
  }


  @Test
  public void setValueTest() {
    Node<String> root = new Node<>("Hello.");
    Node<String> nodeA = new Node<>("I'm bad!");
    nodeA.setValue("I'm fine!");
    String act = root.getValue() + nodeA.getValue();
    String exp = "Hello.I'm fine!";
    Assertions.assertEquals(act, exp);
  }


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


  @Test
  public void getParentTest() {
    Node<Double> root = new Node<>(21.215);
    Node<Double> nodeA = new Node<>(22.215);
    root.add(nodeA);

    Double act = nodeA.getParent().getValue();
    Double exp = 21.215;
    Assertions.assertEquals(act, exp);
  }


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


  @Test
  public void getCountMod() {
    Node<String> root = new Node<>("A");
    Node<String> nodeA = new Node<>("B");
    root.add(nodeA);
    Node<String> nodeB = new Node<>("C");
    nodeA.add(nodeB);
    Node<String> nodeC = new Node<>("D");
    nodeB.add(nodeC);
    int act = root.getCountMod();
    int exp = 3;
    Assertions.assertEquals(exp, act);
    act = nodeC.getCountMod(nodeB);
    exp = 1;
    Assertions.assertEquals(exp, act);
  }


  @Test
  public void getRootTest() {
    Node<Double> exp = new Node<>(1.1);
    Node<Double> nodeA = new Node<>(2.2);
    exp.add(nodeA);
    Node<Double> nodeB = new Node<>(3.3);
    nodeA.add(nodeB);
    Node<Double> nodeC = new Node<>(4.4);
    nodeB.add(nodeC);

    Node<Double> act = nodeC.getRoot();
    Assertions.assertEquals(exp, act);
  }


  @Test
  public void dfsTreeExceptionTest() {
    Node<String> root = new Node<>("A");
    Node<String> nodeB = new Node<>("B");
    root.add(nodeB);
    Node<String> nodeC = new Node<>("C");
    nodeB.add(nodeC);
    Node<String> nodeD = new Node<>("D");
    nodeC.add(nodeD);
    DepthFirstSearch<String> dfs = new DepthFirstSearch<>(root);

    Node<String> nodeF = new Node<>("F");
    nodeC.add(nodeF);
    Assertions.assertThrows(ConcurrentModificationException.class, dfs::next);
  }


  @Test
  public void bfsTreeExceptionTest() {
    Node<String> root = new Node<>("A");
    Node<String> nodeB = new Node<>("B");
    root.add(nodeB);
    Node<String> nodeC = new Node<>("C");
    nodeB.add(nodeC);
    Node<String> nodeD = new Node<>("D");
    nodeC.add(nodeD);
    DepthFirstSearch<String> bfs = new DepthFirstSearch<>(root);

    Node<String> nodeF = new Node<>("F");
    nodeC.add(nodeF);
    Assertions.assertThrows(ConcurrentModificationException.class, bfs::next);
  }
}
