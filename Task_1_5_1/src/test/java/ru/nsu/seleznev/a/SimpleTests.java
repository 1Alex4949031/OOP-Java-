package ru.nsu.seleznev.a;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for Calculator class.
 */
public class SimpleTests {
  @Test
  public void plusTest() {
    String expression = "+ 1 1";
    Double act = Calculator.calculate(expression);
    Double exp = 2.0;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void minusTest() {
    String expression = "- 10 1";
    Double act = Calculator.calculate(expression);
    Double exp = 9.0;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void multiplyTest() {
    String expression = "* 10 2";
    Double act = Calculator.calculate(expression);
    Double exp = 20.0;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void divisionTest() {
    String expression = "/ 10 2";
    Double act = Calculator.calculate(expression);
    Double exp = 5.0;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void powPositiveTest() {
    String expression = "pow 2 3";
    Double act = Calculator.calculate(expression);
    Double exp = 8.0;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void powNegativeTest() {
    String expression = "pow -2 3";
    Double act = Calculator.calculate(expression);
    Double exp = -8.0;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void powRationalTest() {
    String expression = "pow 2 -2";
    Double act = Calculator.calculate(expression);
    Double exp = 0.25;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void sinTest() {
    String expression = "sin 0";
    Double act = Calculator.calculate(expression);
    Double exp = 0.0;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void cosTest() {
    String expression = "cos 0";
    Double act = Calculator.calculate(expression);
    Double exp = 1.0;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void logSimpleTest() {
    String expression = "log 1 120";
    Double act = Calculator.calculate(expression);
    Double exp = 0.0;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void logTest() {
    String expression = "log 8 2";
    Double act = Calculator.calculate(expression);
    Double exp = 3.0;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void sqrtTest() {
    String expression = "sqrt 64";
    Double act = Calculator.calculate(expression);
    Double exp = 8.0;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void exampleTest() {
    String expression = "sin + - 1 2 1";
    Double act = Calculator.calculate(expression);
    Double exp = 0.0;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void expressionTest1() {
    // (1 + 2) + (3 + 4)
    String expression = "+ + 1.0 2.0 + 3.0 4.0";
    Double act = Calculator.calculate(expression);
    Double exp = 10.0;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void expressionTest2() {
    // 1 + 2 - 4 * 10
    String expression = "+ 1 - 2 * 4 10";
    Double act = Calculator.calculate(expression);
    Double exp = -37.0;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void expressionTest3() {
    // pow(2,2) + 4 / 10
    String expression = "+ pow 2 2 / 4 10";
    Double act = Calculator.calculate(expression);
    Double exp = 4.4;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void expressionTest4() {
    // (22 - 12) + 14 / 16 + 22 - 14 * 15
    String expression = "+ - 22 12 + / 14 16 - 22 * 14 15";
    Double act = Calculator.calculate(expression);
    Double exp = -177.125;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void expressionTest5() {
    // (22 - 12) + 14 / 16 + 22 - 14 * 15
    String expression = "- + 25 44 - 12 - pow 3 4 + 112 - 256 + log 1 120 sin 0";
    Double act = Calculator.calculate(expression);
    Double exp = -230.0;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void exceptionDivisionTest() {
    String expression = "/ 10 0";
    IllegalArgumentException exception =
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> Calculator.calculate(expression));
    Assertions.assertEquals("Деление на 0 запрещено законом!",
        exception.getMessage());
  }

  @Test
  public void exceptionLogBasementTest() {
    String expression = "log 8 -10";
    IllegalArgumentException exception =
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> Calculator.calculate(expression));
    Assertions.assertEquals("Неверное условие на логарифм!",
        exception.getMessage());
  }

  @Test
  public void exceptionLogArgumentTest() {
    String expression = "log -10 100";
    IllegalArgumentException exception =
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> Calculator.calculate(expression));
    Assertions.assertEquals("Неверное условие на логарифм!",
        exception.getMessage());
  }

  @Test
  public void exceptionSqrtTest() {
    String expression = "sqrt -10";
    IllegalArgumentException exception =
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> Calculator.calculate(expression));
    Assertions.assertEquals(
        "Брать корень из отрицательного числа запрещено законом!",
        exception.getMessage());
  }

  @Test
  public void incorrectExpressionTest1() {
    String expression = "+ + +";
    IllegalArgumentException exception =
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> Calculator.calculate(expression));
    Assertions.assertEquals("Неверно введена строка!",
        exception.getMessage());
  }

  @Test
  public void incorrectExpressionTest2() {
    String expression = "1 10 100";
    IllegalArgumentException exception =
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> Calculator.calculate(expression));
    Assertions.assertEquals("Неверно введена строка!",
        exception.getMessage());
  }
}