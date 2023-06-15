package ru.nsu.seleznev.a

import org.junit.jupiter.api.Test
import ru.nsu.seleznev.a.parser.Parser

class DSLTest {
    @Test
    void DSLConfigurationTest() {
        DSL actualDsl = Parser.parseConfiguration(
                new File(getClass().getClassLoader().getResource("./DSL.groovy").toURI()), DSL) as DSL
        println(actualDsl)
    }
}
