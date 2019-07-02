package by.it.livanovich.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParselTest {

    @Test
    public void calc() throws Exception {
        Parsel parsel=new Parsel();
        Var actual=parsel.calc("A=2+5.3");
        assertEquals("7.3",actual.toString());
        actual=parsel.calc("B=A*3.5");
        assertEquals("25.55",actual.toString());
        actual=parsel.calc("B1=B+0.11*-5");
        assertEquals("25.0",actual.toString());
        actual=parsel.calc("B2=A/2-1");
        assertEquals("2.65",actual.toString());

    }
}