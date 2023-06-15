package ru.nsu.seleznev.a

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.nsu.seleznev.a.model.Lesson
import ru.nsu.seleznev.a.model.Lessons
import ru.nsu.seleznev.a.model.Task
import ru.nsu.seleznev.a.model.Tasks
import ru.nsu.seleznev.a.parser.Parser

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class TasksTest {
    @Test
    void lessonConfigurationTest() {
        Tasks actualTasks = Parser.parseConfiguration(
                new File(getClass().getClassLoader().getResource("./Tasks.groovy").toURI()),
                Tasks) as Tasks
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("1", "Task_1_1_1", 10))
        Tasks expectedTasks = new Tasks(tasks)
        Assertions.assertEquals(expectedTasks, actualTasks)
    }
}
