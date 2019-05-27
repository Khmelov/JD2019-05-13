package by.it.maniuk.jd01_01;

import java.util.Scanner;

/*
Ускорение свободного падения на Земле и Марсе таково:
Марс   3.86
Земля   9.81

С клавиатуры вводится вес человека в килограммах.
Рассчитайте вес человека на Марсе и выведите
округлив его до сотых килограмма (2 знака)

Создайте для этих целей метод getWeight(int weight)

Требования:
1. Метод getWeight(int weight) должен быть статическим.
2. Метод getWeight должен возвращать значение типа double.
3. Метод getWeight должен обязательно (!) округлять до сотых возвращаемое значение типа double.
4. Метод getWeight не должен ничего выводить на экран.
5. Метод getWeight должен правильно переводить вес тела в килограммах на Земле
    в вес этого же тела на Марсе, и возвращать это значение.

Пример:

Ввод:
75

Вывод:
29.51


*/
class TaskC3 {
    private static double marsWeight;

    private TaskC3(int weight) {
        getWeight(weight);
        System.out.println(getWeight(weight));

    }

    private static double getWeight(int weight) { //P = m*g  m=P/g m = 75/9.81
        double massa = weight/9.81;
        double marsWeightWithoutRound = massa*3.86;
        return marsWeight =  (Math.round(marsWeightWithoutRound* 100d)) / 100d;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int weight = scanner.nextInt();
        TaskC3 taskC3 = new TaskC3(weight);

    }

}

