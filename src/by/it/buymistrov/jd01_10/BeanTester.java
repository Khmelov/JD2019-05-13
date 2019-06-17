package by.it.buymistrov.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BeanTester {

    public static void main(String[] args) throws Exception {

        Class<?> aClass = Class.forName("by.it.buymistrov.jd01_10.Bean");
//        Constructor<?> constructor = aClass.getDeclaredConstructor();
//        Object o = constructor.newInstance();

        Class anno = Class.forName("by.it.buymistrov.jd01_10.Param");


        Method a = anno.getMethod("a");
        Method b = anno.getMethod("b");


        Object o1 = aClass.getDeclaredConstructor().newInstance();

        Method[] declaredMethods1 = aClass.getDeclaredMethods();



        for (Method declaredMethod : declaredMethods1) {

            if (declaredMethod.isAnnotationPresent(anno)) {

                Annotation annotation = declaredMethod.getAnnotation(anno);

                Object invoke = a.invoke(annotation);
                Object invoke1 = b.invoke(annotation);

                double res;
                if ((declaredMethod.getModifiers() & Modifier.STATIC) == Modifier.STATIC) {
                    res = (double) declaredMethod.invoke(null, invoke, invoke1);
                } else {
                    res = (double) declaredMethod.invoke(o1, invoke, invoke1);

                }

                System.out.println(res);
            } else continue;


            System.out.println(declaredMethod);
        }

    }
}
