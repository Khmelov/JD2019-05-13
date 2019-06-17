package by.it.yakovets.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> aClass = Math.class;

        Method[] methods = aClass.getDeclaredMethods();
        StringBuilder name = new StringBuilder();
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            name.setLength(0);
            int modifiers = field.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                name.append("public ");
                if (Modifier.isStatic(modifiers))
                    name.append("static ");
                if (Modifier.isFinal(modifiers))
                    name.append("final ");
            }
            Class<?> type = field.getType();
            name.append(type).append(' ');
            String nameField = field.getName();
            name.append(nameField);
            System.out.println(name);
        }

        for (Method method : methods) {
            name.setLength(0);
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                name.append("public ");
                if (Modifier.isPrivate(modifiers))
                    name.append("private ");
                if (Modifier.isStatic(modifiers))
                    name.append("static ");
                if (Modifier.isFinal(modifiers))
                    name.append("final ");

                String simpleName = method.getReturnType().getSimpleName();
                name.append(simpleName)
                        .append(' ')
                        .append(method.getName())
                        .append("(");
                Class<?>[] parameterTypes = method.getParameterTypes();
                String delimiter = "";
                for (Class<?> parameterType : parameterTypes) {
                    name.append(delimiter).append(parameterType.getSimpleName());
                    delimiter = ",";
                }

                name.append(')');
                System.out.println(name);
            }
        }


    }

}



