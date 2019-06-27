package by.it.yaskevich.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) {
        int wordsCount = 0;
        int punctuationCount = 0;
        Pattern wordsPattern = Pattern.compile("[\\s,:.!-]");
        Pattern punctuationPattern = Pattern.compile("[^а-яА-ЯёЁ\\s]");

        try (BufferedReader br = new BufferedReader(new FileReader(getFilePath(TaskB.class, "text.txt")))) {
            while (br.ready()) {
                String line = br.readLine();

                String[] words = wordsPattern.split(line);
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordsCount++;
                    }
                }

                int start = 0;
                Matcher punctuationMatcher = punctuationPattern.matcher(line);
                while (punctuationMatcher.find()) {
                    if ((punctuationMatcher.start() - start) > 1) {
                        punctuationCount++;
                    }
                    start = punctuationMatcher.start();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        printData(String.format("words=%d punctuation marks=%d", wordsCount, punctuationCount));
    }

    private static void printData(String data) {
        System.out.println(data);

        try (PrintWriter out = new PrintWriter(
                new FileWriter(getFilePath(TaskB.class, "resultTaskB.txt")))) {
            out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getFilePath(Class<?> aClass, String fileName) {
        String root = System.getProperty("user.dir");
        String separator = File.separator;
        String name = aClass.getName();
        return root + separator + "src" + separator +
                name.replace(aClass.getSimpleName(), "").replace(".", separator) + fileName;
    }

}
