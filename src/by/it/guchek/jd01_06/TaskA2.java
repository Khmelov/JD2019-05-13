package by.it.guchek.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {

    private static String[] w = new String[0];
    private static int[] count = {};

    private static int poz(String word){
        for (int i = 0; i < w.length; i++) {
            if (w[i]==word)
                return i;
        }
        return -1; //если не нашли не одно слово вернуть -1
    }


    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯЁё]+"); //pettern описывающий все слова русского языка
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()){
            String word = matcher.group();
            int p = poz(word);
            if (p>=0) {
                count[p]++;
            }
            else {}

        }

    }
}
