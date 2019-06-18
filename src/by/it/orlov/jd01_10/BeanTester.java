package by.it.orlov.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
        public static void main(String[] args) throws Exception {

            Class<Bean> bC = Bean.class;
            Object bean = bC.getDeclaredConstructor().newInstance();
            Method[] met = bC.getDeclaredMethods();
            Param annotation;
            for (Method sub : met) {
                if (sub.isAnnotationPresent(Param.class)) {

                    annotation = sub.getAnnotation(Param.class);
                    double result = (double) (sub.invoke(bean, annotation.a(), annotation.b()));
                    System.out.println("Имя метода: " + sub.getName() + " Результат: " + result);
                }
            }
        }
    }

