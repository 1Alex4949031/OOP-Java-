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
  public void valueTest() {
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
    Vertex<String> act1 = new Vertex<>("Hello");
    Vertex<String> act2 = new Vertex<>("How are you?");
    Vertex<String> exp = new Vertex<>("How are you?");

    Assertions.assertNotEquals(exp, act1);
    Assertions.assertEquals(exp, act2);
  }

  @Test
  public void getValueTest() {
    Vertex<Integer> vertex = new Vertex<>(101);
    vertex.setValue(101);
    int act = vertex.getValue();
    int exp = 101;

    Assertions.assertEquals(exp, act);

    vertex.setValue(10);
    act = vertex.getValue();

    Assertions.assertNotEquals(exp, act);
  }

  @Test
  public void hashCodeTest() {
    Vertex<String> v1 = new Vertex<>("Hello!");
    v1.setValue(101);
    int act = v1.hashCode();

    Vertex<String> v2 = new Vertex<>("Hello!");
    v2.setValue(101);
    int exp = v1.hashCode();

    Assertions.assertEquals(exp, act);
  }
}
