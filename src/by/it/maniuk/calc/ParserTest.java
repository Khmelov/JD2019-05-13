package by.it.maniuk.calc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    @Test
    public void calcScalar() throws Exception {
        by.it.maniuk.calc.Parser parser = new by.it.maniuk.calc.Parser();
        by.it.maniuk.calc.Var actual = parser.calc("A=2+5.3");
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
    @Test
    public void calcVector() throws Exception {
        by.it.maniuk.calc.Parser parser = new by.it.maniuk.calc.Parser();
        by.it.maniuk.calc.Var actual = parser.calc("{2,3,4}*2");
        assertEquals("{4.0, 6.0, 8.0}",actual.toString());
        actual = parser.calc("{3,6,9}/3");
        assertEquals("{1.0, 2.0, 3.0}",actual.toString());
        actual = parser.calc("{2,3,4}-5");
        assertEquals("{-3.0, -2.0, -1.0}",actual.toString());
        actual = parser.calc("4+{2,3,4}");
        assertEquals("{6.0, 7.0, 8.0}",actual.toString());
        actual = parser.calc("{2,3,4}+{5,6,7}");
        assertEquals("{7.0, 9.0, 11.0}",actual.toString());
        actual = parser.calc( "{5,6,7}-{2,3,4}");
        assertEquals("{3.0, 3.0, 3.0}",actual.toString());

    }
    @Test
    public void calcMatrix() throws Exception {
        by.it.maniuk.calc.Parser parser = new by.it.maniuk.calc.Parser();
        by.it.maniuk.calc.Var actual = parser.calc("{{1,2},{8,3}}-2" );
        assertEquals("{{-1.0, 0.0}, {6.0, 1.0}}",actual.toString());
        actual = parser.calc("{{1,2},{8,3}}*{1,2}" );
        assertEquals("{5.0, 14.0}",actual.toString());
        actual = parser.calc("{{1,2},{8,3}}*{{1,2},{8,3}}");
        assertEquals("{{17.0, 8.0}, {32.0, 25.0}}",actual.toString());
        actual = parser.calc("{{1,2},{8,3}}+{{1,2},{8,3}}");
        assertEquals("{{2.0, 4.0}, {16.0, 6.0}}",actual.toString());

    }
}
//A=2+5.3
//B=A*3.5
//C=B+(A*2)