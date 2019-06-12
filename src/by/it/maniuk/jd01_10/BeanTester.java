package by.it.maniuk.jd01_10;


import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;
        Method[] methods = beanClass.getDeclaredMethods();
        Param anatation;
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)){
            anatation = method.getAnnotation (Param.class);
                System.out.println(anatation);

                method.invoke(Param.class);

            }
        }

        }

    }




