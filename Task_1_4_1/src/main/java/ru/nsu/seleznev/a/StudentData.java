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
  public StudentData(Map<Integer, CreditBookSemester> semesterMarks, Map<String, Marks> diplomaMarks) {
    this.semesterMarks = semesterMarks;
    this.diplomaMarks = diplomaMarks;
  }

  /**
   * Function that returns marks of semester user interested in.
   *
   * @param semester semester
   * @return Map String - String with name of the subject and its mark
   * @throws IllegalAccessException if user asks incorrect information
   */
  public Map<String, String> getSemesterMarks(int semester) throws IllegalAccessException {
    if (!semesterMarks.containsKey(semester)) {
      throw new IllegalAccessException("Нет такого семестра!");
    }
    Map<String, String> res = new HashMap<>();
    Map<String, Marks> data = semesterMarks.get(semester).getMarks();
    data.forEach((k, v) -> res.put(k, v.getMark()));
    return res;
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
      sem.getMarks().forEach((k, v) -> allMarks.put(k, v.getMark()));
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
   * false otherwise
   */
  public boolean getRedDiploma() {
    if (diplomaMarks.size() == 0) {
      throw new IllegalStateException("Нет дипломных предметов!");
    }
    if (!diplomaMarks.containsKey("Квалификационная работа")
        || !diplomaMarks.get("Квалификационная работа").getMark().equals("Отлично")) {
      return false;
    }
    Collection<CreditBookSemester> dataList = semesterMarks.values();
    for (var i : dataList) {
      if (i.consistsOfFail()) {
        return false;
      }
    }
    double percentages = (double) ((diplomaMarks.values().stream()
        .filter(i -> (i.getMark().equals("Отлично"))).count())) / diplomaMarks.size();
    return percentages > 0.75;
  }

  /**
   * Function that prints information of the student.
   *
   * @throws IllegalAccessException if user asks incorrect information
   */
  public void getInformation() throws IllegalAccessException {
    System.out.println("---------------------------------------");
    System.out.println("Текущий Студент");
    System.out.println("---------------------------------------");
    System.out.println("Оценки: " + this.getAllMarks());
    System.out.println("---------------------------------------");
    System.out.println("Средняя оценкa за все предметы: " + this.getAverageMark());
    System.out.println("---------------------------------------");
    System.out.println("Оценки за 1 семестр:" + this.getSemesterMarks(1));
    System.out.println("Средний балл: " + this.getAverageSemesterMark(1));
    if (this.getSemesterHighScholarship(1)) {
      System.out.println("С повышенной стипендией в 1 семестре");
    } else if (this.getSemesterScholarship(1)) {
      System.out.println("С обычной стипендией в 1 семестре");
    } else {
      System.out.println("Без стипендии в 1 семестре");
    }
    System.out.println("---------------------------------------");
    System.out.println("Оценки за 2 семестр:" + this.getSemesterMarks(2));
    System.out.println("Средний балл: " + this.getAverageSemesterMark(2));
    if (this.getSemesterHighScholarship(2)) {
      System.out.println("С повышенной стипендией во 2 семестре");
    } else if (this.getSemesterScholarship(2)) {
      System.out.println("С обычной стипендией во 2 семестре");
    } else {
      System.out.println("Без стипендии во 2 семестре");
    }
    System.out.println("---------------------------------------");
    System.out.println("Оценки за 3 семестр:" + this.getSemesterMarks(3));
    System.out.println("Средний балл: " + this.getAverageSemesterMark(3));
    if (this.getSemesterHighScholarship(3)) {
      System.out.println("С повышенной стипендией в 3 семестре");
    } else if (this.getSemesterScholarship(3)) {
      System.out.println("С обычной стипендией в 3 семестре");
    } else {
      System.out.println("Без стипендии в 3 семестре");
    }
    System.out.println("---------------------------------------");
    System.out.println("Оценки за 4 семестр:" + this.getSemesterMarks(4));
    System.out.println("Средний балл: " + this.getAverageSemesterMark(4));
    if (this.getSemesterHighScholarship(4)) {
      System.out.println("С повышенной стипендией в 4 семестре");
    } else if (this.getSemesterScholarship(4)) {
      System.out.println("С обычной стипендией в 4 семестре");
    } else {
      System.out.println("Без стипендии в 4 семестре");
    }
    System.out.println("---------------------------------------");
    System.out.println("Дипломные оценки: " + this.getDiplomaMarks());
    System.out.println("---------------------------------------");
    if (this.getRedDiploma()) {
      System.out.println("Идет на красный диплом!");
    } else {
      System.out.println("До красного диплома еще далеко!");
    }
    System.out.println("---------------------------------------");
  }

  /**
   * Function made for correct comparison of the objects.
   *
   * @param o object we need to compare with
   * @return true if objects are equals, false otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    StudentData that = (StudentData) o;
    return Objects.equals(semesterMarks, that.semesterMarks) && Objects.equals(diplomaMarks, that.diplomaMarks);
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
