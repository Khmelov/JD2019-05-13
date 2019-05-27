package by.it.maniuk.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String[] words = new String[0];
    private static int[] counts = new int[0];

    public static void main(String[] args) {

        Pattern compile = Pattern.compile("[а-яА-ЯёЁ]+,}");
        Matcher matcher = compile.matcher(Poem.text);
        while (matcher.find()) {
            int pos = matcher.start();
            int len = matcher.end() - matcher.start();
            while (matcher.find()) {
                String word = matcher.group();
                process(word);
            }
        }
    }

    private static void process(String word) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) {
                counts[i]++;
                return;
            }

        }
    }
}
