package by.it.zhukova.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class VarTest {

    @Test
    public void createVar() throws CalcException {
       Var actual = Var.createVar("2");
        assertEquals("2.0",actual.toString());
        actual = Var.createVar("2");
        assertEquals("2.0",actual.toString());
        actual = Var.createVar("{1,2,3}");
        assertEquals("{1.0, 2.0, 3.0}",actual.toString());
        actual = Var.createVar("{{2,3,2},{1,4,4},{5,5,5},{6,6,6}}");
        assertEquals("{{2.0, 3.0, 2.0}, {1.0, 4.0, 4.0}, {5.0, 5.0, 5.0}, {6.0, 6.0, 6.0}}",actual.toString());

    }
}