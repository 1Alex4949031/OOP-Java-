package ru.nsu.seleznev.a.model;

import java.time.LocalDate;
import java.util.Objects;


/**
 * GivenTask class.
 */
public class GivenTask {

  private String id;
  private LocalDate date;

  /**
   * Empty constructor.
   */
  public GivenTask() {
  }

  /**
   * Constructor.
   *
   * @param id   task id
   * @param date task date
   */
  public GivenTask(String id, LocalDate date) {
    this.id = id;
    this.date = date;
  }

  /**
   * Function that returns id of the task.
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  /**
   * Function that returns the date of the task.
   *
   * @return date
   */
  public LocalDate getDate() {
    return date;
  }

  /**
   * To String function.
   *
   * @return string value
   */
  @Override
  public String toString() {
    return "GivenTask{" +
        "id='" + id + '\'' +
        ", date=" + date +
        '}';
  }

  /**
   * Default equals function.
   *
   * @param o object need to compare with.
   * @return true if objects are equals, false otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GivenTask givenTask = (GivenTask) o;
    return Objects.equals(id, givenTask.id) && Objects.equals(date, givenTask.date);
  }

  /**
   * Default hashcode function.
   *
   * @return hash code ot the object
   */
  @Override
  public int hashCode() {
    return Objects.hash(id, date);
  }
}


