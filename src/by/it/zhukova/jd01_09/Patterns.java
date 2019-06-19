package by.it.zhukova.jd01_09;

interface Patterns{
        String OPERATION = "[+*/-]";
        String SCALAR = "-?\\d+(\\.\\d+)?";
        String VECTOR = "\\{-?\\d+(\\.\\d+)?(,-?\\d+(\\.\\d+)?)*}";
        String MATRIX = "\\{\\{-?\\d+(\\.\\d+)?(,-?\\d+(\\.\\d+)?)*},(\\{-?\\d+(\\.\\d+)?(,-?\\d+(\\.\\d+)?)*})*}";
    }