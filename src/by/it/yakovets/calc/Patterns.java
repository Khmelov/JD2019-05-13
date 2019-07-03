package by.it.yakovets.calc;

interface Patterns {
    String OPERATION="(?<=[^+=*/{(,-])[=*/+-]";
    String BRACKET="\\([^()]*\\)";
    String SCALAR="-?[0-9]+(\\.[0-9]+)?";
    String VECTOR="\\{-?[0-9]+(\\.[0-9]+)?(,-?[0-9]+(\\.[0-9]+)?)*}";
    String MATRIX="\\{\\{-?[0-9]+(\\.[0-9]+)?(,-?[0-9]+(\\.[0-9]+)?)*},\\{-?[0-9]+(\\.[0-9]+)?(,-?[0-9]+(\\.[0-9]+)?)*}}";
}
