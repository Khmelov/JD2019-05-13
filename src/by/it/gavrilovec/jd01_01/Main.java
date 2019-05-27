package by.it.gavrilovec.jd01_01;

public class Main {

    public static void main(String[] args) {
        Hello hello=new Hello();
        System.out.println(hello.getHello());
        Args arg=new Args(args);
        arg.printArgs();
    }
}
