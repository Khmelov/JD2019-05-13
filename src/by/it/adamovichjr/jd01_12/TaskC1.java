package by.it.adamovichjr.jd01_12;

import java.util.*;

public class TaskC1 {
    public static void main(String[] args) {
        List<String> objects = createObjects();
        int lenght = objects.size();
        Set<Integer> cipher = createCipher(lenght);
        Map<Integer,String>map = new TreeMap<>();

        putMap(map,objects,cipher);
        System.out.println(map);
        deleteDuplicats(map);
        System.out.println(map);
    }

    private static List<String>createObjects(){
        Scanner sc = new Scanner(System.in);
        List<String>objects = new ArrayList<>();
        String object;
        while (!(object=sc.next()).equals("end")){
            objects.add(object);
        }
        return objects;
    }

    private static Set<Integer>createCipher(int lenght){
        Random random = new Random();
        Set<Integer>cipher = new HashSet<>();
        while (cipher.size() !=lenght){
            cipher.add(random.nextInt());
        }
        return cipher;
    }
    private static void putMap(Map<Integer,String>map,List<String>list,Set<Integer>set){
        Iterator<String> listIt = list.iterator();
        Iterator<Integer> setIt = set.iterator();
        while (listIt.hasNext()){
            map.put(setIt.next(),listIt.next());
        }
    }
    private static void deleteDuplicats(Map<Integer,String>map){
        Set<String>objects = new HashSet<>();
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        while (it.hasNext()){
           Map.Entry<Integer,String>entry = it.next();
           if(objects.contains(entry.getValue())){
               it.remove();
           }else {
               objects.add(entry.getValue());
           }

        }


    }

}
