package ru.nsu.seleznev.a.model;

import groovy.lang.Closure;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import ru.nsu.seleznev.a.strings.LessonString;

public class Lessons {
  List<Lesson> lessons = new ArrayList<>();

  public Lessons() {
  }

  public Lessons(List<Lesson> lessons) {
    this.lessons = lessons;
  }

  public void lesson(Closure<?> closure) {
    LessonString lessonString = new LessonString();
    closure.setDelegate(lessonString);
    closure.setResolveStrategy(Closure.DELEGATE_ONLY);
    closure.call();
    lessons.add(new Lesson(LocalDate.parse(lessonString.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
  }

  public List<Lesson> getLessonList() {
    return lessons;
  }

  @Override
  public String toString() {
    return "Lessons{" +
        "lessons=" + lessons +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Lessons lessons1 = (Lessons) o;
    return Objects.equals(lessons, lessons1.lessons);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lessons);
  }
}

