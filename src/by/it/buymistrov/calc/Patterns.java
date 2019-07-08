package by.it.buymistrov.calc;

interface Patterns {
    String OPERATION="(?<=[^+=*/{,-])[=*/+-]";
    String SCALAR ="-?[0-9]+(\\.[0-9]+)?";
    String VECTOR ="\\{-?[0-9]+(\\.[0-9]+)?(,-?[0-9]+(\\.[0-9]+)?)*}";
    String MATRIX ="\\{(\\{((-?[0-9]+\\.?[0-9]*),?)+},?)+}";
    String PRINTVAR = "printvar";
    String SORTVAR = "sortvar";
    String END = "end";
    String EN = "en";
    String RU = "ru";
    String BE = "be";
}
