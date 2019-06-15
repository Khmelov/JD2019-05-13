package by.it.tbabich.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception{
        Class<Bean> beanClass = Bean.class;
        Param param;
        Method[] methods = beanClass.getDeclaredMethods();
        Object o = null;
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)){
                param = method.getAnnotation(Param.class);
                if (o == null)
                    o = beanClass.newInstance();
                System.out.println(method.getName());
                System.out.println(method.invoke(o, param.a(), param.b()));
            }
        }
    }
}
