package by.it.yakimovich.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> sClass = String.class;
        Method[] methods = sClass.getDeclaredMethods();
        StringBuilder name=new StringBuilder();
        for (Method method:methods) {
        int m= method.getModifiers();
           if ((Modifier.STATIC&m)!=Modifier.STATIC)
           name.append(method.getName()).append("\n");
    }
        System.out.println(name);

}}
