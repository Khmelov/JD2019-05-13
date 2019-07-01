package by.it.akhmelev.calc19;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void calc() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.calc("A=2+5.3");
        assertEquals("7.3",actual.toString());
        actual = parser.calc("B=A*3.5");
        assertEquals("25.55",actual.toString());
    }
}