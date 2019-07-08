package by.it.aadamovich.calc;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class ParserTest {



    private static Map<String, String> test = new TreeMap<>();

    static {
        test.put("A=2+5.3", "7.3");
        test.put("B1=A*3.5", "25.55");
        test.put("B2=B1+0.11*-5", "25.0");
        test.put("B3=A/2-1", "2.65");
        test.put("C=B1+(A*2)", "40.15");
        test.put("D=((C-0.15)-20)/(7-5)", "10.0");
        test.put("E={2,3}*(D/2)", "{10.0, 15.0}");
        test.put("F=((E+5)-{{1,2,3},{3,2,1}}*{1,2,3})/2", "{0.5, 5.0}");
        test.put("G=({{1,2,3},{3,2,1}}-{{11,12,13},{13,12,11}})/2.5", "{{-4.0, -4.0, -4.0}, {-4.0, -4.0, -4.0}}");
        test.put("H=G*{{-1,8},{-8,1},{-1,8}}+{{-20,48},{-20,48}}", "{{20.0, -20.0}, {20.0, -20.0}}");
        test.put("((7+5)-11)*2-3.5*((2.4+3.6)-{12,10})", "{23.0, 16.0}");

    }

    @Test
    public void calc() throws Exception {
        Parser parser = new Parser();
        String result;
        for (Map.Entry<String, String> entry : test.entrySet()) {
            result = parser.calc(entry.getKey()).toString();
            assertEquals(entry.getValue(),result);
                    }
    }
}