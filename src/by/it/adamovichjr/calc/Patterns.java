package by.it.adamovichjr.calc;

public class Patterns {

    static final String EXPRESSION_IN_BRACKETS = "\\({1}[^()].[^()]*?\\){1}";
    static final String OPERATION="(?<=[^+=*/{,-])[=*/+-]";
    static final String SCALAR = "[-+]?\\d+[.]?\\d*";
    static final String VECTOR = "\\{(\\-?\\d+[.]?\\d*,?)+\\}";
    static final String MATRIX = "\\{(\\{(-?\\d+[.]?\\d*,?)+\\},?)+\\}";

}
