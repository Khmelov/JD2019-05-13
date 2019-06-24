package by.it.izaykoff.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {

        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getMethods();
        StringBuilder stringMethods = new StringBuilder();

        for (Method method : methods) {
            stringMethods.setLength(0);

            int modifiers = method.getModifiers();

            if (Modifier.isPublic(modifiers))
                stringMethods.append("public ");
            if (Modifier.isPrivate(modifiers))
                stringMethods.append("private ");
            if (Modifier.isStatic(modifiers))
                stringMethods.append("static ");

            String returnName = method.getReturnType().getSimpleName();
            stringMethods.append(returnName)
                    .append(' ')
                    .append(method.getName())
                    .append('(');

            Class<?>[] parameterTypes = method.getParameterTypes();
            String delimiter = "";
            for (Class<?> parameterType : parameterTypes) {
                stringMethods.append(delimiter).append(parameterType.getSimpleName());
                delimiter = ",";
            }

            stringMethods.append(')');
            System.out.println(stringMethods);

        }


        Field[] fields = mathClass.getFields();
        StringBuilder stringFields = new StringBuilder();

        for (Field field : fields) {
            stringFields.setLength(0);

            int modifiers = field.getModifiers();

            if (Modifier.isPublic(modifiers))
                stringFields.append("public ");
            if (Modifier.isPrivate(modifiers))
                stringFields.append("private ");
            if (Modifier.isStatic(modifiers))
                stringFields.append("static ");

            String returnName = field.getType().getSimpleName();
            stringFields.append(returnName).append(' ').append(field.getName());


            System.out.println(stringFields);


        }

    }
}
