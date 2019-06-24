package by.it.trudnitski.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class TaskA1 {
   static Random generator=new Random();
    private List<Integer> grades=new ArrayList<>();

    void clearBad(List<Integer> grades){
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()){
            if(iterator.next()<4)
                iterator.remove();
        }
    }
    public static void main(String[] args) {
        for (int i = 1; i <10 ; i++) {
            int i1=1+generator.nextInt(10);
            System.out.println(i1+" ");
        }
        TaskA1 instance=new TaskA1();
        for (int i = 0; i <20 ; i++) {
            Integer grade= 1+generator.nextInt(10);
            instance.grades.add(grade);
        }
        System.out.println(instance.grades);
        instance.clearBad(instance.grades);
        System.out.println(instance.grades);
    }

}
