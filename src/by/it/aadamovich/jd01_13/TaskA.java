package by.it.aadamovich.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (Exception e) {

            StackTraceElement[] trace = e.getStackTrace();
            for (StackTraceElement element : trace) {
                if (element.getClassName().equals(TaskA.class.getName())) {
                    System.out.printf("name: %s\n" +
                                      "class: %s\n" +
                                      "line: %d",
                            e.getClass().getName(), element.getClassName(), element.getLineNumber());
                    break;
                }
            }
        }
    }

}
