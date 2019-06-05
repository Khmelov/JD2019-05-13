package by.it.tbabich.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    static String[] text = Poem.text.split("\\.\\n");

    public static void main(String[] args) {
        replace(text);
        Arrays.sort(text, new StringComparator());
        for (String s :text) {
            System.out.println(s);
        }
    }

    private static void replace(String[] text) {
        for (int i = 0; i < text.length; i++) {
        text[i] = text[i].replaceAll("[^а-яА-ЯёЁ]+", " ").trim();
        }
    }

    private static void printResult(String[] text){
        for (String s: text) {
            System.out.println(s);
        }
    }
}
