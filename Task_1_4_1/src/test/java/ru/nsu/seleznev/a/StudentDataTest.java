package ru.nsu.seleznev.a;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests of StudentData class for checking the correctness of work.
 */
public class StudentDataTest {
  @Test
  public void complexTest() throws IllegalAccessException {
    Map<String, Marks> allMarks = new HashMap<>();
    allMarks.put("OSY", Marks.GOOD);
    allMarks.put("Английский", Marks.EXCELLENT);
    allMarks.put("Введение в ИИ", Marks.GOOD);
    allMarks.put("Квалификационная работа", Marks.EXCELLENT);

    CreditBookSemester creditMarks = new CreditBookSemester(allMarks);
    Map<Integer, CreditBookSemester> studentMarks = new HashMap<>();
    studentMarks.put(1, creditMarks);
    StudentData data = new StudentData(studentMarks, allMarks);

    double actAveMark = data.getAverageMark();
    double expAveMark = 4.5;
    Assertions.assertEquals(expAveMark, actAveMark);

    double actAveSemMark = data.getAverageSemesterMark(1);
    double expAveSemMark = 4.5;
    Assertions.assertEquals(expAveSemMark, actAveSemMark);

    boolean actSch = data.getSemesterScholarship(1);
    boolean expSch = true;
    Assertions.assertEquals(expSch, actSch);

    boolean actHighSch = data.getSemesterHighScholarship(1);
    boolean expHighSch = false;
    Assertions.assertEquals(expHighSch, actHighSch);
  }

  @Test
  public void getDiplomaMarksTest() {
    Map<String, Marks> creditMarks = new HashMap<>();
    creditMarks.put("OSY", Marks.GOOD);
    creditMarks.put("Английский", Marks.EXCELLENT);
    creditMarks.put("Введение в ИИ", Marks.GOOD);
    creditMarks.put("Квалификационная работа", Marks.EXCELLENT);

    Map<String, Marks> diplomaMarks = new HashMap<>();
    diplomaMarks.put("OSY", Marks.GOOD);
    diplomaMarks.put("Английский", Marks.EXCELLENT);
    diplomaMarks.put("Введение в ИИ", Marks.GOOD);

    Map<Integer, CreditBookSemester> semesterMarks = new HashMap<>();
    CreditBookSemester credit = new CreditBookSemester(creditMarks);
    semesterMarks.put(1, credit);

    Map<String, String> expDipMarks = new HashMap<>();
    expDipMarks.put("OSY", Marks.GOOD.getMark());
    expDipMarks.put("Английский", Marks.EXCELLENT.getMark());
    expDipMarks.put("Введение в ИИ", Marks.GOOD.getMark());

    StudentData data = new StudentData(semesterMarks, diplomaMarks);
    Map<String, String> actDipMarks = data.getDiplomaMarks();
    Assertions.assertEquals(expDipMarks, actDipMarks);
  }

