package ru.nsu.seleznev.a

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.nsu.seleznev.a.model.Lesson
import ru.nsu.seleznev.a.model.Lessons
import ru.nsu.seleznev.a.parser.Parser

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class LessonsTest {
    @Test
    void lessonConfigurationTest() {
        Lessons actualLessons = Parser.parseConfiguration(
                new File(getClass().getClassLoader().getResource("./Lesson.groovy").toURI()),
                Lessons) as Lessons
        List<Lesson> lessonList = new ArrayList<>()
        lessonList.add(new Lesson(LocalDate.parse("17-05-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy"))))
        Lessons expectedLessons = new Lessons(lessonList)
        Assertions.assertEquals(expectedLessons, actualLessons)
    }
}
