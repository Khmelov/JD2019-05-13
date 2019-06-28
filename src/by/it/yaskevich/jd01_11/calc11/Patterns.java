package by.it.yaskevich.jd01_11.calc11;

interface Patterns {
    String OPERATION = "[=+*/-]";
    String PRINTVAR = "printvar";
    String SORTVAR = "sortvar";
    String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    String VECTOR = "\\{(?<array>(-?[0-9]+(.[0-9]+)?)(,-?[0-9]+(\\.[0-9]+)?)*)\\}";
    String MATRIX = "\\{(?<arrays>\\{(-?[0-9]+(.[0-9]+)?)(,-?[0-9]+(\\.[0-9]+)?)*\\}(,\\{(-?[0-9]+(.[0-9]+)?)(,-?[0-9]+(\\.[0-9]+)?)*\\})*)\\}";
}
