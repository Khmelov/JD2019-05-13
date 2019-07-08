package by.it.yaskevich.calc;

interface Patterns {
    String OPERATION = "(?<=[^=*/+{,-])[=*/+-]";
    String COMMAND_PRINTVAR = "printvar";
    String COMMAND_SORTVAR = "sortvar";
    String COMMAND_RU = "ru";
    String COMMAND_BE = "be";
    String COMMAND_EN = "en";
    String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    String VECTOR = "\\{(?<array>(-?[0-9]+(.[0-9]+)?)(,-?[0-9]+(\\.[0-9]+)?)*)\\}";
    String MATRIX = "\\{(?<arrays>\\{(-?[0-9]+(.[0-9]+)?)(,-?[0-9]+(\\.[0-9]+)?)*\\}(,\\{(-?[0-9]+(.[0-9]+)?)(,-?[0-9]+(\\.[0-9]+)?)*\\})*)\\}";
}
