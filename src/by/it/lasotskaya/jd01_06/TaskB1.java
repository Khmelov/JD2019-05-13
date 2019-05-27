package by.it.lasotskaya.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        String words;
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);

        while (matcher.find()) {
            words=matcher.group();
            System.out.println(findVowels(words)?words : "");

        }
    }

    private static boolean findVowels (CharSequence w){
        char[] vowels= {'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю',
                'я', 'А', 'Е', 'Ё', 'И', 'О', 'У', 'Ы', 'Э', 'Ю', 'Я',};
        for (char vowel : vowels) {
            if (w.charAt(0) == vowel) {
                return false;
            }
        }

        for (char vowel : vowels) {
            if (w.charAt(0) != vowel && w.charAt(w.length() - 1) == vowel) {
                return true;
            }
        }

        return false;
        }

    }


