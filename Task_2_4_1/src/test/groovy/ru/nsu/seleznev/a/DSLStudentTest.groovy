package ru.nsu.seleznev.a

import org.junit.jupiter.api.Test
import ru.nsu.seleznev.a.build.Builder
import ru.nsu.seleznev.a.git.GitApi
import ru.nsu.seleznev.a.model.GivenTask
import ru.nsu.seleznev.a.model.Student
import ru.nsu.seleznev.a.parser.Parser

class DSLStudentTest {
    @Test
    void DSLConfigurationTest() {
        DSL actualDSL = Parser.parseConfiguration(
                new File(getClass().getClassLoader().getResource("./DSLStudent.groovy").toURI()), DSL) as DSL
        Student student = actualDSL.getStudent()

        GitApi.cloneRepositoryDsl(student.getName(), student.getRepoURL())
        List<GivenTask> tasks = actualDSL.getGivenTasks().getTasks()
        for (task in tasks) {
            Builder.buildTests(student.getName(), task.getId())
            Builder.getJacocoTestReport(student.getName(), task.getId())
        }
    }
}
