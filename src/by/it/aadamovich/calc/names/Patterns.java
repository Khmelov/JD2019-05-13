package by.it.aadamovich.calc.names;

public interface Patterns {

    String SCALAR = "-?\\d+(\\.\\d+)?";
    String VECTOR = "\\{(-?\\d+(\\.\\d+)? *,? *)+\\}";
    String MATRIX = "\\{(\\{(-?\\d+(\\.\\d+)? *,? *)+\\},? *)+\\}";
    String OPERATION = "(?<=[^=*+/{(,-])[-+*/=]";
    String BRACKET = "\\([^)(]+\\)";
}
