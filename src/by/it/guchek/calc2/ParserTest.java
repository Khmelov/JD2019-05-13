package by.it.guchek.calc2;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void calc() throws CalcException {
        Parser parcer = new Parser();
        String expression = "A=2+5.3";
        String control = "7.3";
        String res = parcer.calc(expression).toString();
        assertTrue(res.equals(control));
        assertEquals(control,res.toString());
        expression = "B=A*3.5";
        control = "25.55";
        res = parcer.calc(expression).toString();
        assertEquals(control,res.toString());
        expression = "B1=B+0.11*-5";
        res = parcer.calc(expression).toString();
        assertEquals("25.0",res.toString());
        expression = "B2=A/2-1";
        res = parcer.calc(expression).toString();
        assertEquals("2.65",res.toString());
    }
}