package by.it.yaskevich.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class printMath {

    public static void main(String[] args) {
        Class<Math> aClass = Math.class;

//        Field[] fields = aClass.getFields();
//        for (Field field : fields) {
//            System.out.println(field);
//        }

        Method[] methods = aClass.getMethods();
        StringBuilder stringMethod = new StringBuilder();
        for (Method method : methods) {
            stringMethod.setLength(0);
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                stringMethod.append("public ");
            }
            if ((Modifier.PRIVATE & modifiers) == Modifier.PRIVATE) {
                stringMethod.append("private ");
            }
            if ((Modifier.STATIC & modifiers) == Modifier.STATIC) {
                stringMethod.append("static ");
            }

            stringMethod.append(method.getReturnType().getSimpleName()).append(" ");
            stringMethod.append(method.getName());
            stringMethod.append("(");

            Class<?>[] parameterTypes = method.getParameterTypes();
            String delimiter = "";
            for (Class<?> parameterType : parameterTypes) {
                stringMethod.append(delimiter)
                        .append(parameterType.getSimpleName());
                delimiter = ", ";
            }

            stringMethod.append(")");
        }


    }
}
