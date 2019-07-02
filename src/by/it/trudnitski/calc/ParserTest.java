package by.it.trudnitski.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void scalar() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.calc("A=2+5.3");
        assertEquals("7.3", actual.toString());
        actual = parser.calc("B=A*3.5");
        assertEquals("25.55", actual.toString());
        actual = parser.calc("B2=A/2-1");
        assertEquals("2.65", actual.toString());
    }

    @Test
    public void vector() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.calc("{1,2,3}+{1,2,3}");
        assertEquals("{2.0, 4.0, 6.0}", actual.toString());
        actual = parser.calc("{1,2,3}*{1,2,3}");
        assertEquals("14.0", actual.toString());
        actual = parser.calc("{1,2,3}-{1,2,3}");
        assertEquals("{0.0, 0.0, 0.0}", actual.toString());
        actual = parser.calc("{1,2,3}/2");
        assertEquals("{0.5, 1.0, 1.5}", actual.toString());
    }

    @Test
    public void matrix() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.calc("{{1,2,3},{4,5,6},{7,8,9}}+{{1,2,3},{4,5,6},{7,8,9}}");
        assertEquals("{{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}}", actual.toString());
        actual = parser.calc("{{1,2,3},{4,5,6},{7,8,9}}-{{1,2,3},{4,5,6},{7,8,9}}");
        assertEquals("{{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}}", actual.toString());
        actual = parser.calc("{{1,2,3},{4,5,6},{7,8,9}}*{{1,2,3},{4,5,6},{7,8,9}}");
        assertEquals("{{30.0, 36.0, 42.0}, {66.0, 81.0, 96.0}, {102.0, 126.0, 150.0}}", actual.toString());
        actual = parser.calc("{{1,2,3},{4,5,6},{7,8,9}}*{1,2,3}");
        assertEquals("{14.0, 32.0, 50.0}", actual.toString());
    }
}