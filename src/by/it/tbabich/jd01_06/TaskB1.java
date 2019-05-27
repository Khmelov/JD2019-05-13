package by.it.tbabich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            if (process(word.toCharArray()))
                System.out.println(word);;

        }
    }

    private static boolean process(char[] word) {
        String vowels = "АаУуОоЫыИиЭэЯяЮюЁёЕе";
        if (!vowels.contains(String.valueOf(word[0])) && vowels.contains(String.valueOf(word[word.length - 1])))
            return true;
        else return false;
    }
}
