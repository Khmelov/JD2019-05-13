package by.it.maniuk.jd01_10;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {

        Class<Math> structMath = Math.class;
        Method[] methods = structMath.getDeclaredMethods();
        Field[] declaredFields = structMath.getDeclaredFields();
        StringBuilder name = new StringBuilder();
        for (Method method : methods) {
            if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC){
                name.append("public ");

            if ((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC)
                name.append("static ");

            if ((method.getModifiers() & Modifier.PRIVATE) == Modifier.PRIVATE)
                name.append("private ");}

            String returnName = method.getReturnType().getName();
            name.append(returnName)
                    .append(" ")
                    .append(method.getName())
                    .append("(");
            Class<?>[] parameterTypes = method.getParameterTypes();
            String delimeter = "";
            for (Class<?> parameter : parameterTypes) {
                name.append(delimeter).append(parameter.getSimpleName());
                delimeter = ",";
            }
            name.append(")").append("\n");
        }

        for (Field declaredF : declaredFields) {
           String returnName = declaredF.getType().getName();
           if ((declaredF.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC){
           name.append(returnName)
                   .append(" ")
                   .append(declaredF.getName())
           .append("\n");}
        }


            // name.append("}");
            System.out.println(name);

    }
}

