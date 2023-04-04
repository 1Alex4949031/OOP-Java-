package ru.nsu.seleznev.a;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.nsu.seleznev.a.jsonreader.JsonCook;
import ru.nsu.seleznev.a.jsonreader.JsonCourier;
import ru.nsu.seleznev.a.jsonreader.JsonValues;

/**
 * JsonValues tests.
 */
public class JsonValuesTest {
  @Test
  public void getCooksTest() {
    List<JsonCook> cooks = new ArrayList<>();
    cooks.add(new JsonCook("Alex", 1));
    cooks.add(new JsonCook("Sasha", 2));
    JsonValues values = new JsonValues(cooks, new ArrayList<>(), 0, 0);
    List<JsonCook> act = values.getCooks();
    List<JsonCook> exp = new ArrayList<>();
    exp.add(new JsonCook("Alex", 1));
    exp.add(new JsonCook("Sasha", 2));

    Assertions.assertEquals(exp, act);
  }

  @Test
  public void getCouriersTest() {
    List<JsonCourier> couriers = new ArrayList<>();
    couriers.add(new JsonCourier("Ben", 1, 7));
    couriers.add(new JsonCourier("Ten", 3, 5));
    JsonValues values = new JsonValues(new ArrayList<>(), couriers, 0, 0);
    List<JsonCourier> act = values.getCouriers();
    List<JsonCourier> exp = new ArrayList<>();
    exp.add(new JsonCourier("Ben", 1, 7));
    exp.add(new JsonCourier("Ten", 3, 5));

    Assertions.assertEquals(exp, act);
  }

  @Test
  public void getStorageSizeTest() {
    JsonValues values = new JsonValues(new ArrayList<>(), new ArrayList<>(), 111, 0);
    int act = values.getStorageSize();
    int exp = 111;

    Assertions.assertEquals(exp, act);
  }

  @Test
  public void getQueueSizeTest() {
    JsonValues values = new JsonValues(new ArrayList<>(), new ArrayList<>(), 0, 112);
    int act = values.getQueueSize();
    int exp = 112;

    Assertions.assertEquals(exp, act);
  }

  @Test
  public void notEqualsTest() {
    List<JsonCook> cooks = new ArrayList<>();
    cooks.add(new JsonCook("Alex", 1));
    cooks.add(new JsonCook("Sasha", 2));
    List<JsonCourier> couriers = new ArrayList<>();
    couriers.add(new JsonCourier("Ben", 1, 7));
    couriers.add(new JsonCourier("Ten", 3, 5));
    JsonValues act = new JsonValues(cooks, couriers, 5, 7);
    JsonValues exp = new JsonValues(cooks, couriers, 5, 6);

    Assertions.assertNotEquals(exp, act);
  }

  @Test
  public void equalsTest() {
    List<JsonCook> cooks = new ArrayList<>();
    cooks.add(new JsonCook("Alex", 1));
    cooks.add(new JsonCook("Sasha", 2));
    List<JsonCourier> couriers = new ArrayList<>();
    couriers.add(new JsonCourier("Ben", 1, 7));
    couriers.add(new JsonCourier("Ten", 3, 5));
    JsonValues act = new JsonValues(cooks, couriers, 5, 6);
    JsonValues exp = new JsonValues(cooks, couriers, 5, 6);

    Assertions.assertEquals(exp, act);
  }

  @Test
  public void hashCodeTest() {
    List<JsonCook> cooks = new ArrayList<>();
    cooks.add(new JsonCook("Alex", 1));
    cooks.add(new JsonCook("Sasha", 2));
    List<JsonCourier> couriers = new ArrayList<>();
    couriers.add(new JsonCourier("Ben", 1, 7));
    couriers.add(new JsonCourier("Ten", 3, 5));
    JsonValues act = new JsonValues(cooks, couriers, 5, 6);
    JsonValues exp = new JsonValues(cooks, couriers, 5, 6);

    Assertions.assertEquals(exp.hashCode(), act.hashCode());
  }
}
