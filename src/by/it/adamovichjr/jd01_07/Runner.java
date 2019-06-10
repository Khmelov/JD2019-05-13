package by.it.adamovichjr.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar scalarD = new Scalar(3.1415);
        System.out.println(scalarD);

        Scalar scalarSt = new Scalar("3.1415");
        System.out.println(scalarSt);

        Scalar scalarSc = new Scalar(scalarD);
        System.out.println(scalarSc);

        Vector vectorD = new Vector(new double[]{1.0, 2.0, 3.0});
        System.out.println(vectorD);

        Vector vectorV = new Vector(vectorD);
        System.out.println(vectorV);

        Vector vectorS = new Vector("{1.0, 2.0, 3.0, 4.0}");
        System.out.println(vectorS);

        Matrix matrixD = new Matrix(new double[][]{ { 1.0, 2.0 }, { 3.0, 4.0 } });
        System.out.println(matrixD);

        Matrix matrixM = new Matrix(matrixD);
        System.out.println(matrixM);

        Matrix matrixS = new Matrix("{ { 1.0, 2.0, 4.0, 5.0 }, { 3.0, 4.0 } }");
        System.out.println(matrixS);
    }
}
