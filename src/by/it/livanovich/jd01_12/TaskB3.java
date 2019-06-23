package by.it.livanovich.jd01_12;

import java.util.*;

public class TaskB3 {
    public static class Timer{
        private long iniTime;
        private Double Delta;
        private Timer () {
            iniTime=System.nanoTime();}
        public String toString (){
         Delta=(double)(System.nanoTime()-iniTime)/1000;
         iniTime=System.nanoTime();
         return "Прошло "+Delta.toString()+" микросекунд";
        }
    }
    static String process(ArrayList<String> peoples) {
        boolean check=true;
        do {
            Iterator<String> iterator=peoples.listIterator();
            if (check) {
                while (iterator.hasNext()) {
                    iterator.next();
                    if (iterator.hasNext()) {
                        iterator.next();
                        iterator.remove();
                    }
                    else check=false;
                }
            }
            else {
                while (iterator.hasNext()) {
                    iterator.next();
                    iterator.remove();
                    if (iterator.hasNext()) {
                        iterator.next();
                    }
                    else check=true;
                }
            }
        }
        while (peoples.size()>1);
        return peoples.get(0);
    }
    static String process (LinkedList<String> peoples){
        if (peoples.size()%2==0); boolean check=true;
        do {
            Iterator <String> iterator=peoples.listIterator();
            if (check) {
                while (iterator.hasNext()) {
                    iterator.next();
                    if (iterator.hasNext()) {
                        iterator.next();
                        iterator.remove();
                    }
                    else check=false;
                }
            }
            else {
                while (iterator.hasNext()) {
                    iterator.next();
                    iterator.remove();
                    if (iterator.hasNext()) {
                        iterator.next();
                    }
                    else check=true;
                }
            }
        }
        while (peoples.size()>1);
        return peoples.get(0);
    }
    static String processClone (LinkedList<String> peoples){
        while (peoples.size()>1){
            peoples.add(peoples.pop());
            peoples.pop();
        }
        return peoples.getFirst();
    }
    public static void main(String[] args) {
        Timer t=new Timer();
        List<String> arraylist=new ArrayList<>(4096);
        List <String> linkedlist=new LinkedList<>();
        for (int i=1; i<=4096; i++){
            arraylist.add("name"+i);
            linkedlist.add("name"+i);
        }
        process((ArrayList<String>) arraylist);
        System.out.println("ArrayList: "+t);
        process((LinkedList<String>) linkedlist);
        System.out.println ("LinkedList: "+t);
        processClone((LinkedList<String>) linkedlist);
        System.out.println ("LinkedListClone: "+t);
    }
}
