package by.it.kobrinets.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskB {
    public static void main(String[] args) {
        String fileData = getFilePath(TaskB.class, "text.txt");
        String fileTxt = getFilePath(TaskB.class, "resultTaskB.txt");

        StringBuilder text = new StringBuilder();
        readData(fileData, text);

        int countWords = getCountWords(text);
        int countSign = getCountMarks(text);
        printConsole(countWords, countSign);
        printFile(fileTxt, countWords, countSign);
    }

    private static void printConsole(int countWords, int countMarks) {
        System.out.printf("words=%d, punctuation marks=%d", countWords, countMarks);
    }

    private static int getCountWords(StringBuilder text) {
        int count = 0;
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    private static int getCountMarks(StringBuilder text) {
        int count = 0;
        Pattern pattern = Pattern.compile("\\p{Punct}+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    private static void printFile(String fileTxt, int countWords, int countMarks) {
        try (
                PrintWriter printWriter = new PrintWriter(new FileWriter(fileTxt))
        ) {
            printWriter.printf("words=%d, punctuation marks=%d", countWords, countMarks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readData(String fileData, StringBuilder text) {
        try (
                BufferedReader br = new BufferedReader(new FileReader(fileData))
        ) {
            while (true) {
                String s = br.readLine();
                if (s == null) break;
                text.append(s).append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getFilePath(Class<?> bClass, String fileName) {
        String path = getPath(bClass);
        return path + fileName;
    }

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