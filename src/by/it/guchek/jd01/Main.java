package by.it.guchek.jd01;

public class Main {

    public static void main(String[] args) {
	// write your code here
       Hello hello = new Hello ();
       hello.printslogan();
       hello.setSlogan("Привет мир!");
       hello.printslogan();
       Args argObject = new Args(args);
       argObject.printArgs();
    }
}
