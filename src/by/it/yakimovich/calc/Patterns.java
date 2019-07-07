package by.it.yakimovich.calc;

public class Patterns {
    static final String operation="(?<=[^+=*/{,-])[=*/+-]";
    static final String BRACES="(\\()([^\\(\\)]*)(\\))";
    static final String SCALAR="-?[0-9]+\\.?[0-9]*";
    static final String VECTOR="\\{((-?[0-9]+\\.?[0-9]*),?)+}";
    static final String MATRIX="\\{(\\{((-?[0-9]+\\.?[0-9]*),?)+},?)+}";
}
