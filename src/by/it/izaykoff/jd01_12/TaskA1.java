package by.it.izaykoff.jd01_12;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskA1 {

    private static Random generator = new Random();
    private List<Integer> grades = new ArrayList<>();

    public static void main(String[] args) {

        TaskA1 instance = new TaskA1();
        for (int i=0; i<20; i++){
            Integer grade = 1 + generator.nextInt(10);
            instance.grades.add(grade);
        }
        System.out.println(instance.grades);
        instance.clearBad(instance.grades);
        System.out.println(instance.grades);

    }

    private void clearBad(List<Integer> grades){
        grades.removeIf(integer -> integer < 4);
//        Iterator<Integer> iterator = grades.iterator();
//        while (iterator.hasNext()){
//            if (iterator.next()<4)
//                iterator.remove();
//        }
    }

}
