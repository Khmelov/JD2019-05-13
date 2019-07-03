package by.it.tbabich.jd02_04;

import org.junit.Test;

import static org.junit.Assert.*;

public class VarTest {

    @Test
    public void createVar() throws Exception {
        Var scalar = Var.createVar("5");
        assertEquals("5.0", scalar.toString());
        Var vector = Var.createVar("{3,2,1}");
        assertEquals("{3.0, 2.0, 1.0}", vector.toString());
        Var matrix = Var.createVar("{{3,2,1},{7,5,4}}");
        assertEquals("{{3.0, 2.0, 1.0}, {7.0, 5.0, 4.0}}", matrix.toString());
    }
}