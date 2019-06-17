package by.it.orlov.Calc;

interface Patterns {
    String SCALAR = "((-?)([0-9.]+))";
    String VECTOR = "\\{(-?([0-9.])+,?)+}";
    String MATRIX = "\\{(\\{(-?([0-9.])+,?)+}+,?)+}";
    String OPERATION = "[-*+/=]";

}
