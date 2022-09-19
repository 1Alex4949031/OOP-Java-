import java.util.ArrayList;
import java.util.List;

/**
 * Making own stack implementation with generics.
 * With different data types. (LIFO)
 */
public class Stack<Custom> {
  private ArrayList<Custom> Arr;
  private int size;
  private int top;

  /**
   * Object Stack
   */
  Stack(int size) {
    this.top = -1;
    this.size = size;
    this.Arr = new ArrayList<>(size);
  }

  /**
   * Function that adds item into stack
   */
  public void push(Custom X) {
    if (top == (size - 1)) {
      System.out.println("Stack Overflow");
    } else {
      top += 1;
      Arr.add(top, X);
    }
  }

  /**
   * Function that removes the last item from the stack
   */
  public void pop() {
    if (top < 0) {
      System.out.println("Stack is Empty");
    } else {
      Arr.remove(top); //not need;
      top -= 1;
    }
  }

  /**
   * Function that counts all items in the stack.
   *
   * @return count of items
   */
  public int count() {
    if (top == -1) {
      return 0;
    } else {
      return top + 1;
    }
  }

  /**
   * Function that adds some amount of elements into the stack.
   *
   * @param st object of type Stack
   */
  void pushStackObj(Stack<Custom> st) {
    for (Custom i : st.Arr) {
      push(i);
    }
  }

  /**
   * Function that adds some amount of elements into the stack.
   *
   * @param list object of instance List
   */
  void pushStackList(List<Custom> list) {
    for (Custom i : list) {
      push(i);
    }
  }

  /**
   * Function that removes amount of elements from the end of the stack.
   *
   * @param num count of elements need to remove
   */
  void popStack(int num) {
    while (num != 0) {
      pop();
      num -= 1;
    }
  }

  /**
   * Function that returns the stack type of ArrayList.
   *
   * @return ArrayList
   */
  public ArrayList<Custom> toArray() {
    return Arr;
  }

  /**
   * Function that prints the stack.
   *
   * @return string
   */
  @Override
  public String toString() {
    String res = "";
    String pr = " ";
    int len = Arr.size();
    for (Custom i : Arr) {
      if (len == 1) {
        pr = "";
      }
      res += String.valueOf(i) + pr;
      len -= 1;
    }
    return res;
  }
}


