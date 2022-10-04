package ru.nsu.a.seleznev;


import java.util.Arrays;
import java.util.Objects;

/**
 * Making own stack implementation with generics.
 * With different data types. (LIFO)
 */
public class Stack<T> {
  private T[] array;

  private int size;
  private int top;

  /**
   * Object Stack.
   */
  public Stack(int size) {
    this.top = -1;
    this.size = size;
    this.array = (T[]) new Object[size];
  }

  /**
   * Function that adds item into stack.
   *
   * @param x item we need to put
   */
  public void push(T x) {
    if (top == (size - 1)) {
      increaseCapacity();
    }
    top += 1;
    array[top] = x;
  }

  /**
   * Function that removes the last item from the Stack.
   *
   * @return the element we need to pop
   */
  public T pop() {
    if (top < 0) {
      System.out.println("Stack is Empty");
      return null;
    } else {
      T buff = array[top];
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
  void pushStack(Stack<T> st) {
    for (int i = 0; i < st.array.length; i++) {
      push(st.array[i]);
    }
  }

  /**
   * Function that removes amount of elements from the end of the stack.
   *
   * @param num count of elements need to remove
   * @return stack with the elements removed
   */
  Stack<T> popStack(int num) {
    Stack<T> res = new Stack<>(num);
    for (int i = 0; i < num; i++) {
      T buff = this.pop();
      res.push(buff);
    }
    return res;
  }

  /**
   * Method that increases the capacity of the Stack.
   */
  private void increaseCapacity() {
    array = Arrays.copyOf(array, size * 2);
    size *= 2;
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


