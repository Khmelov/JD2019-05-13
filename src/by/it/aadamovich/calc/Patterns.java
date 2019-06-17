package by.it.aadamovich.calc;

interface Patterns {

    String SCALAR = "[-]?[\\d.]+";
    String VECTOR = "\\{([-]?[\\d.]+[,]?)+\\}";
    String MATRIX = "\\{(\\{([-]?[\\d.]+[,]?)+\\}[,]?)+\\}";
    String OPERATION = "[-+*/=]";
}
