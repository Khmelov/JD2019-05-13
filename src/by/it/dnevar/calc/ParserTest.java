package by.it.dnevar.calc;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void getIndexPriorOperation() {
        System.out.println("***Start check method getIndexPriorOperation***\n");

        int actual = Parser.getIndexPriorOperation(Arrays.asList("+","+","/","*","/"));
        int expect = 2;

        assertEquals(2,actual);
        System.out.printf("Input: asList(\"+\",\"+\",\"/\",\"*\",\"/\")\nExpected: %s\nActual: %s\n\n",expect,actual);

        System.out.println("***End check method getIndexPriorOperation***\n\n");
    }

    @Test
    public void calc() throws CalcException {
        System.out.println("***Start check method calc***\n");

        Parser parser = new Parser();
        Var actual;
        String input;
        String expect;

        input = "A=2+5.3";
        actual = parser.calc(input);
        expect = "7.3";
        assertEquals(expect,actual.toString());
        System.out.printf("Input: %s\nExpected: %s\nActual: %s\n\n",input,expect,actual);

        input = "B=A*3.5";
        actual = parser.calc(input);
        expect = "25.55";
        assertEquals(expect,actual.toString());
        System.out.printf("Input: %s\nExpected: %s\nActual: %s\n\n",input,expect,actual);

        input = "B1=B+0.11*-5";
        actual = parser.calc(input);
        expect = "25.0";
        assertEquals(expect,actual.toString());
        System.out.printf("Input: %s\nExpected: %s\nActual: %s\n\n",input,expect,actual);

        input = "B2=A/2-1";
        actual = parser.calc(input);
        expect = "2.65";
        assertEquals(expect,actual.toString());
        System.out.printf("Input: %s\nExpected: %s\nActual: %s\n\n",input,expect,actual);

        input = "A1={1,2}+{2,3}";
        actual = parser.calc(input);
        expect = "{3.0, 5.0}";
        assertEquals(expect,actual.toString());
        System.out.printf("Input: %s\nExpected: %s\nActual: %s\n\n",input,expect,actual);

        input = "C=B+(A*2)";
        actual = parser.calc(input);
        expect = "40.15";
        assertEquals(expect,actual.toString());
        System.out.printf("Input: %s\nExpected: %s\nActual: %s\n\n",input,expect,actual);

        input = "D=((C-0.15)-20)/(7-5)";
        actual = parser.calc(input);
        expect = "10.0";
        assertEquals(expect,actual.toString());
        System.out.printf("Input: %s\nExpected: %s\nActual: %s\n\n",input,expect,actual);

        input = "E={2,3}*(D/2)";
        actual = parser.calc(input);
        expect = "{10.0, 15.0}";
        assertEquals(expect,actual.toString());
        System.out.printf("Input: %s\nExpected: %s\nActual: %s\n\n",input,expect,actual);

        input = "F={2,3}*({1,2}+{3,4})";
        actual = parser.calc(input);
        expect = "26.0";
        assertEquals(expect,actual.toString());
        System.out.printf("Input: %s\nExpected: %s\nActual: %s\n\n",input,expect,actual);

        input = "F=({{2,3},{3,2}}/2)*{{2,3},{4,5}}*(({1,2}+{3,4})*2)";
        actual = parser.calc(input);
        expect = "{190.0, 170.0}";
        assertEquals(expect,actual.toString());
        System.out.printf("Input: %s\nExpected: %s\nActual: %s\n\n",input,expect,actual);

        System.out.println("***End check method calc***\n\n");
    }
}