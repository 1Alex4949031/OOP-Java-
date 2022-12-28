package ru.nsu.seleznev.a;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test for NoteBook class implementation.
 * Initially it is assumed that JSON file isn't created.
 * Each test creates own notes. It means that all test are independent of each other.
 */
public class NoteBookTest {
  @Test
  public void addTest() throws NoSuchFieldException, IllegalAccessException {
    NoteBook.main(new String[]{"-add", "Тренировка Вечер", "Тренировка в 18:30-20:30"});
    NoteBook.main(new String[]{"-add", "Учеба", "Учеба 9:00-18:05"});
    NoteBook.main(new String[]{"-add", "Работа", "Работа 20:35-8:30"});
    var noteBookMap = NoteBook.class.getDeclaredField("noteBook");
    noteBookMap.setAccessible(true);
    @SuppressWarnings("unchecked")
    Map<LocalDateTime, Note> notes = (Map<LocalDateTime, Note>) noteBookMap.get(noteBookMap);
    Assertions.assertTrue(notes.containsValue(
        new Note("Тренировка Вечер", "Тренировка в 18:30-20:30")));
    Assertions.assertTrue(notes.containsValue(
        new Note("Учеба", "Учеба 9:00-18:05")));
    Assertions.assertTrue(notes.containsValue(
        new Note("Работа", "Работа 20:35-8:30")));
    File file = new File("NoteBook.json");
    if (file.exists() && !file.delete()) {
      throw new RuntimeException("Unable to delete file");
    }
  }

  @Test
  public void removeTest() throws NoSuchFieldException, IllegalAccessException {
    NoteBook.main(new String[]{"-add", "Тренировка Весь День", "Тренировка в 10:30-20:30"});
    NoteBook.main(new String[]{"-add", "Занятие по Мат.Анализу", "Занятие в 16:30-18:30"});
    NoteBook.main(new String[]{"-remove", "Тренировка Весь День"});
    var noteBookMap = NoteBook.class.getDeclaredField("noteBook");
    noteBookMap.setAccessible(true);
    @SuppressWarnings("unchecked")
    Map<LocalDateTime, Note> notes = (Map<LocalDateTime, Note>) noteBookMap.get(noteBookMap);
    Assertions.assertTrue(notes.containsValue(
        new Note("Занятие по Мат.Анализу", "Занятие в 16:30-18:30")));
    Assertions.assertFalse(notes.containsValue(
        new Note("Тренировка Весь День", "Тренировка в 10:30-20:30")));
    File file = new File("NoteBook.json");
    if (file.exists() && !file.delete()) {
      throw new RuntimeException("Unable to delete file");
    }
  }

  @Test
  public void numberNotesTest() throws NoSuchFieldException, IllegalAccessException {
    NoteBook.main(new String[]{"-add", "1", "1"});
    NoteBook.main(new String[]{"-add", "1", "2"});
    NoteBook.main(new String[]{"-add", "2", "2"});
    NoteBook.main(new String[]{"-add", "3", "3"});
    NoteBook.main(new String[]{"-add", "4", "4"});
    NoteBook.main(new String[]{"-add", "5", "5"});
    NoteBook.main(new String[]{"-add", "6", "6"});
    NoteBook.main(new String[]{"-remove", "4"});
    NoteBook.main(new String[]{"-remove", "1"});
    NoteBook.main(new String[]{"-remove", "3"});
    var noteBookMap = NoteBook.class.getDeclaredField("noteBook");
    noteBookMap.setAccessible(true);
    @SuppressWarnings("unchecked")
    Map<LocalDateTime, Note> notes = (Map<LocalDateTime, Note>) noteBookMap.get(noteBookMap);
    int exp = 4;
    int act = notes.size();
    Assertions.assertEquals(exp, act);
    File file = new File("NoteBook.json");
    if (file.exists() && !file.delete()) {
      throw new RuntimeException("Unable to delete file");
    }
  }
}
