package ru.nsu.a.seleznev;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests implementation for check the correctness of stack.
 */
class Tests {
  /**
   * Test number 1 for Integer type.
   */
  @Test
  public void integerTest() {
    Stack<Integer> t1 = new Stack<>(2);
    t1.push(10);
    t1.push(20);
    t1.push(30);
    t1.push(40);
    t1.popStack(2);

    Stack<Integer> test = new Stack<>(2);
    test.push(77);
    test.push(66);
    t1.pushStack(test);

    Stack<Integer> act = new Stack<>(4);
    act.push(10);
    act.push(20);
    act.push(77);
    act.push(66);


    Assertions.assertEquals(t1.count(), act.count());
    Assertions.assertEquals(t1, act);
  }

  /**
   * Test number 2 for String type.
   */
  @Test
  public void stringTest() {
    Stack<String> t2 = new Stack<>(3);
    t2.push("Hello");
    t2.push("How are you?");
    t2.push("Knave");

    Stack<String> pu = new Stack<>(3);
    pu.push("Hello");
    pu.push("How are you?");
    pu.push("Friend");

    t2.pop();
    t2.push("Friend");

    Assertions.assertEquals(t2.count(), pu.count());
    Assertions.assertEquals(t2, pu);
  }

  /**
   * Test number 3 for Double type.
   */
  @Test
  public void doubleTest() {
    Stack<Double> t3 = new Stack<>(10);
    t3.push(1.03);

    Stack<Double> st = new Stack<>(6);
    st.push(1.04);
    st.push(1.05);
    st.push(1.06);
    st.push(2.22);
    st.push(3.33);
    st.push(4.44);

    t3.pushStack(st);
    t3.popStack(3);

    Stack<Double> act = new Stack<>(10);
    act.push(1.03);
    act.push(1.04);
    act.push(1.05);
    act.push(1.06);

    Assertions.assertEquals(t3.count(), act.count());
    Assertions.assertEquals(t3, act);
  }
}
