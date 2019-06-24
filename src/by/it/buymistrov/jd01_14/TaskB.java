package by.it.buymistrov.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    private static String filePath = getFilePath("text.txt");
    private static String fileOutPath = getFilePath("resultTaskB.txt");
    private static int words = 0;
    private static int marks = 0;


    private static String getFilePath(String filename) {
        return getPath() + filename;
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

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            Pattern wordsP = Pattern.compile("[,:.! -]");

            while (reader.ready()) {
                String line = reader.readLine();
                String[] wordsArr = wordsP.split(line);
                for (String word : wordsArr) {
                    if (!word.isEmpty()) {
                        words++;
                    }
                }
                Pattern marksP = Pattern.compile("[^(а-яА-ЯёЁ )]");
                int c = 0;
                Matcher marksM = marksP.matcher(line);
                while (marksM.find()) {
                    if ((marksM.start() - c) > 1) {
                        marks++;
                    }
                    c = marksM.start();
                }
            }
            System.out.printf("words=%d marks=%d", words, marks);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(
                new FileWriter(fileOutPath))) {
            out.printf("words=%d marks=%d", words, marks);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}