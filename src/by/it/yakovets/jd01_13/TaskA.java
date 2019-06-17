package by.it.yakovets.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NumberFormatException | NullPointerException e) {
            String name = e.getClass().getName();
            String className = TaskA.class.getClass().getName();
            StackTraceElement[] stackTrace = e.getStackTrace();
            int line = 0;
//            for (StackTraceElement element : stackTrace) {
//                if(element.getClassName().equals(className))
//                System.out.println(element);
//                break;
//
//            System.out.printf(""+
//                    "  name: %s\n"+
//                    "  class: %s\n"+
//                    "  line: %s\n",
//                    name,className,element.getLineNumber());
//        }
        }


    }
}
