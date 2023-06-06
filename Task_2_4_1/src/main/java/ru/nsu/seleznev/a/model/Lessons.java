package ru.nsu.seleznev.a.model;

import groovy.lang.Closure;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import ru.nsu.seleznev.a.strings.LessonString;

/**
 * Lessons class.
 */
public class Lessons {
  private List<Lesson> lessons = new ArrayList<>();

  /**
   * Empty constructor.
   */
  public Lessons() {
  }

  /**
   * Constructor.
   *
   * @param lessons lessons list
   */
  public Lessons(List<Lesson> lessons) {
    this.lessons = lessons;
  }

  /**
   * Lesson closure for dsl.
   *
   * @param closure block of code with important values
   */
  public void lesson(Closure<?> closure) {
    LessonString lessonString = new LessonString();
    closure.setDelegate(lessonString);
    closure.setResolveStrategy(Closure.DELEGATE_ONLY);
    closure.call();
    lessons.add(new Lesson(LocalDate.parse(lessonString.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
  }

  /**
   * Function that returns all lessons.
   *
   * @return lesson list
   */
  public List<Lesson> getLessonList() {
    return lessons;
  }

  /**
   * To String function.
   *
   * @return string value
   */
  @Override
  public String toString() {
    return "Lessons{" +
        "lessons=" + lessons +
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
    Lessons lessons1 = (Lessons) o;
    return Objects.equals(lessons, lessons1.lessons);
  }

  /**
   * Default hashcode function.
   *
   * @return hash code ot the object
   */
  @Override
  public int hashCode() {
    return Objects.hash(lessons);
  }
}

