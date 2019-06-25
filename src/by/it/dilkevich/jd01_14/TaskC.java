package by.it.dilkevich.jd01_14;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TaskC {

    public static void main(String[] args) throws IOException {

        String src = System.getProperty("user.dir") + "/src/by/it/dilkevich/";
        String path = src + "jd01_14/resultTaskC.txt";

        System.out.println(src);

        StringBuilder sb = new StringBuilder();
        sb.append(printFilesInDirectory(src));

        safeToFile(sb.toString(), path);

    }

    private static boolean safeToFile(String toString, String path) throws IOException {

        try (BufferedWriter br = new BufferedWriter(new FileWriter(path))){

            br.write(toString);

        }
        catch (IOException e){

            e.getStackTrace();
        }
        return true;
    }

    private static StringBuilder printFilesInDirectory(String src) {


        StringBuilder stringBuilder = new StringBuilder();

            File file = new File(src);
            String[] list = file.list();
            for (String s : list) {
                File fileD = new File(src + s + "/");
                if (fileD.isFile()) {
                    System.out.printf("file:%s\n", s);
                    stringBuilder.append("file:").append(s).append("\n");
                }
                if (fileD.isDirectory()) {
                    System.out.printf("dir:%s\n", s);
                    stringBuilder.append("dir:").append(s).append("\n");
                    stringBuilder.append(printFilesInDirectory(src + s + "/"));
                }
        }
            return stringBuilder;
    }
}
