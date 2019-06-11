package by.it.yakovets.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> aClass = Math.class;
//        Field[] fields = aClass.getFields();
//        for (Field field : fields) {
//            System.out.println(field);
        Method[] methods = aClass.getMethods();
        StringBuilder name = new StringBuilder();
        for (Method method : methods) {
            name.setLength(0);
            int modifiers = method.getModifiers();
            if ((Modifier.PUBLIC & modifiers) == Modifier.PUBLIC)
                name.append("public ");
            if ((Modifier.PRIVATE & modifiers) == Modifier.PRIVATE)
                name.append("private ");
            if ((Modifier.STATIC & modifiers) == Modifier.STATIC)
                name.append("static ");
            String simpleName = method.getReturnType().getSimpleName();
            name.append(simpleName)
                    .append(' ')
                    .append(method.getName())
                    .append("(");

            name.append(')');
            System.out.println(name);

        }


    }

}



