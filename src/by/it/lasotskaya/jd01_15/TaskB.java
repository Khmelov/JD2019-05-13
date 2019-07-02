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

    public static void main(String[] args) {
        File input = new File(getRoot(), "TaskB.java");
        File output = new File(getRoot(), "TaskB.txt");
        readFile(input);
        System.out.println(stringBuilder);
        writeFile(output);


    }

    private static void readFile(File file) {
        int start;
        int finish;
        while ((start = stringBuilder.indexOf("/\u002f")) >= 0 && (finish = stringBuilder.indexOf("\n",start)) >= 0 ) {
            stringBuilder.delete(start,finish+1);
        }
        while ((start = stringBuilder.indexOf("\u002f*")) >= 0 && (finish = stringBuilder.indexOf("*\u002f")) >= 0 ) {
            stringBuilder.delete(start,finish+2);
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

}