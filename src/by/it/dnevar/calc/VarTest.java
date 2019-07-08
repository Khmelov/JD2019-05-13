package by.it.dnevar.calc;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class VarTest {

    @Test
    public void createVar() throws CalcException {
        System.out.println("***Start check method createVar***\n");

        Var actual;
        String input;
        String expect;

        input = "2";
        actual = Var.createVar(input);
        expect = "2.0";
        assertEquals(expect,actual.toString());
        System.out.printf("Input: %s\nExpected: %s\nActual: %s\n\n",input,expect,actual);

        input = "{1,2,3}";
        actual = Var.createVar(input);
        expect = "{1.0, 2.0, 3.0}";
        assertEquals(expect,actual.toString());
        System.out.printf("Input: %s\nExpected: %s\nActual: %s\n\n",input,expect,actual);

        input = "{{1,2,3},{1,2,3},{1,2,3}}";
        actual = Var.createVar(input);
        expect = "{{1.0, 2.0, 3.0}, {1.0, 2.0, 3.0}, {1.0, 2.0, 3.0}}";
        assertEquals(expect,actual.toString());
        System.out.printf("Input: %s\nExpected: %s\nActual: %s\n\n",input,expect,actual);

        System.out.println("***End check method createVar***\n\n");
    }
}