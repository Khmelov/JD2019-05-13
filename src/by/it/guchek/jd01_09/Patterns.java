package by.it.guchek.jd01_09;

public class Patterns {
    static final String OPERATION = "[-+/*]";
    static final String SCALAR ="-?[0-9]+\\.?[0-9]*";              //регулярка для чисел
    static final String VECTOR ="\\{((-?[0-9]+\\.?[0-9]*),?)+}";  //регулярка для векторов
    static final String MATRIX ="\\{(\\{((-?[0-9]+\\.?[0-9]*),?)+},?)+}";  //регулярка для матриц


}
