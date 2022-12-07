package ru.nsu.seleznev.a;

import java.util.Stack;

public class Calculator {

  public static double calculate(String exp) {
    String[] signs = exp.split(" ");
    int len = signs.length;

    Stack<Double> stack = new Stack<>();

    for (int i = len - 1; i >= 0; i--) {
      try {
        stack.push(Double.parseDouble(signs[i]));
      } catch (NumberFormatException e) {
        switch (signs[i]) {
          case ("+") -> stack.push(stack.pop() + stack.pop());
          case ("-") -> stack.push(stack.pop() - stack.pop());
          case ("*") -> stack.push(stack.pop() * stack.pop());
          case ("/") -> stack.push(stack.pop() / stack.pop());
          case ("sin") -> stack.push(Math.sin(stack.pop()));
          case ("cos") -> stack.push(Math.cos(stack.pop()));
          case ("sqrt") -> stack.push(Math.sqrt(stack.pop()));
          case ("log") -> stack.push(Math.log(stack.pop()));
          case ("pow") -> stack.push(Math.pow(stack.pop(), stack.pop()));
        }
      }
    }
    return stack.pop();
  }

  public static void main(String[] args) {
    //  (1 + 2) + (3 + 4)
    String test1 = "+ + 1.0 2.0 + 3.0 4.0";
    double ans1 = Calculator.calculate(test1);
    // 4 + 5 * 3 / 10 - 15 + 15 - 15 * (1 / 5)
    String test2 = "- 15 7";
    double ans2 = Calculator.calculate(test2);
    String test3 = "sin + - 1 2 1";
    double ans3 = Calculator.calculate(test3);
  }
}
