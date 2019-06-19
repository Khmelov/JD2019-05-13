package by.it.yakovets.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;
        Method[] methods = beanClass.getMethods();
        for (Method method : methods) {
            Object o = beanClass.newInstance();
            if (method.isAnnotationPresent(Param.class)) {
                Param p=method.getAnnotation(Param.class);
                double res=(double)method.invoke(o, p.a(),p.b());
                System.out.println(method.getName()+res);

            }


        }

    }
}
