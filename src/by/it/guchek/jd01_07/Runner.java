package by.it.guchek.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var v1 = new Scalar(3.1415);
        Var v2 = new Scalar("3.1415");

        Var v3 = new Vector(new double[]{1, 2, 4});
        Var v4 = v3;
        //Var v2 = new Vector();
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);
    }
}
