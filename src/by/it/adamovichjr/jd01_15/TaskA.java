package by.it.adamovichjr.jd01_15;

import java.io.*;
import java.util.Random;

public class TaskA {
    public static void main(String[] args) {
        int[][] matrix = new int[6][4];
        putMatrixValue(matrix);
        String filePath = getClassPath() + "matrix.txt";
        writeMatrix(matrix,filePath);
        readMatrix(filePath);
    }

    private static Class<TaskA> cls = TaskA.class;

    private static String getClassPath() {
        String sep = File.separator;
        String srcPath = System.getProperty("user.dir") + sep + "src" + sep;
        String classPath = cls.getName().replace(cls.getSimpleName(), "").replace(".", sep);
        return srcPath + classPath;
    }

    private static void putMatrixValue(int[][] mat) {
        Random random = new Random(1);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = random.nextInt(31) - 15;
            }
        }
    }
    private static void writeMatrix(int[][]matrix, String filePath){
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))){
            for (int[] ints : matrix) {
                for (int anInt : ints) {
                    pw.printf("%3d ", anInt);
                }
                pw.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void readMatrix(String pathFile){
        try (BufferedReader reader = new BufferedReader(new FileReader(pathFile))){
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
