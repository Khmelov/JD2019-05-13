package by.it.tbabich.jd01_07;

public class Runner {
    public static void main(String[] args) {

        Var scalar1 = new Scalar(1.0);
        System.out.println(scalar1);
        Var scalar2 = new Scalar(new Scalar(2.0));
        System.out.println(scalar2);
        Var scalar3 = new Scalar("3.0");
        System.out.println(scalar3);

        Var vector1 = new Vector(new double[]{1, 1, 1});
        System.out.println(vector1);
        Var vector2 = new Vector(new Vector(new double[]{2, 2, 2}));
        System.out.println(vector2);
        Var vector3 = new Vector("{3, 3, 3}");
        System.out.println(vector3);

        Var matrix1 = new Matrix(new double[][]{{1, 1, 1}, {1, 1, 1}});
        System.out.println(matrix1);
        Var matrix2 = new Matrix(new Matrix(new double[][]{{2, 2, 2}, {2, 2, 2}}));
        System.out.println(matrix2);
        Var matrix3 = new Matrix("{{3,3,3},{3,3,3}}");
        System.out.println(matrix3);
    }
}
