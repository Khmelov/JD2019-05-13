package by.it.izaykoff.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParcerTest {

    @Test
    public void calc() throws Exception {
        Parcer parcer = new Parcer();
        Var actual = parcer.calc("A=2+5.3");
        assertEquals("7.3",actual.toString());
        actual = parcer.calc("B=A*3.5");
        assertEquals("25.55",actual.toString());
        actual = parcer.calc("B1=B+0.11*-5");
        assertEquals("25.0",actual.toString());
        actual = parcer.calc("B2=A/2-1");
        assertEquals("2.65",actual.toString());

        actual = parcer.calc("C=B+(A*2)");
        assertEquals("40.15",actual.toString());
    }
}