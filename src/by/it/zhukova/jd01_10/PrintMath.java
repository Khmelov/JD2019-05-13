package by.it.zhukova.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> aClass = Math.class;
        Field[] fields = aClass.getDeclaredFields();
        StringBuilder name = new StringBuilder();
        for (Field field : fields) {
            name.setLength(0);
            int modifiers = field.getModifiers();
            if (Modifier.isPublic(modifiers)){
                name.append("public ");
                if (Modifier.isStatic(modifiers))
                    name.append("static ");
                if (Modifier.isFinal(modifiers))
                    name.append("final ");
                name.append(field.getType().getSimpleName()).append(' ').append(field.getName());
                System.out.println(name);}
        }

        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            name.setLength(0);
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)){
                name.append("public ");
            if (Modifier.isStatic(modifiers))
                name.append("static ");

                String returnName = method.getReturnType().getSimpleName();
                name.append(returnName).append(' ');

name.append(method.getName()).append('(');
                Class<?>[] parameterTypes = method.getParameterTypes();
                String delimiter = "";
            for (Class <?> parameter : parameterTypes) {
             name.append(delimiter).append(parameter.getSimpleName());
             delimiter=",";
            }
            name.append(')');
            System.out.println(name);}
        }
    }

}
