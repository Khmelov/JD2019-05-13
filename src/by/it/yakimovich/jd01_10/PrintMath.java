package by.it.yakimovich.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> aClass = Math.class;
        Method[] methods=aClass.getDeclaredMethods();
        StringBuilder name=new StringBuilder();
        for (Method method:methods) {int modifiers=method.getModifiers();
            name.setLength(0);
            if((Modifier.PUBLIC&modifiers) ==Modifier.PUBLIC){
                if((Modifier.STATIC&modifiers) ==Modifier.STATIC)
                    name.append("public").append(' ');
                    name.append("static").append(' ');}
            else continue;

                String returnName=method.getReturnType().getSimpleName();
            name.append(returnName).append(' ').append(method.getName()).append('(');
            Class<?>[] parameterTypes = method.getParameterTypes();
            String delimeter="";
            for (Class<?> parameterType : parameterTypes) {
                name.append(delimeter).append(parameterType.getSimpleName());
                delimeter=",";
            }
            name.append(')');
            System.out.println(name);
                    }
        System.out.println("double E");
        System.out.println("double PI");
    }

}