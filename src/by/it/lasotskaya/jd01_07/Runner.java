package by.it.lasotskaya.jd01_07;

public class Runner {

    public static void main(String[] args) {
        //Scalar
        Var s = new Scalar(3.1415);
        Var s1 = new Scalar("3.1415");
        Scalar s2 = new Scalar((Scalar) s1);
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
        //Vector
        double[] vector = {1.0, 2.0, 4.0};
        Var v = new Vector(vector);
        Var v2 = new Vector("{1.0, 2.0, 4.0}");
        Var v1= new Vector((Vector) v);
        System.out.println(v);
        System.out.println(v1);
        System.out.println(v2);
        //Matrix
        double[][] matrix = {{1.0, 2.0}, {3.0, 4.0}};
        Var m = new Matrix(matrix);
       // Var m1 = new Matrix("{ {1.0,2.0}, {3.0,4.0} }");
        Var m2 = new Matrix((Matrix)m);
        System.out.println(m);
       //System.out.println(m1);
        System.out.println(m2);

    }}
