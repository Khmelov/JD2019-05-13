package by.it.dnevar.jd01_12;

import java.lang.reflect.Array;
import java.util.*;

public class TaskB2 {
    public static void main(String[] args) {
        String[] peoplesAll = {"1","2","3","4","5","6"};
        ArrayList<String> peoples1 = new ArrayList<>(Arrays.asList(peoplesAll));
        LinkedList<String> peoples2 = new LinkedList<>(Arrays.asList(peoplesAll));
        System.out.println(process(peoples1));
        System.out.println(process(peoples2));
//"Dima","Ivan","Petr","Denis","Sasha","Mike","John","Alex"

    }

    static String process(ArrayList<String> peoples){
        ArrayList<String> buffer = peoples;
        int count=1;
        for (;buffer.size() > 1;){
            Iterator<String> iterator = buffer.iterator();
            if(count!=1){
                count = count - buffer.size();
            }
            while(iterator.hasNext()){
                if(buffer.indexOf(iterator.next())==count){
                    iterator.remove();
                    count++;
                }
            }
        }
        return buffer.get(0);
    }

    static String process(LinkedList<String> peoples){
        LinkedList<String> buffer = peoples;
        int count=1;
        for (;buffer.size() > 1;){
            Iterator<String> iterator = buffer.iterator();
            if(count!=1){
                count = count - buffer.size();
            }
            while(iterator.hasNext()){
                if(buffer.indexOf(iterator.next())==count){
                    iterator.remove();
                    count++;
                }
            }
        }
        return buffer.get(0);
    }
}
