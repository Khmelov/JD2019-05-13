package by.it.yakovets.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {
    private Parser parser = new Parser();
    Var actual;

    @Test
    public void addScalar() throws CalcException {
        actual = parser.calc("2+5.3");
        assertEquals("7.3", actual.toString());
    }

    @Test
    public void subScalar() throws CalcException {
        actual = parser.calc("19.7-3.5");
        assertEquals( "16.2", actual.toString());
    }

    @Test
    public void mulScalar() throws CalcException {
        actual = parser.calc("13.2*2.7");
        assertEquals("35.64",actual.toString());
    }

    @Test
    public void divScalar() throws CalcException {
        actual = parser.calc("8/2");
        assertEquals("4.0",actual.toString());

    }

    @Test
    public void addVector() throws CalcException {
        actual = parser.calc("{1,2}+{2,4}");
        assertEquals("{3.0, 6.0}",actual.toString());
    }

    @Test
    public void subVector() throws CalcException {
        actual = parser.calc("{3,5}-{2,4}");
        assertEquals("{1.0, 1.0}",actual.toString());
    }

    @Test
    public void mulVector() throws CalcException {
        actual = parser.calc("{1,2}*{2,4}");
        assertEquals("10.0",actual.toString());
    }

    @Test
    public void divVector() throws CalcException {
        actual = parser.calc("{10,6}/2");
        assertEquals("{5.0, 3.0}",actual.toString());
    }

    @Test
    public void addMatrix() throws CalcException {
        actual = parser.calc("{{1,2},{3,4}}+{{7,6},{9,10}}");
        assertEquals("{{8.0, 8.0}, {12.0, 14.0}}",actual.toString());
    }

    @Test
    public void subMatrix() throws CalcException {
        actual = parser.calc("{{1,2},{3,4}}-{{7,6},{9,10}}");
        assertEquals("{{-6.0, -4.0}, {-6.0, -6.0}}",actual.toString());
    }

    @Test
    public void mulMatrix() throws CalcException {
        actual = parser.calc("{{1,2},{3,4}}*{{7,6},{9,10}}");
        assertEquals("{{25.0, 26.0}, {57.0, 58.0}}",actual.toString());
    }

    @Test
    public void divMatrix() throws CalcException {
        actual = parser.calc("{{1,2},{3,4}}/2");
        assertEquals("{{0.5, 1.0}, {1.5, 2.0}}",actual.toString());
    }


    @Test
    public void createVar() throws CalcException {
        actual=Var.createVar("5");
        assertEquals("5.0",actual.toString());
        actual=Var.createVar("{1,2}");
        assertEquals("{1.0, 2.0}",actual.toString());
        actual=Var.createVar("{{1,2},{3,4}}");
        assertEquals("{{1.0, 2.0}, {3.0, 4.0}}",actual.toString());
    }
}