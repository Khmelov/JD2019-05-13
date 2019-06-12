package by.it.dilkevich.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static String[] words = new String[0];


    public static void main(String[] args) {
        printText(Poem.text);

    }



    public static void printText(String text) {
        Pattern pattern = Pattern.compile("[А-Яа-яЁё]+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            words = Arrays.copyOf(words, words.length + 1);
            words[words.length - 1] = matcher.group();
        }
        regexPattern();
    }

    private static void regexPattern() {
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith("a") ||
                    words[i].startsWith("о") ||
                    words[i].startsWith("и") ||
                    words[i].startsWith("е") ||
                    words[i].startsWith("ё") ||
                    words[i].startsWith("э") ||
                    words[i].startsWith("ы") ||
                    words[i].startsWith("у") ||
                    words[i].startsWith("ю") ||
                    words[i].startsWith("я") ||
                    words[i].startsWith("О") ||
                    words[i].startsWith("И") ||
                    words[i].startsWith("Е") ||
                    words[i].startsWith("Ё") ||
                    words[i].startsWith("Э") ||
                    words[i].startsWith("Ы") ||
                    words[i].startsWith("У") ||
                    words[i].startsWith("Ю") ||
                    words[i].startsWith("Я")){
                continue;
            }
            else{
                    if (words[i].endsWith("а") ||
                        words[i].endsWith("о") ||
                        words[i].endsWith("и") ||
                        words[i].endsWith("е") ||
                        words[i].endsWith("ё") ||
                        words[i].endsWith("э") ||
                        words[i].endsWith("ы") ||
                        words[i].endsWith("у") ||
                        words[i].endsWith("ю") ||
                        words[i].endsWith("я")) {
                        System.out.println(words[i]);
                }
                    else
                        continue;
            }


        }
    }
}
