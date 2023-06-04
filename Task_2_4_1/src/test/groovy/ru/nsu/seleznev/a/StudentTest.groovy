package ru.nsu.seleznev.a

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.nsu.seleznev.a.model.Student
import ru.nsu.seleznev.a.parser.Parser

class StudentTest {
    @Test
    void configurationTest() {
        Student actualStudent = Parser.parseConfiguration(
                new File(getClass().getClassLoader().getResource("./Student.groovy").toURI()),
                Student
        ) as Student

        Student expectedStudent = new Student(123, "Dasha", "https://github.com/ploddasha/Plodushcheva_OOP.git".toURI())
        Assertions.assertEquals(expectedStudent, actualStudent)
    }
}
