package by.it.livanovich.jd01_10;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        findAnnotation (Bean.class);
    }

    private static void findAnnotation(Class<Bean> beanClass) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Method[] methods = beanClass.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Param.class)){
               Object ob=beanClass.newInstance();
                System.out.println(m.getName() +" "+ m.invoke(ob,2,5));
            }
        }
    }

}
