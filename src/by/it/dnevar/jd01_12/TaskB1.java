package by.it.dnevar.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Map<String,Integer> res = new HashMap<>();
        Scanner sc=new Scanner(System.in);
        for (;;){
            String line = sc.next();
            if(line.equals("end")){
                break;
            }
            line = line.replaceAll("[^a-zA-z0-9'\\-/a-z]+"," ");
            list.addAll(Arrays.asList(line.split(" ")));
        }
        for (String word : list) {
            if(word=="don't" || word=="isn't"){
                word = "don't or isn't";
                res.put(word, res.containsKey(word) ? res.get(word)+1 : 1);
            }
            res.put(word, res.containsKey(word) ? res.get(word)+1 : 1);
        }
        System.out.println(res);

    }
}
