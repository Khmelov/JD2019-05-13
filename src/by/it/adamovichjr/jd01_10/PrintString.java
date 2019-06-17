package by.it.adamovichjr.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        Method[] methods = stringClass.getDeclaredMethods();
        StringBuffer sb = new StringBuffer();
        for (Method method : methods) {
            if((method.getModifiers() & Modifier.STATIC) != Modifier.STATIC){
                sb.append(method.getName());
                System.out.println(sb);
                sb.setLength(0);
            }
        }
    }
}
