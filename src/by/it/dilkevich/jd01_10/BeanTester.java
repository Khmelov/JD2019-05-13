package by.it.dilkevich.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class BeanTester {

    public static void main(String[] args) throws Exception{

        Class<Bean> beanClass = Bean.class;

        Method[] declaredMethods = beanClass.getDeclaredMethods();

        Object o = null;

        for (Method declaredMethod : declaredMethods) {

            if (declaredMethod.isAnnotationPresent(Param.class)){

                Param param = declaredMethod.getAnnotation(Param.class);

                if (o == null){

                    o = beanClass.newInstance();
                }

                double result = (double)declaredMethod.invoke(o, param.a(), param.b());
                System.out.println(declaredMethod.getName());
                System.out.println(result);

            }

        }
    }
}

