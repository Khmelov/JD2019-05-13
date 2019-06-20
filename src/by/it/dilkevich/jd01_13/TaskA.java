package by.it.dilkevich.jd01_13;

import java.util.HashMap;

public class TaskA {

    public static void main(String[] args) {

        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");

        } catch (NumberFormatException | NullPointerException e) {

            StringBuilder sb = new StringBuilder();
            sb.append("  name: ").append(e.getClass());
            sb.append("\n class: ").append(TaskA.class.getName());

            StackTraceElement[] stackTrace = e.getStackTrace();
            for (int i = 0; i < stackTrace.length; i++) {

                if (stackTrace[i].getClassName().equals(TaskA.class.getName())){

                    sb.append("\n  line: ").append(i+1);

                }
            }
            System.out.println(sb);
        }
    }
}
