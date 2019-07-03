package by.it.dilkevich.calc;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class VarTest {

    @Test
    public void createScalar() {

        Var var = new Scalar("45");
        String actual = var.toString();
        assertEquals(actual,"45.0");
        var = new Scalar("-123.33");
        actual = var.toString();
        assertEquals(actual,"-123.33");
    }

    @Test
    public void createVector() {

        Var var = new Vector("{1,2.,3,4}");
        String actual = var.toString();
        assertEquals("{1.0, 2.0, 3.0, 4.0}", actual);
        var = new Vector("{1.12, 56.00, 4, -34}");
        actual = var.toString();
        assertEquals("{1.12, 56.0, 4.0, -34.0}", actual);
    }

    @Test
    public void createMatrix() {

        Var var = new Matrix("{{1,2.,3,4}, {1,2.,3,4}}");
        String actual = var.toString();
        assertEquals("{{1.0, 2.0, 3.0, 4.0}, {1.0, 2.0, 3.0, 4.0}}" ,actual);
        var = new Matrix("{{1.12, 56.00,  4, -34}, {1,2.,3,4}, {1,2.22,-3,4}}");
        actual = var.toString();
        assertEquals("{{1.12, 56.0, 4.0, -34.0}, {1.0, 2.0, 3.0, 4.0}, {1.0, 2.22, -3.0, 4.0}}",  actual);
    }
}