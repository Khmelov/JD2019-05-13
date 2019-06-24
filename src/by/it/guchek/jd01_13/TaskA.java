package by.it.guchek.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) /*throws RuntimeException*/ {

        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        }
        catch (Exception e) {
            //e.printStackTrace(); распечатать стек путей ошибок
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {

                if (TaskA.class.getName().equals(element.getClassName())){

                    String name = e.getClass().getName(); //информация об эксепшене
                    String className= element.getClassName(); //инф о классе в котором возникла ошибка
                    int number = element.getLineNumber();

                    System.out.printf(" name: %s\n", name);
                    System.out.printf("class: %s\n", className);
                    System.out.printf(" line: %d", number);
                    break;
                }

            }
        }
    }
}
