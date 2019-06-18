package by.it.dilkevich.calc;

import java.util.*;

public class Printer {

    void print(Var variable){
        if (variable!= null)
        System.out.println(variable);
    }

    void printVar(){

        StringBuilder sb = new StringBuilder();
        Map<String, Var> map = Var.getVars();
        if(map.size()> 0){

            Set<Map.Entry<String, Var>> entries = map.entrySet();
            Iterator<Map.Entry<String, Var>> iterator = entries.iterator();
            while (iterator.hasNext()){

                Map.Entry<String, Var> next = iterator.next();

                sb = sb.append(next.getKey()).append("=").append(next.getValue());
                System.out.println(sb);
                sb.setLength(0);
            }

        }
    }
    void printSortVar(){

        StringBuilder sb = new StringBuilder();
        Map<String, Var> map = Var.getVars();
        List<String> list = new ArrayList<>();

        if(map.size()> 0){

            Set<Map.Entry<String, Var>> entries = map.entrySet();
            Iterator<Map.Entry<String, Var>> iterator = entries.iterator();
            Comparator<String> comp = new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            };
            while (iterator.hasNext()){

                Map.Entry<String, Var> next = iterator.next();

                sb = sb.append(next.getKey()).append("=").append(next.getValue());
                list.add(sb.toString());
                sb.setLength(0);
            }
            list.sort(comp);
            for (String s : list) {
                System.out.println(s);
            }

        }
    }
}
