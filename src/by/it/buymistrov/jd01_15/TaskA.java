package by.it.buymistrov.jd01_15;

import java.io.*;

public class TaskA {
    public static void main(String[] args) throws IOException {
        int[][] array = new int[6][4];
        generate(array);

        String path = getFilePath();
        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {

            for (int[] ints : array) {
                for (int anInt : ints) {
                    out.printf("%3d ", anInt);
                }
                out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.printf("%3d ", anInt);
            }
            System.out.println();
        }


        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            for (; ; ) {
                String line = in.readLine();
                if (line == null)
                    break;
                System.out.println(line);
            }
        }

//        Files.lines(Paths.get(path)).forEach(System.out::println);

    }


    private static String getFilePath() {
        return getPath() + "matrix.txt";
    }

    private static String getPath() {
        String root = System.getProperty("user.dir");
        String name = TaskA.class.getName();
        String simpleName = TaskA.class.getSimpleName();
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
                for (int i1 = 0; i1 < array[i].length; i1++) {
                    array[i][i1] = -15 + (int) (Math.random() * 31);
                    if (array[i][i1] == -15) min = true;
                    if (array[i][i1] == 15) max = true;
                }
            }
        }
        while (!min && !max);
    }
}
