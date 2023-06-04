package ru.nsu.seleznev.a

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.nsu.seleznev.a.model.GivenTask
import ru.nsu.seleznev.a.model.GivenTasks
import ru.nsu.seleznev.a.parser.Parser

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class GivenTaskClassTests {
    @Test
    void configurationTest() {
        GivenTasks actualTask = Parser.parseConfiguration(
                new File(getClass().getClassLoader().getResource("./GivenTask.groovy").toURI()),
                GivenTasks
        ) as GivenTasks

        GivenTask task = new GivenTask("Task_1_1_1",
                LocalDate.parse("17-05-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy")))
        List<GivenTask> tasks = new ArrayList<>()
        tasks.add(task)
        GivenTasks expectedTask = new GivenTasks(tasks)
        Assertions.assertEquals(expectedTask, actualTask)
    }
}
