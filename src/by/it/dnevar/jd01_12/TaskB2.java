package by.it.dnevar.jd01_12;

import java.lang.reflect.Array;
import java.util.*;

public class TaskB2 {
    public static void main(String[] args) {
        String[] peoplesAll = {"Dima","Ivan","Petr","Denis","Sasha","Mike","John","Alex"};
        ArrayList<String> peoples1 = new ArrayList<>(Arrays.asList(peoplesAll));
        LinkedList<String> peoples2 = new LinkedList<>(Arrays.asList(peoplesAll));
        System.out.println(process(peoples1));
        System.out.println(process(peoples2));

    }

    private static String process(ArrayList<String> peoples){
        int count=1;
        for (;peoples.size() > 1;){
            Iterator<String> iterator = peoples.iterator();
            if(count!=1){
                count = count - peoples.size();
            }
            while(iterator.hasNext()){
                if(peoples.indexOf(iterator.next())==count){
                    iterator.remove();
                    count++;
                }
            }
        }
        return peoples.get(0);
    }

    private static String process(LinkedList<String> peoples){
        int count=1;
        for (;peoples.size() > 1;){
            Iterator<String> iterator = peoples.iterator();
            if(count!=1){
                count = count - peoples.size();
            }
            while(iterator.hasNext()){
                if(peoples.indexOf(iterator.next())==count){
                    iterator.remove();
                    count++;
                }
            }
        }
        return peoples.get(0);
    }
}
