package by.it.zhukova.calc;

interface Patterns{
        String OPERATION = "[+*/=-]";
        String SCALAR = "-?\\d+(\\.\\d+)?";
        String VECTOR = "\\{-?\\d+(\\.\\d+)?(,-?\\d+(\\.\\d+)?)*}";
        String MATRIX = "\\{\\{-?\\d+(\\.\\d+)?(,-?\\d+(\\.\\d+)?)*}(,\\{-?\\d+(\\.\\d+)?(,-?\\d+(\\.\\d+)?)*})*}";
    }