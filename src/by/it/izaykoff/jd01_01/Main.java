package by.it.izaykoff.jd01_01;

public class Main {

    public static void main(String[] args) {

        Hello hello = new Hello();
        hello.prinSlogan();
        hello.setSlogan();
        hello.prinSlogan();

        Args argObject = new Args(args);
        argObject.printArgs();


    }
}
