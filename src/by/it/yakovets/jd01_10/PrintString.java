package by.it.yakovets.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> sClass = String.class;
        StringBuilder sb = new StringBuilder();
        Method[] methods = sClass.getDeclaredMethods();
        for (Method method : methods) {
            if (((method.getModifiers() & Modifier.STATIC) != Modifier.STATIC)) {
                sb.append(method.getName());
                System.out.println(sb);
                sb.setLength(0);
            }
        }

    }
}
