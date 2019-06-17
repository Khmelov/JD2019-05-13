package by.it.lasotskaya.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods=mathClass.getDeclaredMethods();
        Field[] fields = mathClass.getFields();
        for (Method method : methods) {
            if ((method.getModifiers()& Modifier.PUBLIC)==Modifier.PUBLIC){
                if ((method.getModifiers()& Modifier.STATIC)==Modifier.STATIC) {
                    System.out.println(method.toString().replaceAll("java.lang.Math.", ""));
                }
            }
        }
        for (Field field : fields) {
                System.out.println(field.toString().replaceAll("java.lang.Math.", ""));
        }

    }



}
