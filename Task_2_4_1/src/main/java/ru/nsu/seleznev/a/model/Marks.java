package ru.nsu.seleznev.a.model;

import groovy.lang.Closure;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import ru.nsu.seleznev.a.strings.MarkString;


/**
 * Marks class.
 */
public class Marks {
  private final List<Mark> marks = new ArrayList<>();

  /**
   * Empty constructor.
   */
  public Marks() {
  }

  /**
   * Function that returns all marks.
   *
   * @return marks list
   */
  public List<Mark> getMarks() {
    return marks;
  }

  /**
   * Mark closure for dsl.
   *
   * @param closure block of code with important values
   */
  public void mark(Closure<?> closure) {
    MarkString markString = new MarkString();
    closure.setDelegate(markString);
    closure.setResolveStrategy(Closure.DELEGATE_ONLY);
    closure.call();
    marks.add(new Mark(
        Integer.parseInt(markString.getMark()),
        LocalDate.parse(markString.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
  }

  /**
   * To String function.
   *
   * @return string value
   */
  @Override
  public String toString() {
    return "Marks{" + "marks=" + marks + '}';
  }

  /**
   * Default equals function.
   *
   * @param o object need to compare with.
   * @return true if objects are equals, false otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Marks marks1 = (Marks) o;
    return Objects.equals(marks, marks1.marks);
  }

  /**
   * Default hashcode function.
   *
   * @return hash code ot the object
   */
  @Override
  public int hashCode() {
    return Objects.hash(marks);
  }
}
