package by.it.yaskevich.calc;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class Test_jd02_03 {
    private Parser parser;

    @Before
    public void initParser() {
        parser = new Parser();
    }

    @After
    public void clearParser() {
        parser = null;
    }

    @Test
    public void calcA() throws Exception {
        Var actualVar = parser.calc("A=2+5.3");
        assertEquals("7.3", actualVar.toString());
        actualVar = parser.calc("B=A*3.5");
        assertEquals("25.55", actualVar.toString());
        actualVar = parser.calc("B1=B+0.11*-5");
        assertEquals("25.0", actualVar.toString());
        actualVar = parser.calc("B2=A/2-1");
        assertEquals("2.65", actualVar.toString());
    }

    @Test
    public void calcB() throws Exception {
        Var actualVar = parser.calc("A=2+5.3");
        assertEquals("7.3", actualVar.toString());
        actualVar = parser.calc("B=A*3.5");
        assertEquals("25.55", actualVar.toString());
        actualVar = parser.calc("C=B+(A*2)");
        assertEquals("40.15", actualVar.toString());
        actualVar = parser.calc("D=((C-0.15)-20)/(7-5)");
        assertEquals("10.0", actualVar.toString());
        actualVar = parser.calc("E={2,3}*(D/2)");
        assertEquals("{10.0, 15.0}", actualVar.toString());
    }

    @Test
    public void calcC() throws Exception {
        Var actualVar = parser.calc("A={{1,2},{3,4}}*{1,1}");
        assertEquals("{3.0, 7.0}", actualVar.toString());
        actualVar = parser.calc("B=(A+{2,3})*2");
        assertEquals("{10.0, 20.0}", actualVar.toString());
        actualVar = parser.calc("C={{4,3},{2,1}}*B");
        assertEquals("{100.0, 40.0}", actualVar.toString());
        actualVar = parser.calc("D=({{1,2},{3,4}}+{{4,3},{2,1}})*{{2,1},{2,1}}");
        assertEquals("{{20.0, 10.0}, {20.0, 10.0}}", actualVar.toString());
        try {
            parser.calc("E=D/10");
            fail("Деление матрицы на число невозможно");
        } catch (CalcException ignored) {
        }
    }

    @Test(expected = CalcException.class)
    public void calcC_D() throws Exception {
        parser.calc("A={{1,2},{3,4}}/10");
    }

    @Ignore("Это задание еще не придумали")
    @Test
    public void calcD() throws Exception {
    }
}