package by.it.guchek.calc2;

public class Patterns {
    static final String OPERATION = "(?<=[^+=*/{,-])[=*/+-]";
    static final String SCALAR ="-?[0-9]+\\.?[0-9]*";              //регулярка для чисел
    static final String VECTOR ="\\{((-?[0-9]+\\.?[0-9]*),?)+}";  //регулярка для векторов
    static final String MATRIX ="\\{(\\{((-?[0-9]+\\.?[0-9]*),?)+},?)+}";  //регулярка для матриц
    static final String BRACE ="((?<=[(])[\\w?[.\\d]]*[+*/{,-][\\w?[.\\d]]*(?=[)]))"; //для выражения в скобках

}
