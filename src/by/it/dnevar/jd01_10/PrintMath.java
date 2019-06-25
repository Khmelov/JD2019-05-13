package by.it.dnevar.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] declaredMethod = mathClass.getDeclaredMethods();
        StringBuilder stringMethods = new StringBuilder();

        for (Method method : declaredMethod) {
            stringMethods.setLength(0);

            int modifiers = method.getModifiers();

            if(Modifier.isPublic(modifiers)){
                stringMethods.append("public ");
            }else{
                continue;
            }

//            if(Modifier.isPrivate(modifiers)){
//                stringMethods.append("private ");
//            }

            if(Modifier.isStatic(modifiers)){
                stringMethods.append("static ");
            }

            stringMethods.append(method.getReturnType().getSimpleName())
                    .append(" ")
                    .append(method.getName())
                    .append("(");

            Class<?>[] parameterTypes = method.getParameterTypes();
            String delimiter = "";
            for (Class<?> parameterType : parameterTypes) {
                stringMethods.append(delimiter).append(parameterType.getSimpleName());
                delimiter = ",";
            }
            stringMethods.append(")");
            System.out.println(stringMethods);
        }

        Field[] declaredFields = mathClass.getDeclaredFields();
        StringBuilder stringField = new StringBuilder();

        for (Field declaredField : declaredFields) {
            stringField.setLength(0);

            int modifiers = declaredField.getModifiers();

            if(Modifier.isPublic(modifiers)){
                stringField.append("public ");
            }else{
                continue;
            }

            if(Modifier.isStatic(modifiers)){
                stringField.append("static ");
            }

            stringField.append(declaredField.getType().getSimpleName())
                    .append(" ")
                    .append(declaredField.getName());

            System.out.println(stringField);
        }
    }
}
