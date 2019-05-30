package by.it.yaskevich.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = Arrays.copyOf(value, value.length);
        for (int i = 0; i < value.length; i++) {
            this.value[i] = Arrays.copyOf(value[i], value[i].length);
        }
    }

    Matrix(Matrix matrix) {
        this(matrix.value);
    }

    Matrix(String strMatrix) {
        Matcher matcher = Pattern.compile("^\\{(?<arrays>((, ?)?\\{(((, ?)?(\\d+(\\.\\d)?))+)\\})+)\\}$").matcher(strMatrix);
        if (!matcher.find())
            throw new IllegalArgumentException("Incorrect format: " + strMatrix);

        String rawData = matcher.group("arrays");
        matcher = Pattern.compile("\\{(?<array>((, ?)?(\\d+(\\.\\d)?))+)\\}").matcher(rawData);

        int counter = 0;
        while (matcher.find()) {
            counter++;
        }

        value = new double[counter][];

        counter = 0;
        matcher.reset();
        while (matcher.find()) {
            String[] numbers = Pattern.compile(",").split(matcher.group("array"));

            value[counter] = new double[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                value[counter][i] = Double.parseDouble(numbers[i]);
            }
            counter++;
        }
    }

    @Override
    public String toString() {
        if (value.length == 0)
            return "{}";
        StringBuilder result = new StringBuilder();
        result.append("{");
        String delimiter = "";
        for (double[] array : value) {
            result.append(delimiter).append("{");
            delimiter = "";
            for (double element : array) {
                result.append(delimiter).append(element);
                delimiter = ", ";
            }
            result.append("}");
        }
        result.append("}");
        return result.toString();
    }
}
