package by.it.adamovichjr.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception{
        Class<Bean> beanClass = Bean.class;
        Method[] methods = beanClass.getDeclaredMethods();
        Object o = beanClass.newInstance();
        for (Method method : methods) {
            if(method.isAnnotationPresent(Param.class)){

                Param param = method.getAnnotation(Param.class);
                double result = (double) method.invoke(o,param.a(),param.b());

                System.out.println(method.getName()+ result);
                System.out.printf("%s  %.1f\n",method.getName(),result );
            }
        }
    }
}
