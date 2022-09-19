import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Tests implementation for check the correctness of stack.
 */
class Tests {
  /**
   * Test number 1.
   */
  @Test
  public void theFirstTest() {
    Stack<Integer> t1 = new Stack<>(10);
    Stack<Integer> pu = new Stack<>(4);

    pu.push(10);
    pu.push(20);
    pu.push(30);
    // pu : 10, 20, 30

    t1.push(100);
    t1.push(256);
    t1.push(119);
    // t1 : 100, 256, 119

    t1.pop();
    t1.popStack(2);
    // t1 :

    t1.pushStackObj(pu);
    // t1: 10, 20, 30

    int len = t1.count();

    Assertions.assertEquals(len, 3);
    Assertions.assertEquals(t1.toArray(), pu.toArray());

    Assertions.assertEquals(t1.toString(), pu.toString());
  }

  /**
   * Test number 2.
   */
  @Test
  public void TheSecondTest() {
    Stack<String> t2 = new Stack<>(3);
    t2.push("Hello");
    t2.push("How are you?");
    t2.push("Knave");
    //t2 : Hello, How are you?, Knave

    List<String> pu = Arrays.asList("Hello", "How are you?", "Friend");

    t2.pop();
    t2.push("Friend");
    //t2 : Hello, How are you?, Friend
    int len = t2.count();

    Assertions.assertEquals(len, 3);
    Assertions.assertEquals(t2.toArray(), pu);
  }

  /**
   * Test number 3.
   */
  @Test
  public void TheThirdTest() {
    Stack<Double> t3 = new Stack<>(10);
    t3.push(1.03);
    //t3: 1.03

    List<Double> pu = Arrays.asList(1.04, 1.05, 1.06);

    t3.pushStackList(pu);
    //t3: 1.03, 1.04, 1.05, 1.06

    List<Double> act = Arrays.asList(1.03, 1.04, 1.05, 1.06);

    Assertions.assertEquals(t3.toArray(), act);

    t3.popStack(4);
    t3.push(6.66);
    //t3 : 6.66

    List<Double> fin = Arrays.asList(6.66);
    Assertions.assertEquals(t3.toArray(), fin);

  }
}
