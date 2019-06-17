package by.it.guchek.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {

    public static void main(String[] args) {

        Class<Math> struktMathClass = Math.class; //Получили класс Math
        Method[] declaredMethods = struktMathClass.getDeclaredMethods();//выбрать описанные в этом классе методы
        StringBuilder sbMetod = new StringBuilder();

        for (Method method : declaredMethods) {
            sbMetod.setLength(0);
            if (Modifier.isPublic(method.getModifiers())) {                      //1-й вар
                sbMetod.append("public ");

                if ((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC)  //2-ой вар
                    sbMetod.append("static ");
                sbMetod.append(method.getReturnType().getSimpleName()).append(" ").append(method.getName()).append("(");

                String delimetr = "";
                Class<?>[] parameterTypes = method.getParameterTypes();

                for (Class<?> parameterType : parameterTypes) {            //добрались до параметра в массиве
                    sbMetod.append(delimetr).append(parameterType);
                    delimetr = ",";
                }

                sbMetod.append(")");

                System.out.println(sbMetod);
            }
        }

        final Field[] fields = struktMathClass.getFields();              //публичные поля
        for (Field field : fields) {
            if (Modifier.isPublic(field.getModifiers())) {
                System.out.print(field.getType().getSimpleName() + " ");
                System.out.print(field.getName());
                System.out.println();

            }

        }
    }
}