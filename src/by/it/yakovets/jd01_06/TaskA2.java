package by.it.yakovets.jd01_06;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String[] words = new String[0];
    private static int[] counts = new int[0];

    public static void main(String[] args) {
        Pattern compile = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = compile.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            int p = pos(word);
            if (p >= 0) {
                counts[p]++;
            } else {
                int last = words.length;
                words = Arrays.copyOf(words, last + 1);
                words[last] = word;
                counts = Arrays.copyOf(counts, last + 1);
                counts[last] = 1;
            }
        }
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i] + "=" + counts[i]);
        }
    }

    private static int pos(String word) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) {
                return i;
            }
        }
        return -1;
    }
}
