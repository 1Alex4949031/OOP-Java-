package ru.nsu.seleznev.a;

import java.util.Stack;

/**
 * Calculator class implements Prefix Calculator
 */
public class Calculator {

  /**
   * Function that calculates the expression.
   *
   * @param exp current expression
   * @return double value of counted expression
   */
  public static double calculate(String exp)
      throws IllegalArgumentException {
    String[] signs = exp.split(" ");
    int len = signs.length;

    Stack<Double> stack = new Stack<>();

    for (int i = len - 1; i >= 0; i--) {
      try {
        stack.push(Double.parseDouble(signs[i]));
      } catch (NumberFormatException e) {
        switch (signs[i]) {
          case ("+") -> {
            checkStack(stack, 2);
            stack.push(stack.pop() + stack.pop());
          }
          case ("-") -> {
            checkStack(stack, 2);
            stack.push(stack.pop() - stack.pop());
          }
          case ("*") -> {
            checkStack(stack, 2);
            stack.push(stack.pop() * (stack.pop()));
          }
          case ("/") -> {
            checkStack(stack, 2);
            double num = stack.pop();
            double den = stack.pop();
            checkDivision(den);
            stack.push(num / den);
          }
          case ("sin") -> {
            checkStack(stack, 1);
            stack.push(Math.sin(stack.pop()));
          }
          case ("cos") -> {
            checkStack(stack, 1);
            stack.push(Math.cos(stack.pop()));
          }
          case ("sqrt") -> {
            checkStack(stack, 1);
            double num = stack.pop();
            checkSqrt(num);
            stack.push(Math.sqrt(num));
          }
          case ("log") -> {
            checkStack(stack, 2);
            double num = stack.pop();
            double den = stack.pop();
            checkLog(num, den);
            stack.push(Math.log(num) / Math.log(den));
          }
          case ("pow") -> {
            checkStack(stack, 2);
            stack.push(Math.pow(stack.pop(), stack.pop()));
          }
          default -> throw new
              IllegalArgumentException("Неверно введена строка!");
        }
      }
    }
    if (stack.size() > 1) {
      throw new IllegalArgumentException("Неверно введена строка!");
    }
    return stack.pop();
  }

  /**
   * Function that checks the size of the stack.
   *
   * @param stack current stack
   * @param size  current size
   */
  private static void checkStack(Stack<Double> stack, int size) {
    if (stack.size() < size) {
      throw new IllegalArgumentException("Неверно введена строка!");
    }
  }

  /**
   * Function that checks conditions for the logarithm.
   *
   * @param a argument of the logarithm
   * @param b basement of the logarithm
   */
  private static void checkLog(double a, double b) {
    if (a <= 0 || b <= 0 || b == 1) {
      throw new IllegalArgumentException("Неверное условие на логарифм!");
    }
  }

  /**
   * Function that checks conditions for the sqrt operation.
   *
   * @param a number for sqrt operation
   */
  private static void checkSqrt(double a) {
    if (a < 0) {
      throw new IllegalArgumentException(
          "Брать корень из отрицательного числа запрещено законом!");
    }
  }

  /**
   * Function that checks conditions for division.
   *
   * @param a denominator
   */
  private static void checkDivision(double a) {
    if (a == 0) {
      throw new IllegalArgumentException(
          "Деление на 0 запрещено законом!");
    }
  }
}
