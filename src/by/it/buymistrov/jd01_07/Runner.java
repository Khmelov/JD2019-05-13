package by.it.buymistrov.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar v = new Scalar(3.14);
        System.out.println(v);

        Var v2 = new Scalar(v);
        System.out.println(v2);

        Var v3 = new Scalar("3.1415");
        System.out.println(v3);


    }
}
