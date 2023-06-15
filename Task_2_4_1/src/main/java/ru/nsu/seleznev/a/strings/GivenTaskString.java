package ru.nsu.seleznev.a.strings;


/**
 * GivenTaskString class for reading dsl config.
 */
public class GivenTaskString {
  private String id;
  private String date;

  /**
   * Empty constructor.
   */
  public GivenTaskString() {
  }

  /**
   * Function that returns task id.
   *
   * @return String task id.
   */
  public String getId() {
    return id;
  }

  /**
   * Function that returns task date.
   *
   * @return String date
   */
  public String getDate() {
    return date;
  }
}
