package by.it.dilkevich.jd01_12;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class TaskB1 {

    private Map<String,Integer> library = new HashMap<>();

    public void printMap(Map<String, Integer> map){

        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){

            System.out.println(iterator.next());
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String word = "";
        TaskB1 taskB1 = new TaskB1();

        while (!word.equals("end")){
            word = scanner.next();
            if(word.equals("end"))
                break;

            //[.,)(!-;]
            word = word.replaceAll( "[,]", "")
                    .replaceAll("[.]", "").replaceAll("[(]", "")
                    .replaceAll("[)]", "").replaceAll("[!]", "")
                    .replaceAll("[-]", "").replaceAll("[;]", "");
            if (taskB1.library.get(word) == null)
            taskB1.library.put(word, 1);

            else {
                taskB1.library.put(word, taskB1.library.get(word)+1);
            }
        }

        taskB1.printMap(taskB1.library);
    }
}
