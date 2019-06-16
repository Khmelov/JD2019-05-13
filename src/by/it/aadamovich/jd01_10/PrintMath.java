package by.it.aadamovich.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {

    public static void main(String[] args) {

        Class<Math> mathClass = Math.class;
        Method[] declaredMethods = mathClass.getDeclaredMethods();
        StringBuilder str = new StringBuilder();

        for (Method method : declaredMethods) {

            if ((method.getModifiers() & Modifier.PUBLIC) != 0) {
                str.append("public static ")
                        .append(method.getReturnType())
                        .append(" ")
                        .append(method.getName())
                        .append("(");

                Class<?>[] parameterTypes = method.getParameterTypes();
                String delimeter = "";

                for (Class<?> type : parameterTypes) {
                    str.append(delimeter).append(type);
                    delimeter = ",";
                }
                str.append(")");
                System.out.println(str);
                str.delete(0, str.length());
            }
        }

        Field[] declaredFields = mathClass.getDeclaredFields();

        for (Field field : declaredFields) {

            if ((field.getModifiers() & Modifier.PUBLIC) != 0) {
                str.append("public static final ")
                        .append(field.getType())
                        .append(" ")
                        .append(field.getName());

                System.out.println(str);
                str.delete(0, str.length());
            }
        }
    }
}
