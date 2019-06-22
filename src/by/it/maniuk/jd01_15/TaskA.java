package by.it.maniuk.jd01_15;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskA {
    public static void main(String[] args) throws IOException {
        int[][] array = new int[6][4];
        String path = getFilePath(TaskA.class, "matrix.txt");
        boolean max;
        boolean min;
        do {
            max = false;
            min = false;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = - 15 + (int) (Math.random() * 31);
                    if (array[i][j] == - 15) min = true;
                    if (array[i][j] == 15) max = true;
                }
            }
        } while (! min || ! max);
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.printf("%3d", anInt);

            }

        }
        try(PrintWriter out = new PrintWriter( new FileWriter(path))) {

        } 

    }
    private static String getFilePath(Class<TaskA> aClass, String filename) {
        return getPath(aClass) + filename;
    }

    private static String getPath(Class<TaskA> aClass) {
        String root = System.getProperty("user.dir");
        String name = TaskA.class.getName();
        String simpleName = TaskA.class.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);

        path = root + separator + "src" + separator + path;
        return path;
    }
}
