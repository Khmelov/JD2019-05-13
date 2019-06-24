package by.it.trudnitski.jd01_12;

import java.util.*;

public class TaskC1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list=new ArrayList<>();
        Random randome=new Random();

        for (;;) {
            String txt = sc.next();
            list.add(txt);
            if(txt.equals("end")) break;
        }

        Map<Integer,String> map=new TreeMap<>();
        for (int i = 0; i <list.size() ; i++) {
            map.put(randome.nextInt(2500),list.get(i));
        }
        Set<String> newMap=new HashSet<>();
        for (Iterator itr=map.entrySet().iterator();itr.hasNext();) {
          Map.Entry<Integer,String> entry= (Map.Entry<Integer, String>) itr.next();
          String value=entry.getValue();
          if(!newMap.add(value)){
              itr.remove();
          }
        }
        System.out.println(map);


    }
}
