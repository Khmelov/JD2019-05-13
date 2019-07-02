package by.it.tbabich.jd01_15;

import java.io.*;
import java.util.Random;

public class TaskA {
    public static void main(String[] args) {
        int[][] array = new int[6][4];
        initArray(array);
        printFile(array);
        printConsole();

    }

    private static void printConsole() {
        try (BufferedReader br = new BufferedReader
                (new FileReader
                        (new File(getFilePath(TaskA.class, "matrix.txt"))))) {
            while (br.ready()) System.out.println(br.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printFile(int[][] array) {
        String fileOut = getFilePath(TaskA.class, "matrix.txt");
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileOut))) {
            for (int[] mas : array) {
                for (int value : mas) {
                    pw.printf("%3d ", value);
                }
                pw.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void initArray(int[][] array) {
        boolean min;
        boolean max;
        Random random = new Random();
        do {
            min = false;
            max = false;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    array[i][j] = -15 + random.nextInt(31);
                    if (array[i][j] == -15) min = true;
                    if (array[i][j] == 15) max = true;
                }
            }
        } while (!min || !max);
    }

    private static String getPath(Class<TaskA> aClass) {
        String root = System.getProperty("user.dir");
        String simpleName = TaskA.class.getSimpleName();
        String name = TaskA.class.getName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);
        return path = root + separator + "src" + separator + path;
    }

    private static String getFilePath(Class<TaskA> aClass, String fileName) {
        return getPath(aClass) + fileName;
    }

}
