package by.it.zhukova.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {
    private List<Integer> grades = new ArrayList<>();
    static Random generator = new Random();
    void clearBad( List <Integer> grades){
        grades.removeIf(integer -> integer < 4);
        // лямбда выражение для метода removeIF Удаляем все оценки меньше 4
    }
    public static void main(String[] args) {
        TaskA1 a1 = new TaskA1();
        for (int i = 0; i < 25; i++) {
            Integer grade= 1+generator.nextInt(10);
            a1.grades.add(grade);
        }
        // заполнили случайными оценками список grades
        System.out.println(a1.grades);
        a1.clearBad(a1.grades);
        System.out.println(a1.grades);
    }
}
