package by.it.orlov.jd01_09;

interface Patterns {
    String SCALAR = "((-?)([0-9.]+))";
    String VECTOR = "\\{(-?([0-9.])+,?)+}";
    String MATRIX = "\\{(\\{(-?([0-9.])+,?)+}+,?)+}";
    String OPERATION = "[-*+/]";

}
