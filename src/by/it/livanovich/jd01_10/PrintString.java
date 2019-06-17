package by.it.livanovich.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> aClass = String.class;
        Method[] methods = aClass.getDeclaredMethods();
        for (Method m : methods) {
            if ((m.getModifiers() & Modifier.STATIC) != Modifier.STATIC) {
                System.out.println(m.getName());
            }
        }
    }
}