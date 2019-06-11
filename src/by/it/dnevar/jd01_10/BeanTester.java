package by.it.dnevar.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {

    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;

        Method[] declaredMethods = beanClass.getDeclaredMethods();
        Object o = beanClass.newInstance();;

        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.isAnnotationPresent(Param.class)) {
                Param p = declaredMethod.getAnnotation(Param.class);
                double res = (double) declaredMethod.invoke(o,p.a(),p.b());
                System.out.println(declaredMethod.getName()+ res);
            }
        }



    }
}
