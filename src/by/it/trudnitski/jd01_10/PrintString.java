package by.it.trudnitski.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class <String> StringMethods=String.class;
        Method[] methods = StringMethods.getDeclaredMethods();
        StringBuilder name=new StringBuilder();
        for (Method method : methods) {
            int modifiers=method.getModifiers();
            if((Modifier.STATIC&modifiers)!=Modifier.STATIC) {
                name.append(method.getName()).append("\n");
            }
        }
        System.out.println(name);
    }

}
