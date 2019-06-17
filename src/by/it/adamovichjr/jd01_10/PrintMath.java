package by.it.adamovichjr.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        Field[] fields = mathClass.getFields();
        StringBuffer sb = new StringBuffer();
        for (Method method : methods) {
            String delimeter = "";
            if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                sb.append("public ");
                if ((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC)
                    sb.append("static ");
                sb.append(method.getReturnType()).append(' ').append(method.getName()).append('(');
                Type[] parameters = method.getGenericParameterTypes();
                for (Type parameter : parameters) {
                    sb.append(delimeter).append(parameter);
                    delimeter = ",";
                }
                sb.append(')');
                System.out.println(sb);
                sb.setLength(0);
            }
        }
        for (Field field : fields) {
            if((field.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC){
                sb.append("public ");
                if ((field.getModifiers() & Modifier.STATIC) == Modifier.STATIC)
                    sb.append("static ");
                if ((field.getModifiers() & Modifier.FINAL) == Modifier.FINAL)
                    sb.append("final ");
                sb.append(field.getType()).append(' ').append(field.getName());
                System.out.println(sb);
                sb.setLength(0);
            }
        }
    }
}
