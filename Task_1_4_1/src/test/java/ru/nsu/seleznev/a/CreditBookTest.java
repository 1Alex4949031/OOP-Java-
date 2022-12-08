package ru.nsu.seleznev.a;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests of CreditBook class for checking the correctness of work.
 */
public class CreditBookTest {
  @Test
  public void complexTest() {
    Map<String, Marks> semesterMarks = new HashMap<>();
    semesterMarks.put("OSY", Marks.EXCELLENT);
    semesterMarks.put("Английский", Marks.EXCELLENT);
    semesterMarks.put("Введение в ИИ", Marks.EXCELLENT);
    semesterMarks.put("Квалификационная работа", Marks.EXCELLENT);

    CreditBookSemester data = new CreditBookSemester(semesterMarks);

    double expAveMark = 5.0;
    double actAveMark = data.getAverageMark();
    Assertions.assertEquals(expAveMark, actAveMark);

    boolean expSch = true;
    boolean actSch = data.getHighScholarship();
    Assertions.assertEquals(expSch, actSch);

    boolean expHighSch = true;
    boolean actHighSch = data.getHighScholarship();
    Assertions.assertEquals(expHighSch, actHighSch);

    boolean expFail = false;
    boolean actFail = data.consistsOfFail();
    Assertions.assertEquals(expFail, actFail);
  }

  @Test
  public void addMarksTest() {
    Map<String, Marks> semesterMarks1 = new HashMap<>();
    CreditBookSemester act = new CreditBookSemester(semesterMarks1);
    act.addMark("OSY", Marks.EXCELLENT);
    act.addMark("Английский", Marks.GOOD);
    act.addMark("Введение в ИИ", Marks.SATISFACTORY);
    act.addMark("Квалификационная работа", Marks.BADCREDIT);

    Map<String, Marks> semesterMarks2 = new HashMap<>();
    semesterMarks2.put("OSY", Marks.EXCELLENT);
    semesterMarks2.put("Английский", Marks.GOOD);
    semesterMarks2.put("Введение в ИИ", Marks.SATISFACTORY);
    semesterMarks2.put("Квалификационная работа", Marks.BADCREDIT);
    CreditBookSemester exp = new CreditBookSemester(semesterMarks2);

    Assertions.assertEquals(exp, act);
  }

  @Test
  public void addListOfMarksTest() {
    Map<String, Marks> semesterMarks1 = new HashMap<>();
    semesterMarks1.put("OSY", Marks.EXCELLENT);
    semesterMarks1.put("Английский", Marks.GOOD);
    semesterMarks1.put("Введение в ИИ", Marks.SATISFACTORY);
    semesterMarks1.put("Квалификационная работа", Marks.BADCREDIT);
    CreditBookSemester act = new CreditBookSemester();
    act.addListOfMarks(semesterMarks1);

    Map<String, Marks> semesterMarks2 = new HashMap<>();
    semesterMarks2.put("OSY", Marks.EXCELLENT);
    semesterMarks2.put("Английский", Marks.GOOD);
    semesterMarks2.put("Введение в ИИ", Marks.SATISFACTORY);
    semesterMarks2.put("Квалификационная работа", Marks.BADCREDIT);
    CreditBookSemester exp = new CreditBookSemester(semesterMarks2);

    Assertions.assertEquals(exp, act);
  }

  @Test
  public void getMarksTest() {
    Map<String, Marks> semesterMarks1 = new HashMap<>();
    semesterMarks1.put("OSY", Marks.EXCELLENT);
    semesterMarks1.put("Английский", Marks.EXCELLENT);
    semesterMarks1.put("Введение в ИИ", Marks.EXCELLENT);
    semesterMarks1.put("Квалификационная работа", Marks.EXCELLENT);
    CreditBookSemester marks = new CreditBookSemester(semesterMarks1);

    Map<String, String> exp = new HashMap<>();
    exp.put("OSY", Marks.EXCELLENT.getMark());
    exp.put("Английский", Marks.EXCELLENT.getMark());
    exp.put("Введение в ИИ", Marks.EXCELLENT.getMark());
    exp.put("Квалификационная работа", Marks.EXCELLENT.getMark());

    Map<String, String> act = marks.getMarks();
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void hashCodeTest() {
    Map<String, Marks> semesterMarks1 = new HashMap<>();
    semesterMarks1.put("OSY", Marks.EXCELLENT);
    semesterMarks1.put("Английский", Marks.EXCELLENT);
    semesterMarks1.put("Введение в ИИ", Marks.EXCELLENT);
    semesterMarks1.put("Квалификационная работа", Marks.EXCELLENT);

    Map<String, Marks> semesterMarks2 = new HashMap<>();
    semesterMarks2.put("OSY", Marks.EXCELLENT);
    semesterMarks2.put("Английский", Marks.EXCELLENT);
    semesterMarks2.put("Введение в ИИ", Marks.EXCELLENT);
    semesterMarks2.put("Квалификационная работа", Marks.EXCELLENT);
    CreditBookSemester exp = new CreditBookSemester(semesterMarks2);

    CreditBookSemester act = new CreditBookSemester(semesterMarks1);
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void getAverageMarkTest1() {
    Map<String, Marks> marks = new HashMap<>();
    marks.put("OSY", Marks.GOOD);
    marks.put("Английский", Marks.GOOD);
    marks.put("Введение в ИИ", Marks.GOOD);
    marks.put("Квалификационная работа", Marks.GOOD);

    CreditBookSemester data = new CreditBookSemester(marks);

    double act = data.getAverageMark();
    double exp = 4.0;
    Assertions.assertEquals(exp, act);
  }

  @Test
  public void getAverageMarkTest2() {
    Map<String, Marks> marks = new HashMap<>();
    marks.put("Русский", Marks.EXCELLENT);
    marks.put("Пак", Marks.EXCELLENT);
    marks.put("Введение в ИИ", Marks.EXCELLENT);
    marks.put("Модели вычивлений", Marks.EXCELLENT);

    CreditBookSemester data = new CreditBookSemester(marks);

    double actSem1 = data.getAverageMark();
    double expSem1 = 5.0;
    Assertions.assertEquals(expSem1, actSem1);
  }

  @Test
  public void getAverageMarkTest3() {
    Map<String, Marks> marks = new HashMap<>();
    marks.put("Русский", Marks.BAD);
    marks.put("Пак", Marks.EXCELLENT);
    marks.put("Введение в ИИ", Marks.GOOD);
    marks.put("Модели вычивлений", Marks.GOOD);

    CreditBookSemester data = new CreditBookSemester(marks);

    double act = data.getAverageMark();
    double exp = 3.75;
    Assertions.assertEquals(exp, act);
  }
}
