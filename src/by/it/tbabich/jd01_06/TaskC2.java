package by.it.tbabich.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {
    private static String[] words = new String[0];
    private static int[] indexArray = new int[50000];

    public static void main(String[] args) {
        initialization(Poem.text);
        for (int i = 0; i < indexArray.length; i++) {
            indexArray[i] = (int) (Math.random() * words.length);
        }
        words = new String[0];
        long start = System.nanoTime();
        String line = slow(Poem.text);
        long end = System.nanoTime();
        long dtSlow = end - start;
        words = new String[0];
        System.out.printf("slow dt=%d\n", dtSlow);
        start = System.nanoTime();
        line = fast(Poem.text);
        end = System.nanoTime();
        long dtFast = end - start;
        System.out.printf("fast dt=%d\n", dtFast);
        System.out.printf("Отличие в скорости dtSlow/dtFast=%d", dtSlow / dtFast);

    }

    static String slow(String text) {
        initialization(text);
        String result = "";
        for (int i = 0; i < indexArray.length; i++) {
            result = result.concat(words[indexArray[i]]);
            result = result.concat(" ");
        }
        return result;
    }

    static String fast(String text) {
        initialization(text);
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < indexArray.length; i++) {
            result.append(words[indexArray[i]]).append(" ");
        }
        return result.toString();
    }

    private static void process(String word) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) {
                return;
            }
        }
        words = Arrays.copyOf(words, words.length + 1);
        words[words.length - 1] = word;
    }

    private static void initialization(String text) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            process(word);
        }
    }
}
