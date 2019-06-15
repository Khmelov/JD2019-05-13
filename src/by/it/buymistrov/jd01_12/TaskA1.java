package by.it.buymistrov.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {

    private static Random generator = new Random();

    private List<Integer> gredes = new ArrayList<>();

    void clearBad(List<Integer> grades){
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()){
            if (iterator.next()<4){
                iterator.remove();
            }
        }

    }


    public static void main(String[] args) {

        TaskA1 instance = new TaskA1();

        for (int i = 0; i < 20; i++) {

            Integer grade = 1 + generator.nextInt(10);
            instance.gredes.add(grade);

        }

        System.out.println(instance.gredes);

        instance.clearBad(instance.gredes);
        System.out.println(instance.gredes);




    }

}
