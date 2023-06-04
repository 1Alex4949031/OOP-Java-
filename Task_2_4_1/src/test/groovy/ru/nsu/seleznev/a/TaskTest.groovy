package ru.nsu.seleznev.a

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.nsu.seleznev.a.model.Task
import ru.nsu.seleznev.a.parser.Parser

class TaskTest {
    @Test
    void TaskConfigurationTest() {
        Task actualTask = Parser.parseConfiguration(
                new File(getClass().getClassLoader().getResource("./Task.groovy").toURI()),
                Task
        ) as Task

        Task expectedTask = new Task(1, "Task_1_1_1", 10);

        Assertions.assertEquals(expectedTask, actualTask)
    }
}
