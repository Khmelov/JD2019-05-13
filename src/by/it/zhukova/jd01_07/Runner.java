package by.it.zhukova.jd01_07;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        Var v1 = new Scalar(3.421);
        System.out.println(v1);
        Scalar v2 = new Scalar("3.421");
        System.out.println(v2);
        Scalar scalarScalar = new Scalar(v2);
        System.out.println(scalarScalar);
        double [] vec = {1.0, 2.45, 4};
        Vector vector = new Vector(vec);
        System.out.println(vector);
        Vector Strvector = new Vector("{1.0, 2.45, 4}");
        System.out.println(Strvector);
        Var vectorVector =new Vector(Strvector);
        System.out.println(vectorVector);
        Matrix Strmatrix = new Matrix("{{1,2},{3,4}}");
           }

}
