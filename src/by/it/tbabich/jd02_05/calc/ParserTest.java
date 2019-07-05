package by.it.tbabich.jd02_05.calc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    @Test
    public void calc() throws Exception {
        Parser parser = new Parser();

        //Scalar
        Var actual = parser.calc("A=2+5.3");
        assertEquals("7.3", actual.toString());
        actual = parser.calc("B=A*3.5");
        assertEquals("25.55", actual.toString());
        actual = parser.calc("B1=B+0.11*-5");
        assertEquals("25.0", actual.toString());
        actual = parser.calc("B2=A/2-1");
        assertEquals("2.65", actual.toString());

        //Hooks + Vector
        actual = parser.calc("C=B+(A*2)");
        assertEquals("40.15", actual.toString());
        actual = parser.calc("D=((C-0.15)-20)/(7-5)");
        assertEquals("10.0", actual.toString());
        actual = parser.calc("E={2,3}*(D/2)");
        assertEquals("{10.0, 15.0}", actual.toString());

        //Matrix
        actual = parser.calc("F={{2,3},{5,3}}*{{1,4},{-3,0}}");
        assertEquals("{{-7.0, 8.0}, {-4.0, 20.0}}", actual.toString());
        actual = parser.calc("G=F+{{5,7},{7,2}}");
        assertEquals("{{-2.0, 15.0}, {3.0, 22.0}}", actual.toString());
        actual = parser.calc("H=(G-F)*10");
        assertEquals("{{50.0, 70.0}, {70.0, 20.0}}", actual.toString());
    }

}