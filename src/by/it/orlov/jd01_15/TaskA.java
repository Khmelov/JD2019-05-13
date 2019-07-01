package by.it.orlov.jd01_15;

import java.io.*;

public class TaskA {

    public static void main(String[] args) {

        int[][] matr = new int[6][4];
        createMatrix(matr);

        String file = getFilePath() + "matrix.txt";
        write(matr, file);
        print(file);

    }

    private static void write(int[][] matrix, String filename) {
        try (PrintWriter pw = new PrintWriter
                (new FileWriter(filename))
        ) {
            for (int[] line : matrix) {
                for (int element : line) {
                    pw.printf("%3d ", element);
                }
                pw.printf("%n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void print(String filename) {
        try (BufferedReader br = new BufferedReader
                (new FileReader(filename))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createMatrix(int[][] matrix) {
        boolean max;
        boolean min;
        do {
            max = false;
            min = false;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = (int) (Math.random() * 31) - 15;
                    if (matrix[i][j] == 15) max = true;
                    if (matrix[i][j] == -15) min = true;
                }
            }
        } while (!max || !min);
    }

    private static Class<TaskA> cls = TaskA.class;

    private static String getFilePath() {
        String sep = File.separator;
        String srcPath = System.getProperty("user.dir") + sep + "src" + sep;
        String classPath = cls.getName().replace(cls.getSimpleName(), "").replace(".", sep);
        return srcPath + classPath;
    }
}