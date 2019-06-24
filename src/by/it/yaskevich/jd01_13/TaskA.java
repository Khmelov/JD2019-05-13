package by.it.yaskevich.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        }
        catch (NumberFormatException | NullPointerException e) {
            System.out.printf("  name: %s\n", e.getClass().getName());
            System.out.printf(" class: %s\n", TaskA.class.getName());
            StackTraceElement[] stackTrace = e.getStackTrace();
            int line = 0;
            for (StackTraceElement element : stackTrace) {
                if (element.getClassName().equals(TaskA.class.getName())) {
                    line = element.getLineNumber();
                    break;
                }
            }
            System.out.printf(" line: %d\n", line);
        }
    }
}
