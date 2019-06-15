package by.it.zhukova.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> aClass = Bean.class;

        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class))
                try {
                    Param ann = method.getAnnotation(Param.class);
                    Object o = aClass.newInstance();
                    Double d = (Double) method.invoke(o, ann.a(), ann.b());
                    System.out.println(method.getName());
                    System.out.println(d);
                }
            catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }
}
