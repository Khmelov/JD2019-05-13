package by.it.yakimovich.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Task1 {
    static Random  generator=new Random();
    private List<Integer> grades=new ArrayList<>();

    void clearBad(List<Integer> grades){
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()){
                if (iterator.next()<4)
                    iterator.remove();
        }

    }
    public static void main(String[] args) {
        for (int i = 0; i <20 ; i++) {
            int il=generator.nextInt(10);
            System.out.println(il+" ");

        }


    }
}
