package by.it.dilkevich.jd01_15;

import java.io.*;

public class TaskA {

    public static void main(String[] args) throws IOException {

        String src = System.getProperty("user.dir") + "/src/by/it/dilkevich/jd01_15/";
        String fileName1 = src + "matrix.txt";

        int[][] mas = createMatrix();
        writeMatrixToFile(fileName1, mas);


        try (BufferedReader readMatrix = new BufferedReader(new FileReader(fileName1))){

            String resultLine;
            StringBuilder sb = new StringBuilder();

            do{
                resultLine = readMatrix.readLine();

                if(resultLine != null)
                sb.append(resultLine).append("\n");
            }
            while (resultLine != null);

            System.out.println(sb);
        }

    }







    private static void writeMatrixToFile(String fileName1, int[][] mass) throws IOException {
        try (PrintWriter printWriterMatrix = new PrintWriter(new FileWriter(fileName1))) {

            for (int[] ints : mass) {

                for (int anInt : ints) {

                    printWriterMatrix.printf("%3d ", anInt);
                }
                printWriterMatrix.print("\n");
            }

        }
    }


        private static int[][] createMatrix() {
            int[][] mas = new int[6][4];

            for (int i = 0; i < mas.length; i++) {

                for (int j = 0; j < mas[0].length; j++) {

                    mas[i][j] = (int) (-15 + Math.random() * 31);
                    System.out.print(mas[i][j] + " ");
                }
                System.out.println();
            }
            return mas;
        }
    }

