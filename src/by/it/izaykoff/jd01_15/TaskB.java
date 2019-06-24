package by.it.izaykoff.jd01_15;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TaskB {

    /**
     * Это JavaDoc комментарий, пример написания.
     */


    // Однострочный комментарий.
    /* Тоже однострочный комментарий. */

    public static void main(String[] args) throws IOException {

        String fileTxt = getPath(TaskB.class,"TaskB.txt");
        String fileJava = getPath(TaskB.class) + "/TaskB.java";
        StringBuilder strBuilder = new StringBuilder();

        Stream<String> lineStream = Files.lines(Paths.get(fileJava));



        //читать файл TaskB.java
//        readFileJava(fileJava, strBuilder);

        try (Stream<String> streamFromFiles = Files.lines(Paths.get(fileJava))) {
            streamFromFiles
                    .forEach(System.out::println);

        }


        //писать в тхт
        writeFileTxt(fileTxt, strBuilder);


    }

    private static void writeFileTxt(String fileTxt, StringBuilder strBuilder) {
        try (PrintWriter out = new PrintWriter(new FileWriter(fileTxt))) {
            out.write(String.valueOf(strBuilder));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFileJava(String fileJava, StringBuilder strBuilder) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileJava))) {
            String line;
            while ((line=reader.readLine()) != null){
                strBuilder.append(line).append("\n");
            }
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
