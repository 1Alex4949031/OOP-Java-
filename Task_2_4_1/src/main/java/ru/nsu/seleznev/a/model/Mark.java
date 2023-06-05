package ru.nsu.seleznev.a.model;

import java.time.LocalDate;
import java.util.Objects;


public class Mark {
  private int mark;
  private LocalDate date;

  public Mark() {
  }

  public Mark(int mark, LocalDate date) {
    this.mark = mark;
    this.date = date;
  }

  public int getMark() {
    return mark;
  }

  public LocalDate getDate() {
    return date;
  }

  @Override
  public String toString() {
    return "Mark{" +
        "mark=" + mark +
        ", date=" + date +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Mark mark1 = (Mark) o;
    return mark == mark1.mark && Objects.equals(date, mark1.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mark, date);
  }
}
