package by.it.buymistrov.jd01_07;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        Scalar v = new Scalar(3.14);
        System.out.println(v);

        Var v2 = new Scalar(v);
        System.out.println(v2);

        Var v3 = new Scalar("3.1415");
        System.out.println(v3);


        double[] vectorTaskB = {1.0, 2.0, 4.0};

        Vector vector = new Vector(vectorTaskB);
        System.out.println(vector);

        Var vector2 = new Vector(vector);
        System.out.println(vector2);

        Var vector3 = new Vector("{1.434, 2.223, 3,4}");
        System.out.println(vector3);

        double[][] matrixTaskC = {{1.33, 2}, {3, 4}};


        Matrix matrix = new Matrix(matrixTaskC);
        System.out.println(matrix);

        Var matrix2 = new Matrix(matrix);
        System.out.println(matrix2);

        Var matrix3 = new Matrix("{{1,2,3,4},{3,4,4,4},{5,6,7,4},{2,3,1,3.3}}");
        System.out.println(matrix3);


    }
}
