package by.it.yaskevich.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static char[] vowels = {'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я'};
    static {
        Arrays.sort(vowels);
    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            if (validate(word))
                System.out.println(word);
        }
    }

    private static boolean validate(String word) {
        if (word.length() >= 2) {
            word = word.toLowerCase();
            if ((Arrays.binarySearch(vowels, word.charAt(0)) < 0) && (Arrays.binarySearch(vowels, word.charAt(word.length() - 1)) > -1))
                return true;
        }
        return false;
    }
}
