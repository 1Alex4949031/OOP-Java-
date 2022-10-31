package a.seleznev.nsu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for vertex class.
 */
public class VertexTest {
  @Test
  public void getNameTest() {
    Vertex<String> vertex = new Vertex<>("Hello world!");

    String act = vertex.getName();
    String exp = "Hello world!";

    Assertions.assertEquals(exp, act);
  }

  @Test
  public void ValueTest() {
    Vertex<String> vertex = new Vertex<>("Hello world!");
    int act = vertex.getValue();
    int exp = -1;

    Assertions.assertEquals(exp, act);

    vertex.setValue(10);
    act = vertex.getValue();
    exp = 10;

    Assertions.assertEquals(exp, act);
  }

  @Test
  public void vertexEqualsTest() {
    Vertex<String> act_1 = new Vertex<>("Hello");
    Vertex<String> act_2 = new Vertex<>("How are you?");
    Vertex<String> exp = new Vertex<>("How are you?");

    Assertions.assertNotEquals(exp, act_1);
    Assertions.assertEquals(exp, act_2);
  }
}
