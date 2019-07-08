package by.it.tbabich.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (Exception e) {
            System.out.println("name: " + e.getClass().getName());
            System.out.println("class: " + TaskA.class.getName());
            System.out.println("line: " + e.getLocalizedMessage());
        }
    }
}
