package by.it.akhmelev.jd01_15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TaskA {

    public static void main(String[] args) throws IOException {
        int[][] array = new int[6][4];
        generate(array);
        String filename = getPath(TaskA.class, "matrix.txt");
        printArray(array, filename);
        showTxtFile(filename);
        //Files.lines(Paths.get(filename)).forEach(System.out::println);
    }

    private static void showTxtFile(String filename) throws IOException {
        try (BufferedReader in = new BufferedReader(
                new FileReader(filename)
        )) {
            for (; ; ) {
                String line = in.readLine();
                if (line == null)
                    break;
                System.out.println(line);
            }
        }
    }

    private static void printArray(int[][] array, String filename) throws IOException {
        try (PrintWriter out = new PrintWriter(
                new FileWriter(filename)
        )) {
            for (int[] row : array) {
                for (int e : row) {
                    out.printf("%3d ", e);
                }
                out.println();
            }
        }
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

    private static void generate(int[][] array) {
        boolean max;
        boolean min;
        do {
            max = false;
            min = false;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = -15 + (int) (Math.random() * 31);
                    if (array[i][j] == -15) min = true;
                    if (array[i][j] == 15) max = true;
                }
            }
        }
        while (!min || !max);
    }


}
