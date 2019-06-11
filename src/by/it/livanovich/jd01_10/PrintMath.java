package by.it.livanovich.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> aClass = Math.class;
        Method[] method = aClass.getDeclaredMethods();
        StringBuilder name = new StringBuilder();
        for (Method m : method) {
            if ((m.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                name.append("public ");
                if ((m.getModifiers() & Modifier.STATIC) == Modifier.STATIC) {
                    name.append("static ");
                }
                name.append(m.getReturnType().getSimpleName()).append(" ");
                name.append(m.getName());
                name.append("(");
                Class<?>[] parameterTypes = m.getParameterTypes();
                String delimeter = "";
                for (Class<?> parameterType : parameterTypes) {
                    name.append(delimeter).append(parameterType.getSimpleName());
                    delimeter = ",";
                }
                name.append(")\n");
            }
        }
        System.out.println(name);
        Field[] fields = aClass.getFields();
        for (Field f : fields) {
            if ((f.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                name.append(f.getType().getSimpleName());
                name.append(" ").append(f.getName()).append("\n");

            }

        }
        System.out.println(name);

    }
}