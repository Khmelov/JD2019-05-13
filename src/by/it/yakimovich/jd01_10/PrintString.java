package by.it.yakimovich.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> sClass = String.class;
        Method[] methods = sClass.getMethods();
        StringBuilder name=new StringBuilder();
       // for (Method method:methods) {(int m= method.getModifiers());
            name.setLength(0);
         //   if (!((Modifier.STATIC) &m==!Modifier.STATIC))

          //  name.append(method.getName());
            System.out.println(name);
    }

}//}
