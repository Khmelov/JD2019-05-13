package by.it.adamovichjr.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String[] words = {};
    private static int[] count = {};

    private static int pos (String word){
        for (int i = 0; i < words.length; i++) {
            if(words[i].equals(word))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            String w = matcher.group();
            int p = pos(w);
            if(p >= 0)
                count[p]++;
            else {
                int last = words.length;
                words = Arrays.copyOf(words, last + 1);
                words[last] = w;
                count = Arrays.copyOf(count,last+1);
                count[last] = 1;
            }
        }
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i] + "="+count[i]);
        }
    }
}
