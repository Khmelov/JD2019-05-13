package by.it.guchek.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        final Class<String> stringClass = String.class;
        Method[] methodsStr = stringClass.getDeclaredMethods();

        for (Method method : methodsStr) {

            int modifiers = method.getModifiers();

            if (!Modifier.isStatic(modifiers)) {           //если модификатор нестатический
                System.out.println(method.getName());
            }
        }

    }
}