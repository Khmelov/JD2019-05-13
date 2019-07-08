package by.it.tbabich.jd02_04;

interface Patterns {
    String HOOKS = "\\([^()]*\\)";
    String OPERATION = "(?<=[^+=*/{,-])[=*/+-]";
    String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    String VECTOR = "\\{-?[0-9]+(\\.[0-9]+)?(,-?[0-9]+(\\.[0-9]+)?)*}";
    String MATRIX = "\\{\\{-?[0-9]+(\\.[0-9]+)?(,-?[0-9]+(\\.[0-9]+)?)*}(,\\{-?[0-9]+(\\.[0-9]+)?(,-?[0-9]+(\\.[0-9]+)?)*})*}";
    String ADD = "+";
    String SUB = "-";
    String MUL = "*";
    String DIV = "/";


}
