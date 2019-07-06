package by.it.aadamovich.calc;

interface Patterns {

    String SCALAR = "-?\\d+(\\.\\d+)?";
    String VECTOR = "\\{(-?\\d+(\\.\\d+)? *,? *)+\\}";
    String MATRIX = "\\{(\\{(-?\\d+(\\.\\d+)? *,? *)+\\},? *)+\\}";
    String OPERATION = "(?<=[^=*+/{(,-])[-+*/=]";
    String BRACKET = "\\([^)(]+\\)";

    String BASENAME = "by.it.aadamovich.calc.resources.messages";
    String DIR_FOR_LOGS = "logs";
    String FILE_FOR_LOGS = "log.txt";

    String END_COMMAND = "end";
    String SORTVAR_COMMAND = "sortvar";
    String PRINTVAR_COMMAND = "printvar";
    String RUSSIAN_COMMAND = "ru";
    String BELARUSIAN_COMMAND = "be";
    String ENGLISH_COMMAND = "en";

    String RUS_LANG = "ru";
    String RUS_COUN = "RU";
    String BY_LANG = "be";
    String BY_COUN = "BY";


}
