package by.it.dnevar.jd01_15;

import java.io.*;

public class TaskA {

    private static String fileResultTxt = getFilePath(TaskA.class,"matrix.txt");

    public static void main(String[] args) {

        int[][] array = new int[6][4];
        generate(array);
        writeTxtFile(array);
        readFileToConsole();

    }

    private static void readFileToConsole() {
        try(BufferedReader br = new BufferedReader(new FileReader(fileResultTxt))) {
            String line;
            while((line = br.readLine())!=null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeTxtFile(int[][] array) {
        try(PrintWriter out = new PrintWriter(fileResultTxt)) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    out.printf("%3d ",array[i][j]);
                }
                out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void generate(int[][] array) {
        boolean min;
        boolean max;
        do {
            min = max = false;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = -15 + (int) (Math.random() * 31);
                    if (array[i][j] == -15) {
                        min = true;
                    }
                    if (array[i][j] == 15) {
                        max = true;
                    }
                }
            }
        }while (!min || !max) ;
    }

    private static String getPath (Class<?> aClass){
        String root = System.getProperty("user.dir")
                + File.separator
                +"src"
                +File.separator;
        String name = aClass.getName()
                .replace(aClass.getSimpleName(),"")
                .replace(".", File.separator);
        return root+name;
    }

    private static String getFilePath(Class<?> aClass, String filename){
        return getPath(aClass)+filename;
    }
}
