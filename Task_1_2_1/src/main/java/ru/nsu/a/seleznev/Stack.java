package ru.nsu.a.seleznev;


import java.util.Arrays;
import java.util.Objects;

/**
 * Making own stack implementation with generics.
 * With different data types. (LIFO)
 */
public class Stack<custom> {
  private custom[] array;
  private int size;
  private int top;

  /**
   * Object Stack.
   */
  Stack(int size) {
    this.top = -1;
    this.size = size;
    this.array = (custom[]) new Object[size];
  }

  /**
   * Function that adds item into stack.
   *
   * @param x item we need to put
   */
  public void push(custom x) {
    if (top == (size - 1)) {
      System.out.println("Stack Overflow");
      this.increaseCapacity();
    }
    top += 1;
    array[top] = x;
  }

  /**
   * Function that removes the last item from the Stack.
   *
   * @return the element we need to pop
   */
  public custom pop() {
    if (top < 0) {
      System.out.println("Stack is Empty");
      return null;
    } else {
      custom buff = array[top];
      array[top] = null;
      top -= 1;
      return buff;
    }
  }

  /**
   * Function that counts all items in the Stack.
   *
   * @return count of items
   */
  public int count() {
    return top + 1;
  }

  /**
   * Function that adds some amount of elements into the Stack.
   *
   * @param st object of type Stack
   */
  void pushStack(Stack<custom> st) {
    for (int i = 0; i < st.array.length; i++) {
      push(st.array[i]);
    }
  }

  /**
   * Function that removes amount of elements from the end of the stack.
   *
   * @param num count of elements need to remove
   */
  custom[] popStack(int num) {
    custom[] buff = (custom[]) new Object[top + 1];
    while (num != 0) {
      buff[num - 1] = pop();
      num -= 1;
    }
    return buff;
  }

  /**
   * Method that increases the capacity of the Stack.
   */
  private void increaseCapacity() {
    custom[] newStack = (custom[]) new Object[size * 2];
    for (int i = 0; i < this.size; i++) {
      newStack[i] = this.array[i];
    }
    this.array = newStack;
    this.size = this.size * 2;
  }

  /**
   * Function that helps to male correct Assertion.
   *
   * @return array
   */
  public custom[] toArray() {
    custom[] buff = (custom[]) new Object[top + 1];
    for (int i = 0; i < top + 1; i++) {
      buff[i] = array[i];
    }
    return buff;
  }

  /**
   * Override of equals method for comparison generic arrays.
   */

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Stack)) {
      return false;
    }
    Stack<?> act = (Stack<?>) o;
    return top == act.top && Arrays.equals(array, act.array);
  }


  /**
   * Override of hashCode method for correct comparison generic arrays.
   */

  @Override
  public int hashCode() {
    int result = Objects.hash(top);
    result = 31 * result + Arrays.hashCode(array);
    return result;
  }

  /**
   * Test for java compiler.
   *
   * @param args for command line
   */
  public static void main(String[] args) {
    System.out.println("Successfully!!!");
  }
}


