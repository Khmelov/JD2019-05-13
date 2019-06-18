package by.it.dnevar.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {

            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch(NumberFormatException | NullPointerException e){
            String name = e.getClass().getName();
            String className = TaskA.class.getName();

            System.out.printf(""+
                    "  name: %s\n" +
                    " class: %s\n" +
                    "  line: %d",name,className);
        }
    }
}
