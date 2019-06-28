package by.it.maniuk.jd01_15;

import java.io.*;

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

        try(PrintWriter out = new PrintWriter( new FileWriter(path))) {
            for (int[] row : array) {
                for (int e : row) {
                    out.printf("%3d ", e);
                }
                out.println();
            }
        }

        try(BufferedReader in = new BufferedReader(
                new FileReader(path))) {
            for (; ; ) {
                String line = in.readLine();
                if (line == null)
                    break;
                System.out.println(line);
            }
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
