package by.it.guchek.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var v1 = new Scalar(3.1415);
        Var v2 = new Scalar("3.1415");

        Var v3 = new Vector(new double[]{1, 2, 4});
        Var v4 = v3;
        Var v5 = new Vector("{1.0, 2.0, 4.0}");
        Var v6 = new Vector("{1,2,4}");
        //Var v2 = new Vector();
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);
        System.out.println(v5);
        System.out.println(v6);

        Var v7=new Matrix(new double[][]{{1.0, 2.0},{3.0, 4.0}});
        Var v9=new Matrix(new double[][]{{1, 2.0},{3,4.0}});
        System.out.println(v7);
        System.out.println(v9);
    }
}
