package by.it.maniuk.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> aClass = String.class;
        Method[] declaredMethod = aClass.getDeclaredMethods();
        StringBuilder fieldsBufferString = new StringBuilder();
        for (Method method : declaredMethod) {

            if (((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC)
                    && ((method.getModifiers() & Modifier.STATIC) != Modifier.STATIC)) {
                fieldsBufferString.append(method.getName());
               fieldsBufferString.append("\n");
            }
        }
        for (Method method : declaredMethod) {

            if (((method.getModifiers() & Modifier.PRIVATE) == Modifier.PRIVATE)
                    && ((method.getModifiers() & Modifier.STATIC) != Modifier.STATIC)) {
                fieldsBufferString.append(method.getName());
                fieldsBufferString.append("\n");
            }
        }

        System.out.println(fieldsBufferString);
    }

}
