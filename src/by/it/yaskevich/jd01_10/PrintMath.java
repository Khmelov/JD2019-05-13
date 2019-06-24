package by.it.yaskevich.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {

    public static void main(String[] args) {
        Class<Math> aClass = Math.class;

        StringBuilder stringMethod = new StringBuilder();

        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            stringMethod.setLength(0);

            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers))
                stringMethod.append("public ");
            else
                continue;
            if (Modifier.isStatic(modifiers))
                stringMethod.append("static ");

            stringMethod
                    .append(method.getReturnType().getSimpleName())
                    .append(" ")
                    .append(method.getName())
                    .append("(");

            Class<?>[] parameterTypes = method.getParameterTypes();
            String delimiter = "";
            for (Class<?> parameterType : parameterTypes) {
                stringMethod
                        .append(delimiter)
                        .append(parameterType.getSimpleName());
                delimiter = ",";
            }

            stringMethod.append(")");

            System.out.println(stringMethod);
        }

        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            stringMethod.setLength(0);

            if (Modifier.isPublic(field.getModifiers()))
                stringMethod
                        .append(field.getType().getSimpleName())
                        .append(" ")
                        .append(field.getName());
            else
                continue;

            System.out.println(stringMethod);
        }
    }
}
