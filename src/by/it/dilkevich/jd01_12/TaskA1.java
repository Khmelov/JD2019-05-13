package by.it.dilkevich.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {

    private List<Integer> ratings  = new ArrayList<>();

    void clearBad(List<Integer> grades) {
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() < 4) {
                iterator.remove();
            }
        }
    }


    public static void main(String[] args) {

        Random random = new Random();
        TaskA1 taskA1 = new TaskA1();

        for (int i = 0; i < 10; i++) {

            taskA1.ratings.add(1 + random.nextInt(10));

        }
        System.out.println(taskA1.ratings);
        taskA1.clearBad(taskA1.ratings);
        System.out.println(taskA1.ratings);

    }

    }

