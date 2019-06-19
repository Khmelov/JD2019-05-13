package by.it.yaskevich.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar scalar = new Scalar(1);
        System.out.println(scalar);
        scalar = new Scalar("1");
        System.out.println(scalar);


        Vector vector = new Vector(new double[]{1, 2});
        System.out.println(vector);
        vector = new Vector("{1,2}");
        System.out.println(vector);

        Matrix matrix = new Matrix(new double[][]{{1, 2},{3, 4}});
        System.out.println(matrix);
        matrix = new Matrix("{{1,2},{3,4}}");
        System.out.println(matrix);
    }
}
