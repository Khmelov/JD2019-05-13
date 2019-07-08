package by.it.lasotskaya.calc;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void calc() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.calc("A=2+5.3");
        assertEquals("7.3",actual.toString());
        actual = parser.calc("B=A*3.5");
        assertEquals("25.55",actual.toString());
        assertEquals(parser.calc("B2=A/2-1").toString(),"2.65");
        assertEquals(parser.calc("B1=B+0.11*-5").toString(),"25.0");
    }

    @Test (timeout = 500)
    public void vector() throws Exception {
        Parser parser = new Parser();
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        assertEquals(parser.calc("C=B+(A*2)").toString(),"40.15");
        assertEquals(parser.calc("D=((C-0.15)-20)/(7-5)").toString(),"10.0");
        assertEquals(parser.calc("E={2,3}*(D/2)").toString(),"{10.0, 15.0}");
    }
    @Test (timeout = 500)
    public void format() throws Exception{
        Parser parser = new Parser();
        assertEquals(parser.calc("15").toString(),"15.0");
        assertEquals(parser.calc("{15,13,12,5,0}").toString(),
                "{15.0, 13.0, 12.0, 5.0, 0.0}");
    }
}