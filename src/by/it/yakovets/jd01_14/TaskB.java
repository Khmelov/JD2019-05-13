package by.it.yakovets.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    public static void main(String[] args) throws IOException {
        String text = getPath(TaskB.class, "text.txt");
        String result = getPath(TaskB.class, "resultTaskB.txt");

        Pattern words = Pattern.compile("[а-яА-ЯёЁ]+");
        Pattern punctMark = Pattern.compile("[,:.!?]");

        try (BufferedReader in = new BufferedReader(new FileReader((text)));
             PrintWriter writer = new PrintWriter(new FileWriter(result))
        ) {
            int countWords = 0;
            int countMarks = 0;
            while (in.ready()) {
                String line = in.readLine();
                Matcher wordMatcher = words.matcher(line);
                Matcher markMatcher = punctMark.matcher(line);
                while (wordMatcher.find()) {
                    countWords++;
                }
                while (markMatcher.find()) {
                    countMarks++;
                }

            }
            writer.println("words=" + countWords);
            writer.println("punctuation marks="+countMarks);
            System.out.println("words=" + countWords);
            System.out.println("punctuation marks=" + countMarks);
        }

        }

        private static String getPath (Class < ? > aClass, String filename){
            return getPath(aClass) + filename;
        }

        private static String getPath (Class < ? > aClass){
            String root = System.getProperty("user.dir");
            String name = aClass.getName();
            String simpleName = aClass.getSimpleName();
            String separator = File.separator;
            String path = name.replace(simpleName, "").replace(".", separator);

            path = root + separator + "src" + separator + path;
            return path;
        }
    }