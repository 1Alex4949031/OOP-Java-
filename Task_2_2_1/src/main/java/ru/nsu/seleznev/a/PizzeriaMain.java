package ru.nsu.seleznev.a;

import ru.nsu.seleznev.a.jsonreader.GsonParser;
import ru.nsu.seleznev.a.jsonreader.JsonValues;

/**
 * PizzeriaMain class that starts the work of the Pizzeria "BIG J".
 */
public class PizzeriaMain {
  /**
   * Main function that initializes and starts the pizzeria.
   *
   * @param args args
   */
  public static void main(String[] args) {
    GsonParser jsonFile = new GsonParser();
    JsonValues values = jsonFile.parse();
    Pizzeria pizzeria = new Pizzeria(values);
    final int time = 30000;
    pizzeria.running(time);
  }
}
