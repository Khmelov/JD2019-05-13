package by.it.livanovich.jd01_15;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TaskA {
    public static void main(String[] args) throws IOException {
        int[][] array = new int[6][4];
        generate(array);
        writeFile(array);
        readConsole();
       //Files.lines(Paths.get(dir(TaskA.class)+"matrix.txt")).forEach(System.out::println);
    }

    static void readConsole() {
        try (BufferedReader reader=new BufferedReader(
                new FileReader(dir(TaskA.class)+"matrix.txt"))){
        for (; ;){
            String line=reader.readLine();
            if (line==null){
                break;
            }
            System.out.println(line);
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void writeFile(int[][] array) {
        try (PrintWriter out = new PrintWriter(
                new FileWriter(dir(TaskA.class) + "matrix.txt"))) {
            for (int[] row : array) {
                for (int element : row) {
                    out.printf("%3d ", element);
                }
                out.println();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void generate(int [][] array) {
        boolean min;
        boolean max;
        do {
            min = false;
            max = false;
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
    private static String dir(Class<?> cl) {
        String scr = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        String path=scr+classDir;
        return path;

    }
}
