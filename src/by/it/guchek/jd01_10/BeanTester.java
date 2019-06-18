package by.it.guchek.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception{

        Class<Bean> exemplBeanClass = Bean.class;                     // создала объект класса Bean
        Method[] methodsBean = exemplBeanClass.getDeclaredMethods(); // массив объявленных методов Bean

                                                                   //Object o = exemplarBeanClass.newInstance();
        for (Method method : methodsBean) {
            if (method.isAnnotationPresent(Param.class)){

                Param param = method.getAnnotation(Param.class);
                double res = (double) method.invoke(exemplBeanClass.newInstance(), param.a (), param.b());
                System.out.print(method.getName()+" ");
                System.out.println(res);

            }
        }
    }
}
