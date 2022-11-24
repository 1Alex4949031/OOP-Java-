package ru.nsu.seleznev.a;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests implementation of enum Marks
 * for checking the correctness of work.
 */
public class MarksTest {
  @Test
  public  void allUnitsTest(){
    Marks markExc = Marks.EXCELLENT;
    String actExc = markExc.getMark();
    String expExc = "Отлично";
    Assertions.assertEquals(expExc, actExc);

    Marks marksGood = Marks.GOOD;
    String actGood = marksGood.getMark();
    String expGood = "Хорошо";
    Assertions.assertEquals(expGood, actGood);

    Marks marksSat = Marks.SATISFACTORY;
    String actSat = marksSat.getMark();
    String expSat = "Удовлетворительно";
    Assertions.assertEquals(expSat, actSat);

    Marks marksBad = Marks.BAD;
    String actBad = marksBad.getMark();
    String expBad = "Неудовлетворительно";
    Assertions.assertEquals(expBad, actBad);

    Marks marksGoodCredit = Marks.GOODCREDIT;
    String actGoodCredit = marksGoodCredit.getMark();
    String expGoodCredit = "Зачет";
    Assertions.assertEquals(expGoodCredit, actGoodCredit);

    Marks marksBadCredit = Marks.BADCREDIT;
    String actBadCredit = marksBadCredit.getMark();
    String expBadCredit = "Незачет";
    Assertions.assertEquals(expBadCredit, actBadCredit);
  }
}
