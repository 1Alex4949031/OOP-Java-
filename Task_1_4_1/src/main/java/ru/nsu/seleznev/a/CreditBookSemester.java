package ru.nsu.seleznev.a;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Credit Book for each semester implementation.
 */
public class CreditBookSemester {
  private Map<String, Marks> marks = new HashMap<>();

  /**
   * Empty constructor made for tests
   * (add and remove functions).
   */
  public CreditBookSemester() {
  }

  /**
   * Constructor for Credit book.
   *
   * @param marks marks
   */
  public CreditBookSemester(Map<String, Marks> marks) {
    this.marks = marks;
  }

  /**
   * Function that adds mark to the semester marks.
   *
   * @param subject subject where we need to add mark
   * @param mark    marks of the known subject
   */
  public void addMark(String subject, Marks mark) {
    marks.put(subject, mark);
  }

  /**
   * Function that adds a list of marks to the current semester.
   *
   * @param listOfMarks list of marks we need to add
   */
  public void addListOfMarks(Map<String, Marks> listOfMarks) {
    marks.putAll(listOfMarks);
  }

  /**
   * Function that returns all marks of the semester.
   *
   * @return Map String - Marks(enum) of marks
   */
  public Map<String, Marks> getMarks() {
    return this.marks;
  }

  /**
   * Function that returns the average marks of the semester.
   *
   * @return double average mark
   */
  public double getAverageMark() {
    if (marks.size() == 0) {
      throw new IllegalStateException("Нет предметов в зачетке!");
    }
    double sumMarks = 0;
    int credits = 0;
    for (Marks i : marks.values()) {
      switch (i.getMark()) {
        case ("Отлично"):
          sumMarks += 5;
          break;
        case ("Хорошо"):
          sumMarks += 4;
          break;
        case ("Удовлетворительно"):
          sumMarks += 3;
          break;
        case ("Неудовлетворительно"):
          sumMarks += 2;
          break;
        case ("Зачет"):
        case ("Незачет"):
          credits += 1;
          break;
        default:
          break;
      }
    }
    return sumMarks / (marks.size() - credits);
  }

  /**
   * Function that checks scholarship in this semester.
   *
   * @return true if student have scholarship, false otherwise
   */
  public boolean getScholarship() {
    return marks.values().stream()
        .filter(i -> (i.getMark().equals("Хорошо")
            || i.getMark().equals("Отлично")
            || i.getMark().equals("Зачет"))).count() == marks.size();
  }

  /**
   * Function that checks high scholarship in this semester.
   *
   * @return true if student has high scholarship, false otherwise
   */
  public boolean getHighScholarship() {
    return marks.values().stream()
        .filter(i -> (i.getMark().equals("Отлично")
            || i.getMark().equals("Зачет"))).count() == marks.size();
  }

  /**
   * Function that checks bad marks in this semester.
   *
   * @return true is student has bad marks, false otherwise
   */
  public boolean consistsOfFail() {
    return marks.values().stream().anyMatch(i -> i.getMark().equals("Удовлетворительно")
        || i.getMark().equals("Неудовлетворительно")
        || i.getMark().equals("Незачет"));
  }

  /**
   * Function made for correct comparison of the objects.
   *
   * @param o object we need to compare with
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
    CreditBookSemester that = (CreditBookSemester) o;
    return marks.equals(that.marks);
  }

  /**
   * Function that counts hash for correct comparison.
   *
   * @return int hash of the object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(marks);
  }
}
