package by.it.dilkevich.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {

    public static void main(String[] args) {

        Class<String> stringClass = String.class;

        Method[] declaredMethods = stringClass.getDeclaredMethods();

        for (Method declaredMethod : declaredMethods) {

            int mod = declaredMethod.getModifiers();
            if(Modifier.isStatic(mod)){

            }
            else {

                System.out.println(declaredMethod.getName());
            }
        }
    }


}
