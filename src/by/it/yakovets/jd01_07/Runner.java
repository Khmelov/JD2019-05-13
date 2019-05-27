package by.it.yakovets.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar v = new Scalar(3.14);
        System.out.println(v);
        Var v2 = new Scalar(v);
        Var v3 = new Scalar("3.1415926");
        System.out.println(v3);
    }
}
