package by.it.lasotskaya.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception{
        Class<Bean> beanClass = Bean.class;
        Method[] methods = beanClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)){
                Param annotation = method.getAnnotation(Param.class);
                System.out.println(method.toString().replaceAll("by.it.lasotskaya.jd01_10.",""));
                System.out.println(method.invoke
                        (beanClass.newInstance(), annotation.a(), annotation.b()));
            }

            }
        }
   }

