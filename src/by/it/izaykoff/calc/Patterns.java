package by.it.izaykoff.calc;

public interface Patterns {
    String OPERATION = "(?<=[^=*/{,+-])[=*/+-]";
    String SCALAR = "-?[0-9]+\\.?[0-9]*";
    String VECTOR = "\\{((-?[0-9]+\\.?[0-9]*),?)+}";
    String MATRIX = "\\{(\\{((-?[0-9]+\\.?[0-9]*),?)+},?)+}";
}
