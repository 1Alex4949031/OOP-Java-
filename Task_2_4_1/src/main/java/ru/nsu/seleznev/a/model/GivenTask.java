package ru.nsu.seleznev.a.model;

import java.time.LocalDate;
import java.util.Objects;


public class GivenTask {

  private String id;
  private LocalDate date;

  public GivenTask() {
  }

  public GivenTask(String id, LocalDate date) {
    this.id = id;
    this.date = date;
  }

  public String getId() {
    return id;
  }

  public LocalDate getDate() {
    return date;
  }

  @Override
  public String toString() {
    return "GivenTask{" +
        "id='" + id + '\'' +
        ", date=" + date +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GivenTask givenTask = (GivenTask) o;
    return Objects.equals(id, givenTask.id) && Objects.equals(date, givenTask.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, date);
  }
}


