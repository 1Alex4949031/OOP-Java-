package ru.nsu.seleznev.a;

import org.junit.jupiter.api.Test;
import ru.nsu.seleznev.a.jsonreader.GsonParser;
import ru.nsu.seleznev.a.jsonreader.JsonValues;

/**
 * Pizzeria "Big J" Test.
 */
public class PizzeriaTest {
  @Test
  public void pizzeriaWorkingTest() {
    GsonParser jsonFile = new GsonParser();
    JsonValues values = jsonFile.parse();
    Pizzeria pizzeria = new Pizzeria(values);
    final int time = 30000;
    pizzeria.running(time);
  }
}
