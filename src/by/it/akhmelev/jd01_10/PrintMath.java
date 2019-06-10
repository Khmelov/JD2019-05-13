package by.it.akhmelev.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {


    public static void main(String[] args) {
        Class<Math> aClass = Math.class;

        Package aPackage = aClass.getPackage();

        Method[] methods = aClass.getDeclaredMethods();
        StringBuilder stringMethod = new StringBuilder();
        for (Method method : methods) {
            stringMethod.setLength(0);

            int modifiers = method.getModifiers();

            if (Modifier.isPublic(modifiers))
                stringMethod.append("public ");
            if (Modifier.isPrivate(modifiers))
                stringMethod.append("private ");
            if ((Modifier.STATIC & modifiers) == Modifier.STATIC)
                stringMethod.append("static ");
            String returnName = method.getReturnType().getSimpleName();
            stringMethod.append(returnName)
                    .append(' ')
                    .append(method.getName())
                    .append('(');

            Class<?>[] parameterTypes = method.getParameterTypes();
            String delimiter="";
            for (Class<?> parameterType : parameterTypes) {
                stringMethod.append(delimiter).append(parameterType.getSimpleName());
                delimiter=",";
            }

            stringMethod.append(')');
            System.out.println(stringMethod);

        }

    }
}
