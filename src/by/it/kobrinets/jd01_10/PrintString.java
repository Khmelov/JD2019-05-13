package by.it.kobrinets.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {

    public static void main(String[] args) {

        Class<String> stringClass = String.class;
        Method[] declaredMethods = stringClass.getDeclaredMethods();

        for (Method method : declaredMethods) {

            if ((method.getModifiers() & Modifier.STATIC) == 0) {

                System.out.println(method.getName());
            }
        }
    }
}