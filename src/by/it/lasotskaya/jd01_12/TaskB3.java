package by.it.lasotskaya.jd01_12;

import java.util.*;

public class TaskB3 {
    public static void main(String[] args) {
        int count =4096;

        String[] arrPeople = new String[count];
        for (int i = 1; i <=count ; i++) {
            arrPeople[i-1] = "n" + i;
        }
        List<String> peoples1 = new ArrayList<>(Arrays.asList(arrPeople));
        String man1 = process((ArrayList<String>) peoples1);
        Timer t = new Timer();
        LinkedList<String> peoples2 = new LinkedList<>(Arrays.asList(arrPeople));
        Timer t2 = new Timer();


        System.out.println(man1);
        System.out.println(t);
        System.out.println(process(peoples2));
        System.out.println(t2);
    }


    private static String process(ArrayList<String> peoples){
        String rez;
        System.out.println(peoples);
        int counter =0;
        Iterator<String> iterator = peoples.iterator();
        int countPeople = peoples.size();
        while (countPeople>1){
            if (peoples.size()==1) break;
            iterator.next();
            if (counter==0){
                counter=1;
            }
            else {
                iterator.remove();
                counter=0;
                countPeople--;
            }
            if (!iterator.hasNext() &&countPeople>1) iterator = peoples.iterator();
        }
        rez = peoples.get(0);
        return rez;

    }

    private static String process(LinkedList<String> peoples){
        String rez;
        System.out.println(peoples);
        int counter =0;
        Iterator<String> iterator = peoples.iterator();
        int countPeople = peoples.size();
        while (countPeople>1){
            if (peoples.size()==1) break;
            iterator.next();
            if (counter==0){
                counter=1;
            }
            else {
                iterator.remove();
                counter=0;
                countPeople--;
            }
            if (!iterator.hasNext() &&countPeople>1) iterator = peoples.iterator();
        }
        rez = peoples.get(0);
        return rez;

    }
    public static class Timer{
        long iniTime;
        private Double Delta;
        Timer (){iniTime=System.nanoTime();}
        public String toString () {
            Delta = (double) (System.nanoTime()-iniTime)/1000;
            iniTime=System.nanoTime();
            return Delta.toString() + " микросекунд прошло";
        }
    }
}
