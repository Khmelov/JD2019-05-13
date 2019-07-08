package by.it.zhukova.calc;

import org.junit.Test;
import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void calc() throws Exception {
        Parser parser = new Parser();
        // операции со скалярами
        Var actual = parser.calc("A=2+5.3");
        assertEquals("7.3",actual.toString());
        actual=parser.calc("B=A*3.5");
        assertEquals("25.55",actual.toString());
        actual=parser.calc("B1=B+0.11*-5 ");
        assertEquals("25.0",actual.toString());
        actual=parser.calc("B2=A/2-1");
        assertEquals("2.65",actual.toString());
        actual=parser.calc("C=B+(A*2)");
        assertEquals("40.15",actual.toString());
        actual=parser.calc("D=((C-0.15)-20)/(7-5)");
        assertEquals("10.0",actual.toString());
        // операции с векторами
        actual=parser.calc("E={2,3}*(D/2)");
        assertEquals("{10.0, 15.0}",actual.toString());
        actual=parser.calc("F=(E+A)/D");
        assertEquals("{1.73, 2.23}",actual.toString());
        actual=parser.calc("F1=(F+E)-2");
        assertEquals("{9.73, 15.23}",actual.toString());
        actual=parser.calc("F2=(E-{2,5})*1");
        assertEquals("{8.0, 10.0}",actual.toString());
        actual=parser.calc("E={2,3}*F2");
        assertEquals("46.0",actual.toString());
        // операции с матрицами
        actual=parser.calc("G=({{1,2},{8,3}}-2)*2");
        assertEquals("{{-2.0, 0.0}, {12.0, 2.0}}",actual.toString());
        actual=parser.calc("G1=(G/2)*{3,3}");
        assertEquals("{-3.0, 21.0}",actual.toString());
        actual=parser.calc("G2=G+(G*5+1)");
        assertEquals("{{-11.0, 1.0}, {73.0, 13.0}}",actual.toString());
        actual=parser.calc("K=(G+{{1,1},{1,1}})*1");
        assertEquals("{{-1.0, 1.0}, {13.0, 3.0}}",actual.toString());
        actual=parser.calc("K1=K*G");
        assertEquals("{{14.0, 2.0}, {10.0, 6.0}}",actual.toString());
    }
}