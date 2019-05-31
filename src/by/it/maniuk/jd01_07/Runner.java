package by.it.maniuk.jd01_07;

public class Runner  {
    public static void main(String[] args) {
    Scalar v = new Scalar(3.14);
    Var v2 = new Scalar(v);
    Var v3 = new Scalar("3.1415926");

        System.out.println(v);
        System.out.println(v2);
        System.out.println(v3);

    Vector v4 = new Vector(new double[] {1.0, 2.0, 4.0});
    Var v5 = new Vector(v4);
    Vector v6 = new Vector("{1.0,2.0,4.0}");

        System.out.println(v4);
        System.out.println(v5);
        System.out.println(v6);

    Matrix v7 = new Matrix(new  double[][] {{1.0, 2.0},{3.0, 4.0}});
    Matrix v8 = new Matrix(v7);
    Matrix v9 = new Matrix("{{1.0, 2.0}, {3.0, 4.0}}");

        System.out.println(v7);
        System.out.println(v8);
        System.out.println(v9);
    }

}
