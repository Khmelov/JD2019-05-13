package by.it.dilkevich.calc;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void bracketsTest() throws CalcException, IOException {
        Parser parser = new Parser();
        Var actual = parser.calc("A=2+5.3");
        assertEquals("7.3",actual.toString());
        actual = parser.calc("B=A*3.5");
        assertEquals("25.55",actual.toString());
        actual = parser.calc("B2=A/2-1");
        assertEquals("2.65", actual.toString());

        actual = parser.calc("C=B+(A*2)");
        assertEquals("40.15", actual.toString());
        actual = parser.calc("D=((C-0.15)-20)/(7-5)");
        assertEquals("10.0", actual.toString());
        actual = parser.calc("E={2,3}*(D/2)");
        assertEquals("{10.0, 15.0}", actual.toString());
    }

    @Test
    public void vectorTest() throws CalcException, IOException {

        Parser parser = new Parser();
        Var actual = parser.calc("B={2,4,5,6}+{3,4,5,10}");
        assertEquals("{5.0, 8.0, 10.0, 16.0}", actual.toString());
        actual = parser.calc("A=({2,4,5,6}+{3,4,5,10})*{3,4,5,10}");
        assertEquals("257.0", actual.toString());
        actual = parser.calc("B-1257");
        assertEquals("{-1252.0, -1249.0, -1247.0, -1241.0}", actual.toString());
        actual = parser.calc("B/10");
        assertEquals("{0.5, 0.8, 1.0, 1.6}", actual.toString());
    }

    @Test
    public void matrixTest() throws CalcException, IOException {
        Parser parser = new Parser();

        Var actual = parser.calc("B={{2,434,5,6}, {3,4,5,1540}}+{{2,432,5,6}, {31,4,5,10}}+{{2,4,555,6}, {3,4,5,1065}}");
        assertEquals("{{6.0, 870.0, 565.0, 18.0}, {37.0, 12.0, 15.0, 2615.0}}",actual.toString());
        actual = parser.calc("B=B*3");
        assertEquals("{{18.0, 2610.0, 1695.0, 54.0}, {111.0, 36.0, 45.0, 7845.0}}",actual.toString());
        actual = parser.calc("{{18.0, 2610.0, 1695.0, 54.0}, {111.0, 36.0, 45.0, 7845.0}}-{{18.0, 2610.0, 1695.0, 54.0}, {111.0, 36.0, 45.0, 7845.0}}");
        assertEquals("{{0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0}}", actual.toString());
    }
}