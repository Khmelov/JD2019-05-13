package by.it.aadamovich.jd01_07;

public class OldRunner {
    public static void main(String[] args) {

        Scalar s1 = new Scalar(1);
        Object s2 = new Scalar(s1);
        Var s3 = new Scalar("1");

        System.out.printf("%s%n%s%n%s%n",s1,s2,s3);

        Vector v1 = new Vector(new double[] {1,2,3});
        Var v2 = new Vector(v1);
        Vector v3 = new Vector("[3,2.0, 7}");

        System.out.printf("%s%n%s%n%s%n",v1,v2,v3);




        Matrix m1 = new Matrix(new double[][] {{1.0,2.0,6.0},{1,4,5}});

        Matrix m3 = new Matrix("{{1.0, 2.0,,6},{3.0,4.0k11!15},{5,6}}");
        Matrix m2 = new Matrix(m3);


        System.out.println(m1);
        System.out.println(m3);
        System.out.println(m2);
    }
}
