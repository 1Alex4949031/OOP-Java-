package ru.nsu.seleznev.a.jsonreader;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * JsonValues class for values from Json.
 */
@Getter
@Setter
@AllArgsConstructor
public class JsonValues {
  private int rows;
  private int columns;
  private int width;
  private int height;
}
