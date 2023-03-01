package ru.nsu.seleznev.a;

import ru.nsu.seleznev.a.jsonReader.GsonParser;
import ru.nsu.seleznev.a.jsonReader.JsonValues;
import org.junit.jupiter.api.Test;
import ru.nsu.seleznev.a.Pizzeria;

public class PizzeriaTest {
  @Test
  public void PizzeriaWorkingTest(){
    GsonParser jsonFile = new GsonParser();
    JsonValues values = jsonFile.parse();
    Pizzeria pizzeria = new Pizzeria(values);
    final int time = 30000;
    pizzeria.running(time);
  }
}
