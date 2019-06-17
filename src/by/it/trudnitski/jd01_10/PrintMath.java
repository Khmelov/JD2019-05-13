package by.it.trudnitski.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> aClass = Math.class;
        Method[] methods = aClass.getDeclaredMethods();
        StringBuilder name=new StringBuilder();
        for (Method method : methods) {
            name.setLength(0);
            int modifiers = method.getModifiers();
            if(Modifier.isPublic(modifiers))
                name.append("public ");

             if((Modifier.STATIC & modifiers) == Modifier.STATIC){
                name.append("static "); }
            String simpleName = method.getReturnType().getSimpleName();
            name.append(simpleName)
                    .append(" ")
                    .append(method.getName())
                    .append('(');

            Class<?>[] parameterTypes = method.getParameterTypes();
            String delimeter="";
            for (Class<?> parameterType : parameterTypes) {
                name.append(delimeter).append(parameterType.getSimpleName());
                delimeter=",";
            }
            char firstP=name.charAt(0);
            if(firstP=='p') {
               System.out.println(name + ")");
            }
        }
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            name.setLength(0);
            int modifiers = field.getModifiers();
            if(Modifier.isPublic(modifiers))
                name.append("public ");
            if((Modifier.STATIC & modifiers) == Modifier.STATIC){
                name.append("static "); }
            name.append(field.getType()).append(" ").append(field.getName());
            char first=name.charAt(0);
            if(first=='p')
            System.out.println(name);
        }
    }
}
