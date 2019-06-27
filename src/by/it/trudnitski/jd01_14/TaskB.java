package by.it.trudnitski.jd01_14;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TaskB {
    private static String getPath(Class<?> aClass) {
        String root = System.getProperty("user.dir");
        String name = aClass.getName();
        String simpleName = aClass.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);
        path = root + separator + "src" + separator + path;
        return path;
    }

    public static void main(String[] args) {
        try (FileReader file = new FileReader(getPath(TaskA.class) + "text.txt");
             FileWriter out = new FileWriter(getPath(TaskB.class) + "resultTaskB.txt")) {
            Scanner sc = new Scanner(file);
            String str = null;
            while (sc.hasNextLine()) {
                str += " " + sc.nextLine().trim();
            }
            String words = str.replaceAll("[^а-яА-ЯёЁ  ]", " ").trim();
            String punctiation = str.replaceAll("[ а-яА-ЯёЁa-zA-Z ]", " ").trim();
            String[] word = words.split("[ ]+");
            String[] punc = punctiation.split("[ ]+");
            int count = word.length;
            int punktionMark = punc.length;
            System.out.printf("words=%d, punctuation marks=%d", count, punktionMark);
            out.write("words=" + count + ", " + "punctuation marks=" + punktionMark);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
