package by.it.aadamovich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static void main(String[] args) {


        Pattern p = Pattern.compile("[а-яА-ЯёЁ]{2,}");
        Matcher m = p.matcher(Poem.text);
        while (m.find()) {
            boolean start = checkIsVowel(Poem.text.charAt(m.start()));
            boolean end = checkIsVowel(Poem.text.charAt(m.end() - 1));
            if ((end) && !(start)) {
                System.out.println(m.group());
            }
        }
    }

    private static boolean checkIsVowel(char letter) {
        boolean b = false;
        char[] abc = {'а', 'у', 'о', 'ы', 'и', 'э', 'я', 'ю', 'ё', 'е',
                'А', 'У', 'О', 'Ы', 'И', 'Э', 'Я', 'Ю', 'Ё', 'Е'};
        for (char c : abc) {
            if (letter == c) {
                b = true;
                break;
            }
        }
        return b;
    }
}