  @Test
  public void addDiplomaSubjectTest() {
    Map<String, Marks> allMarks = new HashMap<>();
    allMarks.put("OSY", Marks.EXCELLENT);
    allMarks.put("Английский", Marks.EXCELLENT);
    allMarks.put("Введение в ИИ", Marks.EXCELLENT);
    allMarks.put("Квалификационная работа", Marks.EXCELLENT);

    Map<Integer, CreditBookSemester> semesterMarks = new HashMap<>();
    CreditBookSemester credit = new CreditBookSemester(allMarks);
    semesterMarks.put(1, credit);

    Map<String, String> exp = new HashMap<>();
    exp.put("OSY", Marks.EXCELLENT.getMark());
    exp.put("Английский", Marks.EXCELLENT.getMark());
    exp.put("Введение в ИИ", Marks.EXCELLENT.getMark());
    exp.put("Квалификационная работа", Marks.EXCELLENT.getMark());
    exp.put("Немецкий", Marks.SATISFACTORY.getMark());

    StudentData data = new StudentData(semesterMarks, allMarks);
    data.addDiplomaSubject("Немецкий", Marks.SATISFACTORY);
    Map<String, String> act = data.getDiplomaMarks();
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void removeDiplomaSubjectTest() {
    Map<String, Marks> allMarks = new HashMap<>();
    allMarks.put("OSY", Marks.EXCELLENT);
    allMarks.put("Английский", Marks.EXCELLENT);
    allMarks.put("Введение в ИИ", Marks.EXCELLENT);
    allMarks.put("Квалификационная работа", Marks.EXCELLENT);

    Map<Integer, CreditBookSemester> semesterMarks = new HashMap<>();
    CreditBookSemester credit = new CreditBookSemester(allMarks);
    semesterMarks.put(1, credit);

    Map<String, String> exp = new HashMap<>();
    exp.put("Английский", Marks.EXCELLENT.getMark());
    exp.put("Введение в ИИ", Marks.EXCELLENT.getMark());
    exp.put("Квалификационная работа", Marks.EXCELLENT.getMark());

    StudentData data = new StudentData(semesterMarks, allMarks);
    data.removeDiplomaSubject("OSY");
    Map<String, String> act = data.getDiplomaMarks();
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void addSemesterSubjectsTest() {
    Map<String, Marks> allMarks = new HashMap<>();
    allMarks.put("OSY", Marks.EXCELLENT);
    allMarks.put("Английский", Marks.EXCELLENT);
    allMarks.put("Введение в ИИ", Marks.EXCELLENT);
    allMarks.put("Квалификационная работа", Marks.EXCELLENT);

    Map<Integer, CreditBookSemester> semesterMarks = new HashMap<>();
    CreditBookSemester credit = new CreditBookSemester(allMarks);
    semesterMarks.put(1, credit);
    StudentData act = new StudentData();
    act.addSemesterMarks(semesterMarks);

    Map<String, Marks> expMarks = new HashMap<>();
    expMarks.put("OSY", Marks.EXCELLENT);
    expMarks.put("Английский", Marks.EXCELLENT);
    expMarks.put("Введение в ИИ", Marks.EXCELLENT);
    expMarks.put("Квалификационная работа", Marks.EXCELLENT);

    Map<Integer, CreditBookSemester> expSemesterMarks = new HashMap<>();
    CreditBookSemester expCredit = new CreditBookSemester(expMarks);
    expSemesterMarks.put(1, expCredit);
    StudentData exp = new StudentData(expSemesterMarks);

    Assertions.assertEquals(exp, act);
  }

  @Test
  public void getRedDiplomaTestTrue() {
    Map<String, Marks> allMarks = new HashMap<>();
    allMarks.put("OSY", Marks.EXCELLENT);
    allMarks.put("Английский", Marks.EXCELLENT);
    allMarks.put("Введение в ИИ", Marks.EXCELLENT);
    allMarks.put("Квалификационная работа", Marks.EXCELLENT);

    Map<Integer, CreditBookSemester> semesterMarks = new HashMap<>();
    CreditBookSemester credit = new CreditBookSemester(allMarks);
    semesterMarks.put(1, credit);

    StudentData data = new StudentData(semesterMarks, allMarks);

    boolean act = data.getRedDiploma();
    boolean exp = true;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void getRedDiplomaTestFalse() {
    Map<String, Marks> allMarks = new HashMap<>();
    allMarks.put("OSY", Marks.EXCELLENT);
    allMarks.put("Английский", Marks.BAD);
    allMarks.put("Введение в ИИ", Marks.EXCELLENT);
    allMarks.put("Квалификационная работа", Marks.EXCELLENT);

    Map<Integer, CreditBookSemester> semesterMarks = new HashMap<>();
    CreditBookSemester credit = new CreditBookSemester(allMarks);
    semesterMarks.put(1, credit);

    StudentData data = new StudentData(semesterMarks, allMarks);

    boolean act = data.getRedDiploma();
    boolean exp = false;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void getRedDiplomaComplexTest() {
    Map<String, Marks> allMarks = new HashMap<>();
    allMarks.put("OSY", Marks.EXCELLENT);
    allMarks.put("Английский", Marks.EXCELLENT);
    allMarks.put("Введение в ИИ", Marks.EXCELLENT);

    Map<Integer, CreditBookSemester> semesterMarks = new HashMap<>();
    CreditBookSemester credit = new CreditBookSemester(allMarks);
    semesterMarks.put(1, credit);

    StudentData data = new StudentData(semesterMarks, allMarks);

    boolean actWithoutWork = data.getRedDiploma();
    boolean expWithoutWork = false;
    Assertions.assertEquals(expWithoutWork, actWithoutWork);

    data.addDiplomaSubject("Квалификационная работа", Marks.EXCELLENT);
    boolean actWithWork = data.getRedDiploma();
    boolean expWithWork = true;
    Assertions.assertEquals(expWithWork, actWithWork);

    data.addDiplomaSubject("Квалификационная работа", Marks.BAD);
    boolean actBadWork = data.getRedDiploma();
    boolean expBadWork = false;
    Assertions.assertEquals(expBadWork, actBadWork);

    data.addDiplomaSubject("Русский", Marks.BAD);
    boolean actBadMark = data.getRedDiploma();
    boolean expBadMark = false;
    Assertions.assertEquals(expBadMark, actBadMark);

    data.removeDiplomaSubject("Русский");
    data.addDiplomaSubject("Немецкий", Marks.BADCREDIT);
    boolean actBadCredit = data.getRedDiploma();
    boolean expBadCredit = false;
    Assertions.assertEquals(expBadCredit, actBadCredit);
  }

  @Test
  public void getAverageMarkTest() throws IllegalAccessException {
    Map<String, Marks> marks1 = new HashMap<>();
    marks1.put("OSY", Marks.GOOD);
    marks1.put("Английский", Marks.GOOD);
    marks1.put("Введение в ИИ", Marks.GOOD);
    marks1.put("Квалификационная работа", Marks.GOOD);

    Map<String, Marks> marks2 = new HashMap<>();
    marks2.put("Русский", Marks.EXCELLENT);
    marks2.put("Пак", Marks.EXCELLENT);
    marks2.put("Введение в ИИ", Marks.EXCELLENT);
    marks2.put("Модели вычивлений", Marks.EXCELLENT);

    CreditBookSemester sem1Marks = new CreditBookSemester(marks1);
    CreditBookSemester sem2Marks = new CreditBookSemester(marks2);

    Map<Integer, CreditBookSemester> studentMarks = new HashMap<>();
    studentMarks.put(1, sem1Marks);
    studentMarks.put(2, sem2Marks);
    StudentData data = new StudentData(studentMarks, marks1);

    double actSem1 = data.getAverageSemesterMark(1);
    double expSem1 = 4.0;
    Assertions.assertEquals(expSem1, actSem1);

    double actSem2 = data.getAverageSemesterMark(2);
    double expSem2 = 5.0;
    Assertions.assertEquals(expSem2, actSem2);

    double actAverageMark = data.getAverageMark();
    double expAverageMark = 4.5;
    Assertions.assertEquals(expAverageMark, actAverageMark);
  }

  @Test
  public void getAverageMarkComplexTest() {
    Map<String, Marks> marks1 = new HashMap<>();
    marks1.put("1", Marks.EXCELLENT);
    marks1.put("2", Marks.GOOD);
    marks1.put("3", Marks.BAD);
    marks1.put("4", Marks.GOOD);

    Map<String, Marks> marks2 = new HashMap<>();
    marks2.put("5", Marks.EXCELLENT);
    marks2.put("6", Marks.EXCELLENT);
    marks2.put("7", Marks.EXCELLENT);
    marks2.put("8", Marks.BAD);

    Map<String, Marks> marks3 = new HashMap<>();
    marks3.put("9", Marks.BAD);
    marks3.put("10", Marks.BAD);
    marks3.put("11", Marks.EXCELLENT);
    marks3.put("12", Marks.GOOD);

    Map<String, Marks> marks4 = new HashMap<>();
    marks4.put("13", Marks.BAD);
    marks4.put("14", Marks.BAD);
    marks4.put("15", Marks.EXCELLENT);
    marks4.put("16", Marks.GOOD);

    CreditBookSemester sem1Marks = new CreditBookSemester(marks1);
    CreditBookSemester sem2Marks = new CreditBookSemester(marks2);
    CreditBookSemester sem3Marks = new CreditBookSemester(marks3);
    CreditBookSemester sem4Marks = new CreditBookSemester(marks4);

    Map<Integer, CreditBookSemester> studentMarks = new HashMap<>();
    studentMarks.put(1, sem1Marks);
    studentMarks.put(2, sem2Marks);
    studentMarks.put(3, sem3Marks);
    studentMarks.put(4, sem4Marks);
    StudentData data = new StudentData(studentMarks);

    double act = data.getAverageMark();
    double exp = 3.625;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void hashCodeTest() {
    Map<String, Marks> marks1 = new HashMap<>();
    marks1.put("OSY", Marks.GOOD);
    marks1.put("Английский", Marks.GOOD);
    marks1.put("Введение в ИИ", Marks.GOOD);
    marks1.put("Квалификационная работа", Marks.GOOD);

    Map<String, Marks> marks2 = new HashMap<>();
    marks2.put("OSY", Marks.GOOD);
    marks2.put("Английский", Marks.GOOD);
    marks2.put("Введение в ИИ", Marks.GOOD);
    marks2.put("Квалификационная работа", Marks.GOOD);

    CreditBookSemester creditBookFirst = new CreditBookSemester(marks1);
    Map<Integer, CreditBookSemester> studentMarksF = new HashMap<>();
    studentMarksF.put(1, creditBookFirst);
    StudentData act = new StudentData(studentMarksF, marks1);

    CreditBookSemester creditBookSec = new CreditBookSemester(marks2);
    Map<Integer, CreditBookSemester> studentMarksS = new HashMap<>();
    studentMarksS.put(1, creditBookSec);
    StudentData exp = new StudentData(studentMarksS, marks1);

    Assertions.assertEquals(exp, act);
  }
}
