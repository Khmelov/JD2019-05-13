package by.it.zhukova.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String [] words = {};
    private static int [] count = {};

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern p2 = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher m2 = p2.matcher(text);
        while (m2.find()) {
            String word = m2.group();
            process (word);
        }
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%1s=%1d %n", words[i], count[i]);
        }
    }
    private static void process(String word) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) {
                count[i]++;
                return;
            }}
                words = Arrays.copyOf(TaskA2.words, TaskA2.words.length + 1);
                count = Arrays.copyOf(TaskA2.count, TaskA2.count.length + 1);
                words[words.length-1]=word;
            count[count.length-1]=1;
    }
}