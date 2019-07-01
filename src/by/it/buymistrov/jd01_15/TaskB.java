package by.it.buymistrov.jd01_15;

import java.io.*;
import java.util.Scanner;

public class TaskB {

    private static String getFilePath(String file) {
        return getPath() + file;
    }

    private static String getPath() {
        String root = System.getProperty("user.dir");
        String name = TaskB.class.getName();
        String simpleName = TaskB.class.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);
        path = root + separator + "src" + separator + path;
        return path;
    }

    private static String getText(String path) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        assert scanner != null;
        while (scanner.hasNext()) sb.append(scanner.nextLine()).append("\n");
        scanner.close();
        return sb.toString();
    }

    private static String deleteComments(String path) {
        char[] ch0 = path.toCharArray();

        boolean multipleComments = false;
        boolean singleComments = false;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ch0.length; i++) {
            if (ch0[i] == '/' && ch0[i + 1] == '/') {
                singleComments = true;
                continue;
            } else if (ch0[i] == '\n') {
                singleComments = false;
            } else if (ch0[i] == '/' && ch0[i + 1] == '*') {
                multipleComments = true;
                continue;
            } else if (ch0[i] == '/' && ch0[i + 1] == '*' && ch0[i + 2] == '*') {  //singleComment
                multipleComments = true;
                continue;
            } else if (ch0[i] == '/' && ch0[i - 1] == '*') {
                multipleComments = false;
                continue;
            }
/*
multipleComments
 */
            if (!multipleComments && !singleComments) {
                sb.append(ch0[i]);
            }

        }

        return sb.toString();
    }

    /**
     * @param args 123;
     */
    public static void main(String[] args) {

//        System.out.println(s);
        try (PrintWriter out = new PrintWriter(new FileWriter(getFilePath("TaskB.txt")))) {
            out.println(deleteComments(getText(getFilePath("TaskB.java")).trim()));
        } catch (IOException e) {
            e.printStackTrace();
        }
//singleComment
        System.out.println(deleteComments(getText(getFilePath("TaskB.java")).trim()));
    }
}
