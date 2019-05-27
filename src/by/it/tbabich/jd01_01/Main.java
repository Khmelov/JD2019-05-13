package by.it.tbabich.jd01_01;

import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        System.out.println("Hello World!");
//        int i;
//        Hello hello = new Hello();
//        System.out.println(hello.getSlogan());
//        hello.setSlogan("Ha-Ha");
//        hello.printSlogan();
//        Args args1 = new Args();
//        args1.setArguments(args);
//        args1.printArguments();
        String s1 = new String("s1");
        s1 = s1.intern();
        String s2 = "s1";
        String s3 = "s1";
//        s1 = s2;
//        s3 = s1;
        System.out.println(s1==s2);
        System.out.println(s2);
        System.out.println(s3);
    }
}
