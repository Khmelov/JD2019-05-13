package by.it.trudnitski.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception{
        Class<Bean> BeanTes=Bean.class;
        BeanTes.getDeclaredAnnotations();
        Method[] methods = BeanTes.getDeclaredMethods();
        Object o=null;
        for (Method m : methods) {
            if(m.isAnnotationPresent(Param.class)){
                Param p=m.getAnnotation(Param.class);
                if(o==null) {
                    o = BeanTes.newInstance();
                }
                double res=(double) m.invoke(o,p.a(),p.b());
                System.out.println(m.getName()+" "+res);
            }

        }
    }
}
