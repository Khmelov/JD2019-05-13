package by.it.yaskevich.jd01_15;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class TaskA {
    public static void main(String[] args) {
        int [][] array = new int [6][4];

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
        } while (!min || !max);

        for (int[] row : array) {
            for (int e : row) {
                System.out.printf("%3d ", e);
            }
            System.out.println();
        }

        String fileName = getFilePath(TaskA.class, "matrix.txt");
        printArray(array, fileName);

        showFile(fileName);
    }

    private static void showFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            do {
                String line = br.readLine();
                if (line == null) break;
                System.out.println(line);
            } while (true);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;
    }

    private static void printArray(int[][] array, String fileName) {
        try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {


            for (int[] row : array) {
                for (int e : row) {
                    out.printf("%3d ", e);
                }
                out.println();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getFilePath(Class<?> aClass, String fileName) {
        return getPath(aClass) + fileName;
    }

    private static String getPath(Class<?> aClass) {
        String root = System.getProperty("user.dir");
        String separator = File.separator;
        String name = aClass.getName();
        String simpleName = aClass.getSimpleName();
        return root + separator + "src" + separator +
                name.replace(simpleName, "").replace(".", separator);
    }

}
