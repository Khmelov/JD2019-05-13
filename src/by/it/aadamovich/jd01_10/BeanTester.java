package by.it.aadamovich.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {

    public static void main(String[] args) throws Exception {

        Class<Bean> beanClass = Bean.class;
        Object bean = beanClass.getDeclaredConstructor().newInstance();
        Method[] declaredMethods = beanClass.getDeclaredMethods();
        Param annotation;

        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(Param.class)) {

                annotation = method.getAnnotation(Param.class);
                double res = (double) (method.invoke(bean, annotation.a(), annotation.b()));

                System.out.println("Имя метода: " + method.getName() + " Результат: " + res);
            }
        }
    }
}
