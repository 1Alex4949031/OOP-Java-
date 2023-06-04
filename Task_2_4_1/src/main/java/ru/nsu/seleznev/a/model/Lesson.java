package ru.nsu.seleznev.a.model;

import groovy.lang.Closure;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import ru.nsu.seleznev.a.strings.LessonString;


public class Lesson {

  private LocalDate date;

  public Lesson() {
  }

  public Lesson(LocalDate date) {
    this.date = date;
  }

  public LocalDate getDate() {
    return date;
  }

  @Override
  public String toString() {
    return "Lesson{" +
        "date=" + date +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Lesson lesson = (Lesson) o;
    return Objects.equals(date, lesson.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date);
  }
}
