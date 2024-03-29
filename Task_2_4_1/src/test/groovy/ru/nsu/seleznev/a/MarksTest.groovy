package ru.nsu.seleznev.a

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.nsu.seleznev.a.model.Mark
import ru.nsu.seleznev.a.model.Marks
import ru.nsu.seleznev.a.parser.Parser

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MarksTest {
    @Test
    void markConfigurationTest() {
        Marks actualDsl = Parser.parseConfiguration(
                new File(getClass().getClassLoader().getResource("./Marks.groovy").toURI()),
                Marks
        ) as Marks
        Mark actualMark = actualDsl.getMarks().get(0)
        Mark expectedMark = new Mark(5, LocalDate.parse("17-05-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy")))
        Assertions.assertEquals(expectedMark, actualMark)
    }
}
