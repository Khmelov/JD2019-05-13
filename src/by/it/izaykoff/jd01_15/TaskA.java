package by.it.izaykoff.jd01_15;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TaskA {
    public static void main(String[] args) throws IOException {
        String fileTxt = getPath(TaskA.class, "matrix.txt");
        int [][] matrix = new int[6][4];

        generateMatrix(matrix);

        printWriter(fileTxt, matrix);

//        readTxtConsole(fileTxt);
        Files.lines(Paths.get(fileTxt)).forEach(System.out::println);

    }

    private static void readTxtConsole(String fileTxt) {
        try (BufferedReader red = new BufferedReader(
                new FileReader(fileTxt))){
            String line;
            while (red.read() > 0){
                line = red.readLine();
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printWriter(String fileTxt, int[][] matrix) {
        try (PrintWriter out = new PrintWriter(
                new FileWriter(fileTxt))){
            for (int[] row : matrix) {
                for (int el : row) {
                    out.printf("%3d ",el);
                }
                out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateMatrix(int[][] matrix) {
        boolean max;
        boolean min;
        do {
            max = false;
            min = false;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = -15 + (int) (Math.random()*31);
                    if (matrix[i][j] == 15) max=true;
                    if (matrix[i][j] == -15) min=true;
                }
            }
        }
        while (!max || !min);
    }

    private static String getPath(Class<?> aClass, String filename) {
        return getPath(aClass) + filename;
    }

    private static String getPath(Class<?> aClass) {
        String root = System.getProperty("user.dir");
        String name = aClass.getName();
        String simpleName = aClass.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);
        path = root + separator + "src" + separator + path;
        return path;
    }

}
