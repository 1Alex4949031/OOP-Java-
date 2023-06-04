package ru.nsu.seleznev.a.model;

import groovy.lang.Closure;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import ru.nsu.seleznev.a.strings.MarkString;



public class Marks {
  private final List<Mark> marks = new ArrayList<>();

  public Marks() {
  }

  public List<Mark> getMarks() {
    return marks;
  }

  public void mark(Closure<?> closure) {
    MarkString markString = new MarkString();
    closure.setDelegate(markString);
    closure.setResolveStrategy(Closure.DELEGATE_ONLY);
    closure.call();
    marks.add(new Mark(
        Integer.parseInt(markString.getMark()),
        LocalDate.parse(markString.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
  }

  @Override
  public String toString() {
    return "Marks{" +
        "marks=" + marks +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Marks marks1 = (Marks) o;
    return Objects.equals(marks, marks1.marks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(marks);
  }
}
