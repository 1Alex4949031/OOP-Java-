package ru.nsu.seleznev.a

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.nsu.seleznev.a.model.Lesson
import ru.nsu.seleznev.a.parser.Parser

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class LessonTest {
    @Test
    void lessonConfigurationTest() {
        Lesson actualLesson = Parser.parseConfiguration(
                new File(getClass().getClassLoader().getResource("./Lesson.groovy").toURI()),
                Lesson) as Lesson
        Lesson expectedLesson = new Lesson(LocalDate.parse("17-05-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy")))
        Assertions.assertEquals(expectedLesson, actualLesson)
    }
}
