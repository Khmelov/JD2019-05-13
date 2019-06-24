package by.it.yaskevich.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;
        Class<Param> paramClass = Param.class;

        Bean instance = beanClass.newInstance();

        Method[] beanMethods = beanClass.getDeclaredMethods();
        for (Method beanMethod : beanMethods) {
            if (beanMethod.isAnnotationPresent(paramClass)) {

                Param beanMethodAnnotation = beanMethod.getAnnotation(paramClass);
                Class<? extends Annotation> beanMethodAnnotationType = beanMethodAnnotation.annotationType();
                int a = (int)beanMethodAnnotationType.getMethod("a").invoke(beanMethodAnnotation);
                int b = (int)beanMethodAnnotationType.getMethod("b").invoke(beanMethodAnnotation);

                double result;
                if (Modifier.isStatic(beanMethod.getModifiers()))
                    result = (double)beanMethod.invoke(null, a, b);
                else
                    result = (double)beanMethod.invoke(instance, a, b);

                System.out.println(beanMethod.getName() + " " + result);
            }
        }
    }
}
