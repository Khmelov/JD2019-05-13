package by.it.zhukova.jd01_03;

public class Runner {
    public static void main(String[] args) {
        String line ;
        double[] mas = InOut.getArray(line = "1 34 2 33 33 23 1 6 5 ");
        System.out.println("Массив mas print:");
        InOut.printArray( mas);
                       System.out.println("Массив mas printf:");
                       InOut.printArray(mas, "v", 5);
        double min = Helper.findMin(mas);
        double max = Helper.findMax(mas);
        System.out.println("Отсортированный массив mas:");
                     Helper.sort(mas);
                   double [] [] matr = {{1,2,3,4,5},
                           {6,7,8,9,10},
                           {11,12,13,14,15}
                   };
               double[] vec = {1,2,3,4,5};
        double[] mul = Helper.mul(matr, vec);
        System.out.println("Результат умножения матрицы на вектор:");
        InOut.printArray( mul);
        double [] [] matr2 = {{1,2,3},
                {6,7,8},
                {11,12,13},
                {4,5,3},
                {2,3,5}
        };
        double[][] mul2 = Helper.mul(matr, matr2);
        System.out.println("Результат умножения матрицы на матрицу:");
                String name = "c";
        for (int i = 0; i < mul2.length; i++) {
            for (int j = 0; j < mul2[0].length ; j++) {
            System.out.printf("%s[% -3d,% -3d]=%-7.2f ", name, i, j, mul2[i][j]);
            }
                System.out.println();
        }
    }

}
