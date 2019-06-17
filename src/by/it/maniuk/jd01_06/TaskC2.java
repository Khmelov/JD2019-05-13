package by.it.maniuk.jd01_06;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {
    static int[] w = new int[100000];

    public static void main(String[] args) {
        long timeStart = System.nanoTime();
        slow(Poem.text);
        long timeStop = System.nanoTime();
        System.out.println(timeStop - timeStart);
        long timeStart2 = System.nanoTime();
        fast(Poem.text);
        long timeStop2 = System.nanoTime();
        System.out.println(timeStop2 - timeStart2);

    }

    public static String slow(String text) {
        Pattern all = Pattern.compile("[^а-яА-ЯёЁ.]");
        Matcher sentences = all.matcher(text);
        String s = sentences.replaceAll(" ");
        String[] words = s.split(" ");
        String longWord = "";

        for (int i = 0; i < 100000; i++) {
            w[i] = new Random().nextInt(words.length);
            longWord = longWord.concat(words[w[i]] + " ");
        }
        return longWord;
    }

    public static String fast(String text) {
        Pattern all = Pattern.compile("[^а-яА-ЯёЁ.]");
        Matcher sentences = all.matcher(text);
        String s = sentences.replaceAll(" ");
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 100000;j++) {

                sb.append(words[w[j]]).append(" ");



        }
       return sb.toString();
    }
}

