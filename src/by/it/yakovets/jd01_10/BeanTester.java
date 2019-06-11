package by.it.yakovets.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;
        Method[] methods = beanClass.getMethods();
        Object o = null;
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                o = beanClass.newInstance();
//                method.invoke(o, Pa);

            }


        }

    }
}
