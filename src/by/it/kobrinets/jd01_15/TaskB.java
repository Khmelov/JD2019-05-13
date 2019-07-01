package by.it.kobrinets.jd01_15;


import java.io.*;

/**
 * @author Yana Kobrinets
 * @version 1.0
 */

public class TaskB {
    public static void main(String[] args) throws IOException {
        String PathJavaFile = getFilePath(TaskB.class, "TaskB.java"); // однострочный комментарий 1
        String PathTxtFile = getFilePath(TaskB.class, "TaskB.txt");
        StringBuilder str = new StringBuilder();

        fileRead(PathJavaFile, str);
        printFile(str, PathTxtFile);
    }
    /* многострочный
     комментарий 1*/
    private static void fileRead(String fileJava, StringBuilder str) throws IOException {
        int a;
        char symbol;
        boolean flag;
        int count = 0;
        try (BufferedInputStream file = new BufferedInputStream(new FileInputStream(fileJava))) {
            flag = false;
            while ((a = file.read()) > 0) {
                symbol = (char) a;
                if (symbol == '/' && count == 2) {
                    flag = false;
                    count = 0;
                } else if (symbol == '\n' && count == 1) {
                    flag = false;
                    count = 0;
                    str.append(symbol);
                } else if (symbol == '/') {
                    char c = (char) file.read();
                    if (c == '/') {
                        count = 1;
                        flag = true;
                    } else if (c == '*') {
                        count = 2;
                        flag = true;

                    } else str.append(symbol).append(c);
                } else if (flag) {

                }
                else str.append(symbol);
            }
            System.out.println(str);
        }
        /* многострочный
         комментарий 2*/
    }

    private static void printFile(StringBuilder str, String fileTxt) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(fileTxt))) {
            out.print(str);
        }
    }

    private static String getFilePath(Class<?> bClass, String filename) {
        String path = getPath(bClass);
        return path + filename;
    }
    // однострочный коммнтарий 2
    private static String getPath(Class<?> bClass) {
        String src = System.getProperty("user.dir");
        String name = bClass.getName();
        String simpleName = bClass.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);
        path = src + separator + "src" + separator + path;
        return path;
    }
}