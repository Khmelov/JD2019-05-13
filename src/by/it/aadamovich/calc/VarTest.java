package by.it.aadamovich.calc;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class VarTest {

    private static Map<String, String> test = new TreeMap<>();

    static {
        test.put("55", "55.0");
        test.put("0.99", "0.99");
        test.put("-5", "-5.0");
        test.put("{10,  -15.0}", "{10.0, -15.0}");
        test.put("{1, 2.0,-3}", "{1.0, 2.0, -3.0}");
        test.put("{{11,12,13},{13,12,11}}", "{{11.0, 12.0, 13.0}, {13.0, 12.0, 11.0}}");
        test.put("{{-111.9 , 8.55},{7.77 ,-2},{-1,8}}", "{{-111.9, 8.55}, {7.77, -2.0}, {-1.0, 8.0}}");
    }

    @Test
    public void createVar() throws CalcException {

        String result;
        for (Map.Entry<String, String> entry : test.entrySet()) {
            result = VarFactory.CREATOR.createVar(entry.getKey()).toString();
            assertEquals(entry.getValue(), result);
        }
    }
}
