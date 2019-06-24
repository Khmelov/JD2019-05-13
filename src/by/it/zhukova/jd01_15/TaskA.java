package by.it.zhukova.jd01_15;

import java.io.*;

public class TaskA {
    public static void main(String[] args) throws IOException {
        int [] [] matrix = new int[6][4];
        generate(matrix);
        String fileTxt = getFilePath(TaskA.class, "matrix.txt");
        printFile(matrix, fileTxt);
       printConsole(fileTxt);
    }

    private static void printConsole(String fileTxt) throws IOException {
        try (  BufferedReader buf = new BufferedReader(new FileReader(fileTxt)))
        {
            for ( ; ; ){
               final String s = buf.readLine();
                if (s==null) break;
                System.out.println(s);
            }
        }
    }

    private static void printFile(int[][] matrix, String fileTxt) throws IOException {
        try (
             PrintWriter out = new PrintWriter(new FileWriter(fileTxt))
        ) {
            for (int[] ints : matrix) {
                for (int anInt : ints) {
                    out.printf("%3d ",anInt);
                }
                out.printf("\n");
            }

        }
    }

    private static void generate(int[][] matrix) {
        boolean min;
        boolean max;
        do{
         min=false;
         max = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix [i].length; j++) {
                matrix[i][j] = -15 + (int) (Math.random() * 31);
                if (matrix[i][j] == -15) min = true;
                if (matrix[i][j] == 15) max = true;
            }
            }

        }
        while (!min || !max);
    }
    private static String getFilePath(Class<?> aClass, String filename) {
        String path = getPath(aClass);
        return path +filename;
    }

    private static String getPath(Class<?> aClass) {
        String src= System.getProperty("user.dir");
        String name = aClass.getName();
        String simpleName = aClass.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName,"").replace(".",separator);
        path=src+separator+"src"+separator+path;
        return path;
    }
}
