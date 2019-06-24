package by.it.izaykoff.jd01_10;


import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args)throws Exception {

        Class<Bean> aClass = Bean.class;
        Object obj = aClass.getConstructor().newInstance();

        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods){
            if (method.isAnnotationPresent(Param.class))
            {
                Param p = method.getAnnotation(Param.class);
                double res = (double) method.invoke(obj,p.a(),p.b());
                System.out.println(method.getName() + res);
            }
        }


    }
}