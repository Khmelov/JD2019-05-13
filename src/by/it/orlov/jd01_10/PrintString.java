package by.it.orlov.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {

    public static void main(String[] args) {

        Class<String> stringClass = String.class;
        Method[] dMet = stringClass.getDeclaredMethods();

        for (Method m : dMet) {

            if ((m.getModifiers()& Modifier.STATIC) == 0) {

                System.out.println(m.getName());
            }
        }
    }
}
