package by.it.tbabich.jd01_14;

import java.io.*;

public class TaskB {

    private static int words;
    private static int marks;

    public static void main(String[] args) {

        String fileIn = getFilePath(TaskB.class, "text.txt");
        String fileOut = getFilePath(TaskB.class, "resultTaskB.txt");

        words = 0;
        marks = 0;

        printConsole(fileIn);
        printText(fileOut, words, marks);

    }

    private static void printConsole(String fileIn) {
        try (FileReader fr = new FileReader(new File(fileIn));
             BufferedReader br = new BufferedReader(fr);
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] arrayLine = line.split(" ");
                words += arrayLine.length;
                for (String s : arrayLine) {
                    if (s.matches("[,.!?\\-:;]{1}")) {
                        words--;
                        marks++;
                    } else if (s.matches("[а-яА-ЯёЁ]*[,.!?:;]{1,3}")) marks++;
                }

            }
            System.out.printf("words=%d, marks=%d", words, marks);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPath(Class<TaskB> bClass) {
        String root = System.getProperty("user.dir");
        String simpleName = TaskB.class.getSimpleName();
        String name = TaskB.class.getName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);
        return path = root + separator + "src" + separator + path;
    }

    private static String getFilePath(Class<TaskB> bClass, String fileName) {
        return getPath(bClass) + fileName;
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
