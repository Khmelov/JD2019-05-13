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
                double res = (double) (method.invoke(beanClass.newInstance(), anatation.a(), anatation.b()));
               System.out.println("Имя метода: " + method.getName() + " Результат: " + res);
            }
        }

        }

    }




