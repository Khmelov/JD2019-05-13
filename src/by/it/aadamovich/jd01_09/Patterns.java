package by.it.aadamovich.jd01_09;

class Patterns {

    static final String SCALAR = "[-]?[\\d.]+";
    static final String VECTOR = "\\{([-]?[\\d.]+[,]?)+\\}";
    static final String MATRIX = "\\{(\\{([-]?[\\d.]+[,]?)+\\}[,]?)+\\}";
    static final String OPERATION = "[-+*/]";
}
