package by.it.zhukova.jd01_12;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class TaskB3 {
    private static ArrayList<String> people1 = new ArrayList<String>() ;
    private static LinkedList<String> people2 = new LinkedList<String>();
    public static class Timer{
        private long iniTime;
        private Double Delta;
        public Timer () {iniTime=System.nanoTime();}
        public String toString (){
            Delta=(double) (System.nanoTime()-iniTime)/1000;
            iniTime=System.nanoTime();
            return "Прошло "+Delta.toString()+" микросекунд";
        }

    }
    public static void main(String[] args) {
        int N=4096;
        StringBuilder man = new StringBuilder("Man ");
        for (int i = 1; i < N; i++) {
            man.append(i);
            people1.add(man.toString());
            people2.add(man.toString());
            man.setLength(4);
        }
        Timer timer = new Timer();
        String winner1 = process(people1);
        System.out.println("Считалочка с ArrayList." +timer);
        System.out.println(winner1);

        String winner2 = process(people2);
        System.out.println("Считалочка с LinkedList." +timer);
        System.out.println(winner2);
    }
    static String process (ArrayList<String> peoples){
        boolean even = true;
        int position;
        while (peoples.size()>1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                String name = iterator.next();
                if (even) even=false;
                else {
                    iterator.remove();
                    even=true;
                }
            }
        }
        String winner=peoples.get(0);
        return winner;
    }
    static String process (LinkedList<String> peoples) {
        boolean even = true;
        int position;
        while (peoples.size()>1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                String name = iterator.next();
                if (even) even=false;
                else {
                    iterator.remove();
                    even=true;
                }
            }
        }
        String winner=peoples.get(0);
        return winner;
    }
}
