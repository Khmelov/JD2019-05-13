package by.it.dilkevich.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {

    public static void main(String[] args) {


        Class<Math> mathClass = Math.class;

        Method[] m = mathClass.getDeclaredMethods();
        mathClass.getFields();

        StringBuilder sb = new StringBuilder();

        for (Method method : m) {

            sb.setLength(0);
//public static float abs(float)
            int mod = method.getModifiers();

            if (Modifier.isPublic(mod)){

                sb.append("public ");

                if (Modifier.isStatic(mod)){

                    sb.append("static ");
                }
            }


            Class<?> returnType = method.getReturnType();

            sb.append(returnType).append(" ");

            sb.append(method.getName()).append("(");

            Class<?>[] parameterTypes = method.getParameterTypes();


            String delimiter = "";
            for (Class<?> parameterType : parameterTypes) {

                sb.append(delimiter).append(parameterType.getName());

                delimiter = ",";
            }

            sb.append(")");
            System.out.println(sb);
        }

        System.out.println();
        Field[] fields = mathClass.getFields();

        for (Field field : fields) {

            sb.setLength(0);

            sb.append(field.getType()).append(" ").append(field.getName());

            System.out.println(sb);


        }
    }




}
