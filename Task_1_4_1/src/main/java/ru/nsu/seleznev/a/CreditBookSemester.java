package ru.nsu.seleznev.a;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Credit Book for each semester implementation.
 */
public class CreditBookSemester {
  private Map<String, Marks> marks = new HashMap<>();
  private int semesterNumber;

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
   * Function that add semester number used for output.
   *
   * @param semesterNumber the number of the semester
   */
  public void setSemesterNumber(int semesterNumber) {
    this.semesterNumber = semesterNumber;
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
  public Map<String, String> getMarks() {
    Map<String, String> allMarks = new HashMap<>();
    for(Map.Entry<String, Marks> entry : marks.entrySet()){
      allMarks.put(entry.getKey(),entry.getValue().getMark());
    }
    return allMarks;
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
      switch (i) {
        case EXCELLENT -> sumMarks += 5;
        case GOOD -> sumMarks += 4;
        case SATISFACTORY -> sumMarks += 3;
        case BAD -> sumMarks += 2;
        case GOODCREDIT, BADCREDIT -> credits += 1;
        default -> throw new IllegalStateException("Некорректная оценка");
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
        .filter(i -> (i.equals(Marks.GOOD)
            || i.equals(Marks.EXCELLENT)
            || i.equals(Marks.GOODCREDIT))).count() == marks.size();
  }

  /**
   * Function that checks high scholarship in this semester.
   *
   * @return true if student has high scholarship, false otherwise
   */
  public boolean getHighScholarship() {
    return marks.values().stream()
        .filter(i -> (i.equals(Marks.EXCELLENT)
            || i.equals(Marks.GOODCREDIT))).count() == marks.size();
  }

  /**
   * Function that checks bad marks in this semester.
   *
   * @return true is student has bad marks, false otherwise
   */
  public boolean consistsOfFail() {
    return marks.values().stream().anyMatch(i -> i.equals(Marks.SATISFACTORY)
        || i.equals(Marks.BAD)
        || i.equals(Marks.BADCREDIT));
  }

  @Override
  public String toString() {
    String table =
        "---------------------------------------\n"
            + "Семестр: " + semesterNumber + "\n"
            + "---------------------------------------\n"
            + "Оценки: " + getMarks() + "\n"
            + "---------------------------------------\n"
            + "Средняя оценкa за все предметы: " + getAverageMark() + "\n"
            + "---------------------------------------" + "\n";
    if (getHighScholarship()) {
      table += "С повышенной стипендией в семестре\n";
    } else if (getScholarship()) {
      table += "С обычной стипендией в семестре\n";
    } else {
      table += "Без стипендии в семестре\n";
    }
    table += "---------------------------------------" + "\n";
    return table;
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
