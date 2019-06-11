package by.it.buymistrov.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {

    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;

        Field[] fields = mathClass.getFields();

        for (Field field : fields) {
            System.out.println(field);
        }

        Method[] methods = mathClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        StringBuilder name = new StringBuilder();

        for (Method method : methods) {

            name.setLength(0);


            int modifiers = method.getModifiers();
            if ((Modifier.isPublic(modifiers))) {
                name.append("public ");
                if ((Modifier.isPrivate(modifiers))) {
                    name.append("private ");
                    if ((Modifier.isStatic(modifiers))) {
                        name.append("static ");

                        String returnName = method.getReturnType().getSimpleName();

                        name.append(returnName).append(' ').append(method.getName());

                        Class<?>[] parameterTypes = method.getParameterTypes();
                        String delimeter = "";

                        for (Class<?> parameterType : parameterTypes) {
                            name.append(delimeter).append(parameterType.getSimpleName());
                            delimeter = ",";
                        }



                    }





                }


            }
            System.out.println(name);


        }
    }
}

