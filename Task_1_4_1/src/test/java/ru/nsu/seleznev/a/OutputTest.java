package ru.nsu.seleznev.a;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * Test with output for checking the student information.
 */
public class OutputTest {
  @Test
  public void getInformationTest() {
    Map<String, Marks> marks1 = new HashMap<>();
    marks1.put("Английский", Marks.EXCELLENT);
    marks1.put("ОСИ", Marks.GOOD);
    marks1.put("Тервер", Marks.BAD);
    marks1.put("Математический Анализ", Marks.GOOD);

    Map<String, Marks> marks2 = new HashMap<>();
    marks2.put("Линейная Алгебра", Marks.EXCELLENT);
    marks2.put("Физ-ра", Marks.EXCELLENT);
    marks2.put("Введение в ИИ", Marks.EXCELLENT);
    marks2.put("ООП", Marks.BAD);

    Map<String, Marks> marks3 = new HashMap<>();
    marks3.put("ПАК", Marks.BAD);
    marks3.put("Модели", Marks.BAD);
    marks3.put("Философия", Marks.EXCELLENT);
    marks3.put("Практика", Marks.GOOD);

    Map<String, Marks> marks4 = new HashMap<>();
    marks4.put("Дифференциальные уравнения", Marks.BAD);
    marks4.put("Математическая статистика", Marks.BAD);
    marks4.put("Квалификационная работа", Marks.EXCELLENT);
    marks4.put("Немецкий", Marks.GOOD);

    CreditBookSemester sem1Marks = new CreditBookSemester(marks1);
    CreditBookSemester sem2Marks = new CreditBookSemester(marks2);
    CreditBookSemester sem3Marks = new CreditBookSemester(marks3);
    CreditBookSemester sem4Marks = new CreditBookSemester(marks4);

    Map<Integer, CreditBookSemester> studentMarks = new HashMap<>();
    studentMarks.put(1, sem1Marks);
    studentMarks.put(2, sem2Marks);
    studentMarks.put(3, sem3Marks);
    studentMarks.put(4, sem4Marks);
    StudentData data = new StudentData(studentMarks, marks4);

    System.out.print(data);
    System.out.println();
    System.out.println("Оценки за 1 семестр (Тест CreditBook)");
    System.out.print(sem1Marks);
  }
}
