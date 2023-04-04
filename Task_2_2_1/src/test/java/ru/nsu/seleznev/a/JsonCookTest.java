package ru.nsu.seleznev.a;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.nsu.seleznev.a.jsonreader.JsonCook;

/**
 * JsonCook tests.
 */
public class JsonCookTest {
  @Test
  public void getNameTest() {
    JsonCook cook = new JsonCook("Alex", 2);
    String act = cook.getName();
    String exp = "Alex";
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void getExperienceTest() {
    JsonCook cook = new JsonCook("Alex", 2);
    int act = cook.getExperience();
    int exp = 2;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void equalsTest() {
    JsonCook act = new JsonCook("Alex", 2);
    JsonCook exp = new JsonCook("Alex", 2);

    Assertions.assertEquals(exp, act);
  }

  @Test
  public void equalsHashCodeTest() {
    JsonCook act = new JsonCook("Alex", 2);
    JsonCook exp = new JsonCook("Alex", 2);

    Assertions.assertEquals(exp.hashCode(), act.hashCode());
  }
}
