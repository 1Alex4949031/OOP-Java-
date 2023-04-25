package ru.nsu.seleznev.a;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ru.nsu.seleznev.a.jsonreader.JsonValues;

/**
 * Tests for JsonValues.
 */
public class JsonValuesTest {

  @Test
  void testGetters() {
    JsonValues jsonValues = new JsonValues(1, 2, 3, 4);
    assertEquals(1, jsonValues.getRows());
    assertEquals(2, jsonValues.getColumns());
    assertEquals(3, jsonValues.getWidth());
    assertEquals(4, jsonValues.getHeight());
  }

  @Test
  void testSetters() {
    JsonValues jsonValues = new JsonValues(1, 2, 3, 4);
    jsonValues.setRows(5);
    jsonValues.setColumns(6);
    jsonValues.setWidth(7);
    jsonValues.setHeight(8);
    assertEquals(5, jsonValues.getRows());
    assertEquals(6, jsonValues.getColumns());
    assertEquals(7, jsonValues.getWidth());
    assertEquals(8, jsonValues.getHeight());
  }

  @Test
  void testConstructor() {
    JsonValues jsonValues = new JsonValues(1, 2, 3, 4);
    assertEquals(1, jsonValues.getRows());
    assertEquals(2, jsonValues.getColumns());
    assertEquals(3, jsonValues.getWidth());
    assertEquals(4, jsonValues.getHeight());
  }
}