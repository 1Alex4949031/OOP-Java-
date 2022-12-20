package ru.nsu.seleznev.a;

import java.util.Scanner;

/**
 * Console calculator implementation.
 * Try to Run it!).
 */
public class ConsoleCalculator {
  /**
   * Main function that interacts with the user.
   *
   * @param args arguments
   */
  public static void main(String[] args) {
    System.out.println("Здравствуйте, это ваш персональный калькулятор!");
    System.out.println("Готовы посчитать что-нибудь?");
    System.out.println("Если хотите закрыть калькулятор, нажмите Q.");
    Scanner scan = new Scanner(System.in);
    while (true) {
      System.out.println("Введите выражение в префиксном виде:");
      String expression = scan.nextLine();
      if (expression.equals("Q")) {
        System.out.println("Спасибо за использование! Good Bye!");
        break;
      }
      System.out.println("Ответ: " + Calculator.calculate(expression));
    }
  }
}
