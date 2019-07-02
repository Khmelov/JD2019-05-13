package by.it.adamovichjr.calc;

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
        actual = parser.calc("B1=B+0.11*-5");
        assertEquals("25.0",actual.toString());
        actual = parser.calc("B2=A/2-1");
        assertEquals("2.65",actual.toString());
        //Тест для вектора
        actual = parser.calc("A={1, 1, 1} +2");
        assertEquals("{3.0, 3.0, 3.0}",actual.toString());
        actual = parser.calc("B=((A+2)+(4+6))/3");
        assertEquals("{5.0, 5.0, 5.0}",actual.toString());
        actual = parser.calc("C=(B-A)*2");
        assertEquals("{4.0, 4.0, 4.0}",actual.toString());
        //Тест для марицы
        actual = parser.calc("A=({{1, 1, 1}{1,1,1}} +{{-2, 0, -2}{-2, 0, -2}})* {{2,2}{2,2}{2,2}}");
        assertEquals("{{-2.0, -2.0}, {-2.0, -2.0}}",actual.toString());
        actual = parser.calc("B={{1,-1}{1,-1}}*{1,2}+5");
        assertEquals("{4.0, 4.0}",actual.toString());
        actual = parser.calc("C=A*B-B");
        assertEquals("{-20.0, -20.0}",actual.toString());
        actual = parser.calc("D=A/(2+3)");
        assertEquals("{{-0.4, -0.4}, {-0.4, -0.4}}",actual.toString());
    }
}
