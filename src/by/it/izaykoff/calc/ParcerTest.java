package by.it.izaykoff.calc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParcerTest {

    private Parcer parcer;

    @Before
    public void initParser() {
        parcer = new Parcer();
    }

    @After
    public void clearParser() {
        parcer = null;
    }

    @Test
    public void calcA() throws Exception {

        Var actual = parcer.calc("A=2+5.3");
        assertEquals("7.3",actual.toString());
        actual = parcer.calc("B=A*3.5");
        assertEquals("25.55",actual.toString());
        actual = parcer.calc("B1=B+0.11*-5");
        assertEquals("25.0",actual.toString());
        actual = parcer.calc("B2=A/2-1");
        assertEquals("2.65",actual.toString());

    }

    @Test
    public void calcB() throws Exception {

        Var actual = parcer.calc("C=B+(A*2)");
        assertEquals("40.15",actual.toString());
        actual = parcer.calc("D=((C-0.15)-20)/(7-5)");
        assertEquals("10.0",actual.toString());
        actual = parcer.calc("E={2,3}*(D/2)");
        assertEquals("{115.0}",actual.toString());
    }
}