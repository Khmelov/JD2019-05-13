package by.it.yakovets.jd01_15;

import java.io.File;

public class TaskA {
    public static void main(String[] args) {
        int[][] array = new int[6][4];
        generate(array);
        String patn=getPath(TaskA.class,"matrix.txt");
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.printf("%3d ", anInt);
            }
            System.out.println();
        }

    }
    private static String getPath(Class<?> aClass, String fileName){
        return getPath(aClass)+fileName;
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
