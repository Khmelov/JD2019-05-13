package by.it.dnevar.jd01_12;

import java.util.*;

public class TaskB3 {
    public static void main(String[] args) {
        Random names = new Random(39);
        int size = 4096;
        String[] peoplesAll = new String[size];
        for (int i = 0; i < size; i++) {
            int name = 1 + names.nextInt(size);
            peoplesAll[i]= Integer.toString(name);
        }

        ArrayList<String> peoples1 = new ArrayList<>(Arrays.asList(peoplesAll));
        LinkedList<String> peoples2 = new LinkedList<>(Arrays.asList(peoplesAll));

        Timer t=new Timer();
        System.out.println(process(peoples1));
        System.out.println("Время работы метода с ArrayList: "+t);

        System.out.println(process(peoples2));
        System.out.println("Время работы метода с LinkedList: "+t);

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
// время сопостовимое с работой эго же метода с ArrayList

//        int count=1;
//        for (;peoples.size() > 1;){
//            Iterator<String> iterator = peoples.iterator();
//            if(count!=1){
//                count = count - peoples.size();
//            }
//            while(iterator.hasNext()){
//                if(peoples.indexOf(iterator.next())==count){
//                    iterator.remove();
//                    count++;
//                }
//            }
//        }
//----------------------------------------------------------------------
// данная реализация работает в примерно 4-5 раза быстрее
        while(peoples.size()>1){
            for (int i = 0; i < peoples.size(); i++) {
                if(i%2!=0){
                    String removedPerson = peoples.remove(i);
                }
            }
        }

        return peoples.get(0);
    }
}
