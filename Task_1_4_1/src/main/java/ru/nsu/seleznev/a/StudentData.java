package ru.nsu.seleznev.a;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Student data implementation.
 * It consists of semester marks and diploma marks.
 */
public class StudentData {
  private Map<Integer, CreditBookSemester> semesterMarks = new HashMap<>();
  private Map<String, Marks> diplomaMarks = new HashMap<>();

  /**
   * Empty constructor made for tests.
   */
  public StudentData() {
  }

  /**
   * Student data constructor with semester marks.
   *
   * @param semesterMarks semester marks
   */
  public StudentData(Map<Integer, CreditBookSemester> semesterMarks) {
    this.semesterMarks = semesterMarks;
  }

  /**
   * Student data constructor with semester marks and diploma subjects.
   *
   * @param semesterMarks semester marks
   * @param diplomaMarks  diploma subjects
   */
  public StudentData(Map<Integer, CreditBookSemester> semesterMarks,
                     Map<String, Marks> diplomaMarks) {
    this.semesterMarks = semesterMarks;
    this.diplomaMarks = diplomaMarks;
    semesterMarks.forEach((k, v) -> v.setSemesterNumber(k));
  }

  /**
   * Function that return all marks of the student.
   *
   * @return Map String - String : name of the subject and its mark
   */
  public Map<String, String> getAllMarks() {
    Map<String, String> allMarks = new HashMap<>();
    Collection<CreditBookSemester> data = semesterMarks.values();
    for (CreditBookSemester sem : data) {
      allMarks.putAll(sem.getMarks());
    }
    return allMarks;
  }

  /**
   * Function that adds marks to the Credit book.
   *
   * @param data Map Integer - CreditBookSemester : semester and semester
   *             credit book with marks
   */
  public void addSemesterMarks(Map<Integer, CreditBookSemester> data) {
    semesterMarks.putAll(data);
  }

  /**
   * Function that adds diploma marks to the Credit book.
   *
   * @param subject subject need to add
   * @param mark    mark of the subject
   */
  public void addDiplomaSubject(String subject, Marks mark) {
    diplomaMarks.put(subject, mark);
  }

  /**
   * Function that removes diploma subject from the Credit book.
   *
   * @param subject subject we need to remove
   */
  public void removeDiplomaSubject(String subject) {
    diplomaMarks.remove(subject);
  }

  /**
   * Function that counts average mark of the semester.
   *
   * @param semester semester
   * @return double value - average mark
   * @throws IllegalAccessException if user asks incorrect information
   */
  public double getAverageSemesterMark(int semester) throws IllegalAccessException {
    if (!semesterMarks.containsKey(semester)) {
      throw new IllegalAccessException("Семестр указан некорректно!");
    }
    CreditBookSemester data = semesterMarks.get(semester);
    return data.getAverageMark();
  }

  /**
   * Function that counts the average mark of all semesters.
   *
   * @return double value - average mark
   */
  public double getAverageMark() {
    Collection<CreditBookSemester> data = semesterMarks.values();
    if (data.size() == 0) {
      throw new IllegalStateException("Зачетка пуста!");
    }
    double averageMark = 0;
    for (var i : data) {
      averageMark += i.getAverageMark();
    }
    return averageMark / data.size();
  }

  /**
   * Function that checks scholarship of student in the semester.
   *
   * @param semester semester
   * @return true if student has scholarship, false otherwise
   * @throws IllegalAccessException if user asks incorrect information
   */
  public boolean getSemesterScholarship(int semester) throws IllegalAccessException {
    if (!semesterMarks.containsKey(semester)) {
      throw new IllegalAccessException("Семестр указан некорректно!");
    }
    CreditBookSemester data = semesterMarks.get(semester);
    return data.getScholarship();
  }

  /**
   * Function that checks high scholarship of student in the semester.
   *
   * @param semester semester
   * @return true if student has high scholarship, false otherwise
   * @throws IllegalAccessException if user asks incorrect information
   */
  public boolean getSemesterHighScholarship(int semester) throws IllegalAccessException {
    if (!semesterMarks.containsKey(semester)) {
      throw new IllegalAccessException("Семестр указан некорректно!");
    }
    CreditBookSemester data = semesterMarks.get(semester);
    return data.getHighScholarship();
  }

  /**
   * Function that returns all diploma marks.
   *
   * @return Map String - String : subject and its mark
   */
  public Map<String, String> getDiplomaMarks() {
    Map<String, String> diploma = new HashMap<>();
    diplomaMarks.forEach((k, v) -> diploma.put(k, v.getMark()));
    return diploma;
  }

  /**
   * Function that checks the red diploma of the student.
   *
   * @return true if student will have red scholarship,
   *     false otherwise
   */
  public boolean getRedDiploma() {
    if (diplomaMarks.size() == 0) {
      throw new IllegalStateException("Нет дипломных предметов!");
    }
    if (!diplomaMarks.containsKey("Квалификационная работа")
        || !diplomaMarks.get("Квалификационная работа").equals(Marks.EXCELLENT)) {
      return false;
    }
    Collection<CreditBookSemester> dataList = semesterMarks.values();
    for (var i : dataList) {
      if (i.consistsOfFail()) {
        return false;
      }
    }
    double percentages = (double) ((diplomaMarks.values().stream()
        .filter(i -> (i.equals(Marks.EXCELLENT))).count())) / diplomaMarks.size();
    return percentages > 0.75;
  }

  /**
   * Function that prints information of the student.
   *
   * @return string that will be printed
   */
  @Override
  public String toString() {
    StringBuilder table = new StringBuilder
        ("---------------------------------------\n"
        + "Текущий Студент\n"
        + "---------------------------------------\n"
        + "Оценки: " + getAllMarks() + "\n"
        + "---------------------------------------\n"
        + "Средняя оценкa за все предметы: " + getAverageMark() + "\n"
        + "---------------------------------------" + "\n");
    for(var value : semesterMarks.values()){
      table.append(value.toString());
    }
    table.append("---------------------------------------\n" + "Дипломные оценки: ")
        .append(getDiplomaMarks()).append("\n")
        .append("---------------------------------------\n");
    if (getRedDiploma()) {
      table.append("Идет на красный диплом!\n");
    } else {
      table.append("До красного диплома еще далеко!\n");
    }
    table.append("---------------------------------------\n");
    return table.toString();
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
    StudentData that = (StudentData) o;
    return Objects.equals(semesterMarks, that.semesterMarks)
        && Objects.equals(diplomaMarks, that.diplomaMarks);
  }

  /**
   * Function that counts hash for correct comparison.
   *
   * @return int hash of the object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(semesterMarks, diplomaMarks);
  }
}
