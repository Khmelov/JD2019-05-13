package by.it.buymistrov.jd01_01;

public class Main {

    public static void main(String[] args) {
    Hello hello = new Hello();
    hello.printSlogan();
    hello.setSlogan("SALAM");
    hello.printSlogan();

    Args argObject=new Args(args);
    argObject.printArgs();

    }

}
