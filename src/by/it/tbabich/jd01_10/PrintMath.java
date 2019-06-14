package by.it.tbabich.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getMethods();
        StringBuilder name = new StringBuilder();
        for (Method method : methods) {
            name.setLength(0);
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers));
                name.append("public ");
            if ((Modifier.STATIC & modifiers) == Modifier.STATIC)
                name.append("static ");
            name.append(method.getReturnType().getSimpleName()).append(' ');
            name.append(method.getName()).append("(");
            Class<?>[] parameterTypes = method.getParameterTypes();
            String delimiter = "";
            for (Class<?> parameterType : parameterTypes) {
                name.append(delimiter).append(parameterType.getSimpleName());
                delimiter = ",";
            }
            name.append(")");
            System.out.println(name);
        }

        Field[] fields = mathClass.getFields();
        for (Field field : fields) {
            name.setLength(0);
            int modifiers = field.getModifiers();
            if (Modifier.isPublic(modifiers));
            name.append("public ");
            if ((Modifier.STATIC & modifiers) == Modifier.STATIC)
                name.append("static ");
            name.append(field.getType()).append(' ').append(field.getName());
            System.out.println(name);
        }

    }
}
