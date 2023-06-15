package ru.nsu.seleznev.a

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.nsu.seleznev.a.model.Group
import ru.nsu.seleznev.a.parser.Parser

class GroupTest {
    @Test
    void groupConfigurationTest() {
        Group actualGroup = Parser.parseConfiguration(
                new File(getClass().getClassLoader().getResource("./Group.groovy").toURI()),
                Group) as Group

        Group expectedGroup = new Group(21215)
        Assertions.assertEquals(expectedGroup, actualGroup)
    }
}
