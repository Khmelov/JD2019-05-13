package by.it.yakimovich.jd01_15;

import java.io.*;

public class TaskB {
    //comment
    /*comment*/
    /**comment*/

    static String textRead = getFilePath(TaskB.class, "TaskB.java");
    static String textPrint = getFilePath(TaskB.class, "TaskB.txt");
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        readTextWithoutComments(textRead);
        printText(textPrint);
    }


    private static void readTextWithoutComments(String textRead) {
        try (BufferedReader bufferedReader = new BufferedReader
                (new FileReader(textRead))
        ) {
            String line;
            boolean add = true;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("//") || line.contains("/*") || line.contains("/**"))
                    add = false;
                else if (line.contains("/" + "*") || line.contains("*" + "/")) {
                    stringBuilder.append("\n");
                } else {
                    stringBuilder.append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //comment
    /*comment*/
    private static void printText(String textPrint) {
        try (PrintWriter printWriter = new PrintWriter(textPrint)) {
            printWriter.print(stringBuilder);
            System.out.println(stringBuilder);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    private static String getFilePath(Class<?> bClass, String filename) {
        return getPath(bClass) + filename;
    }

    private static String getPath(Class<?> bClass) {
        String root = System.getProperty("user.dir");
        String name = bClass.getName();
        String simpleName = bClass.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);
        path = root + separator + "src" + separator + path;
        return path;
    }
}