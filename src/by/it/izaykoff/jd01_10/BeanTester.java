package by.it.izaykoff.jd01_10;

import by.it._examples_.jd01_10.sample_service.Init;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args)throws Exception {

        Class<Bean> beanClass = Bean.class;

        Bean bean = Bean.class.newInstance();



        Method[] methods = beanClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

//        Object bean=null;
//        for (Method method : methods) {
//            if (method.isAnnotationPresent(Param.class))
//            {
//             if (bean==null)
//                 bean=beanClass.newInstance();
//
////             method.invoke(bean);
//             System.out.println(method.invoke(bean));
//
//            }
//        }

    }
}
