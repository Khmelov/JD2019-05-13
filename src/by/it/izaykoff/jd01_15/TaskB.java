package by.it.izaykoff.jd01_15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TaskB {

    public static void main(String[] args) throws IOException {


        String fileTxt = getPath(TaskB.class,"TaskB.txt");
        String fileJava = getPath(TaskB.class,"TaskB.java");
        StringBuilder strBuilder = new StringBuilder();

        Stream<String> lineStream = Files.lines(Paths.get(fileJava));

        //читать файл TaskB.java
        readFileJava(fileJava, strBuilder);

        //писать в тхт
        writeFileTxt(fileTxt, strBuilder);
    }

    private static void readFileJava(String fileJava, StringBuilder strBuilder) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileJava))) {

            while (reader.ready()) {
                String line = reader.readLine();
                if (line.contains("/"+"/") || line.contains("/"+"*" ) && !line.contains("if")){
                    strBuilder.append(line, 0, line.indexOf("/")).append("\n");
                }
                else if (line.contains("*"+"/")  && !line.contains("if") ){
                    strBuilder.append(line, 0, line.indexOf("*")).append("\n");
                }
                else {
                    strBuilder.append(line).append("\n");

                }
            }
        }
    }


    private static void writeFileTxt(String fileTxt, StringBuilder strBuilder) {
        try (PrintWriter out = new PrintWriter(new FileWriter(fileTxt))) {
            out.write(String.valueOf(strBuilder));
            System.out.println(strBuilder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private static String getPath(Class<?> aClass, String filename) {
        return getPath(aClass) + filename;
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



}
