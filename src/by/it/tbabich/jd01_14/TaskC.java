package by.it.tbabich.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskC {

    private static PrintWriter printWriter;
    private static File file;

    public static void main(String[] args) {


        String fileIn = getPath(TaskC.class);
//        String fileIn2 = getPath(TaskC.class).replaceAll("\\\\jd01_14", "");
        String fileOut = getFilePath(TaskC.class, "resultTaskC.txt");
//        File file2 = new File(fileIn2);
//        System.out.println(file2.getParent());

        try {
            printWriter = new PrintWriter(
                    new FileWriter(fileOut));
            file = new File(fileIn).getParentFile();
            calculate(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            printWriter.close();
        }
    }

    private static String getPath(Class<TaskC> cClass) {
        String root = System.getProperty("user.dir");
        String simpleName = TaskC.class.getSimpleName();
        String name = TaskC.class.getName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);
        return path = root + separator + "src" + separator + path;
    }

    private static String getFilePath(Class<TaskC> cClass, String fileName) {
        return getPath(cClass) + fileName;
    }

    private static void calculate(File file) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                if (file1.isFile()) {
                    printWriter.write(String.format("file:%s\n", file1.getName()));
                    System.out.printf("file:%s\n", file1.getName());
                }
                else if (file1.isDirectory()) {
                    printWriter.write(String.format("dir:%s\n", file1.getName()));
                    System.out.printf("dir:%s\n", file1.getName());
                    calculate(file1);
                }
            }

    }

    private static void printText(String fileOut, int words, int marks) {
        try (
                PrintWriter printWriter = new PrintWriter(
                        new FileWriter(fileOut))
        ) {
            String result = String.format("words=%d, marks=%d", words, marks);
            printWriter.printf(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
