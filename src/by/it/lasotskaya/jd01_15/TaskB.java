package by.it.lasotskaya.jd01_15;

// hello
// first comment
    /*
    one more comment
     */
    /*
    another one
     */

import java.io.*;

/**
 * JavaDoc
 */

public class TaskB {
    private static StringBuilder stringBuilder = new StringBuilder();
    private static boolean delete = false;

    public static void main(String[] args) {
        File input = new File(getRoot(), "TaskB.java");
        File output = new File(getRoot(), "TaskB.txt");
        readFile(input);
        System.out.println(stringBuilder);
        writeFile(output);


    }

    private static void readFile(File file) {
        try (BufferedReader br = new BufferedReader(
                new FileReader(file))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(delete(line+("\n")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getRoot() {
        return System.getProperty("user.dir") +
                File.separator +
                "src" +
                File.separator +
                TaskB.class.getName()
                        .replace(TaskB.class.getSimpleName(), "")
                        .replace(".", File.separator);
    }

    private static void writeFile(File file) {
        try (PrintWriter writer = new PrintWriter(file)
        ) {
            writer.printf(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String delete(String line) {
        while (delete) {
            for (int i = 0; i < line.length(); i++) {
                if ((line.charAt(i) == '*') && (line.charAt(i + 1) == '/')) {
                        delete = false;
                        return line.substring(i + 3);
                    }
                }
            return " ";
        }


        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '/') {
                if (line.charAt(i + 1) == '/') {
                    return line.substring(0,i);
                }
               if (line.charAt(i + 1) == '*' && line.charAt(i + 2) != '*') {
                    delete = true;
                    return line.substring(0,i);
                }
               if (line.charAt(i + 1) == '*' && line.charAt(i + 2) == '*') {
                    delete = true;
                    return line.substring(0,i);
                }
            }
        }
        return line;
    }
}