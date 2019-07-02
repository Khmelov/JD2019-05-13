package by.it.livanovich.calc;

public class Patterns {
    static final String OPERATION="(?<=[^-=+*/{,])([=+/*-])";
    static final String SCALAR="-?\\d+\\.?\\d*";
    static final String VECTOR="\\{((\\s?-?\\d+\\.?\\d*),?)+}";
    static final String MATRIX="\\{(\\{((\\s?-?\\d+\\.?\\d*),?)+},?\\s?)+}?";
}
