package ru.nsu.seleznev.a;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Simple tests for Note class.
 */
public class NoteTest {
  @Test
  public void getTitleTest(){
    Note note = new Note("Тренировка","Тренировка в 18:30");
    String act = note.title();
    String exp = "Тренировка";
    Assertions.assertEquals(exp, act);
  }
  @Test
  public void getDescriptionTest(){
    Note note = new Note("Тренировка","Тренировка в 18:30");
    String act = note.description();
    String exp = "Тренировка в 18:30";
    Assertions.assertEquals(exp, act);
  }
  @Test
  public void equalsTest(){
    Note act = new Note("Тренировка","Тренировка в 10:30");
    Note exp = new Note("Тренировка","Тренировка в 10:30");
    Assertions.assertEquals(exp, act);
  }
}
