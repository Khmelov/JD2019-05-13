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
        actual=parsel.calc("C=B+(A*2)");
        assertEquals("40.15",actual.toString());
        actual=parsel.calc("D=((C-0.15)-20)/(7-5)");
        assertEquals("10.0",actual.toString());
        actual=parsel.calc("E={2,3}*(D/2)");
        assertEquals("{10.0, 15.0}",actual.toString());
        actual=parsel.calc("F={{1,2},{8,3}}-(10/5)");
        assertEquals("{{-1.0, 0.0}, {6.0, 1.0}}",actual.toString());
        actual=parsel.calc("G={{1,2},{8,3}}*{1,2}+(6-5)");
        assertEquals("{6.0, 15.0}",actual.toString());
        actual=parsel.calc("H=D+{{1,2},{8,3}}*{{1,2},{8,3}}-(-6+9)");
        assertEquals("{{24.0, 15.0}, {39.0, 32.0}}",actual.toString());
     }

     @Test
    public void Scalar () throws Exception{
        Scalar scalar=new Scalar("2");
        assertEquals(2.0,scalar.getValue(),0);
        String actual=scalar.toString();
        assertEquals("2.0",actual);
     }

    @Test
    public void Vector () throws Exception{
        Vector vector=new Vector("{1,2,-3,4}");
        double [] expected={1.0, 2.0, -3.0, 4.0};
        double [] actul=vector.getValue();
        assertArrayEquals(expected,actul,0);
        String actual=vector.toString();
        assertEquals("{1.0, 2.0, -3.0, 4.0}",actual);
    }

    @Test
    public void Matrix () throws Exception{
        Matrix matrix=new Matrix("{{1,2},{-3,4}}");
        double [][] expected={{1.0, 2.0}, {-3.0, 4.0}};
        double [][] actul=matrix.getValue();
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j <expected[0].length ; j++) {
                assertEquals(expected[i][j],actul[i][j],0);
            }
        }
        String actual=matrix.toString();
        assertEquals("{{1.0, 2.0}, {-3.0, 4.0}}",actual);
    }
}