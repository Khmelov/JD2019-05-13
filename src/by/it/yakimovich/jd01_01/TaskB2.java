package by.it.yakimovich.jd01_01;
/*
Подойдет только 20
В методе main расставь правильно знаки плюс и минус, чтобы значение переменной result получилось равным 20.
Знаки нужно расставить только в строчке, в которой объявляется переменная result.
Перед каждой переменной должен стоять знак либо плюс, либо минус.

Требования:

1. Значения переменных: a, b, c, d не изменять.
2. Перед каждой из переменных: a, b, c, d в строке с объявлением переменной result
    должен стоять один знак плюс либо минус.
3. В результате работы программы на экран нужно вывести число 20.
4. Знаки плюс и минус должны быть расставлены правильно.

 */
class TaskB2 {

    public static void main(String[] args) {
        int a = 1;
        int b = 3;
        int c = 9;
        int d = 27;
        int result = - a + b - c + d;

        System.out.println(result);
    }
}
