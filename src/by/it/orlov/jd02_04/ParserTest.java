package by.it.orlov.jd02_04;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    @Test
    public void calc() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.calc("A=2+5.3");
        assertEquals("7.3",actual.toString());
        actual = parser.calc("B=A*3.5");
        assertEquals("25.55",actual.toString());
        actual = parser.calc("C=B+(A*2)");
        assertEquals("40.15",actual.toString());
        actual = parser.calc("D=((C-0.15)-20)/(7-5)");
        assertEquals("10.0",actual.toString());
        actual = parser.calc("E={2,3}*(D/2)");
        assertEquals("{10.0, 15.0}",actual.toString());
    }
}