package by.it.trudnitski.jd01_07;

import java.util.regex.Matcher;

public class Runner {
    public static void main(String[] args) {
        Scalar v=new Scalar(3.14);
        System.out.println(v);
        Var v2=new Scalar(v);
        System.out.println(v2);
        Var v3=new Scalar(3.1445634);
        System.out.println(v3);

        Vector v1=new Vector(new double[]{1,2,4});
        System.out.println(v1);
        Vector vv=new Vector(v1);
        System.out.println(vv);
        Vector str=new Vector("{1.0,2.0,4.0}");
        System.out.println(str);

        Matrix m=new Matrix(new double[][]{{1,2},{3,4}});
        System.out.println(m);
        Matrix mm=new Matrix(m);
        System.out.println(mm);
        Matrix md= new Matrix("{{1,2},{3,4}}");
        System.out.println(md);
    }
}
