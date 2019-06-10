package by.it.guchek.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {

    private static String[] w = new String[0];
    private static int[] count = {};

    private static int poz(String word){
        for (int i = 0; i < w.length; i++) {
            if (w[i].equals(word))
                return i;
        }
        return -1; //если не нашли дальше в тексте ни одно такое слово вернуть -1
    }


    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("[а-яА-ЯЁё]+"); //pettern описывающий все слова русского языка
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            int p = poz(word);
            if (p >= 0) {
                count[p]++;
            } else {
                int last = w.length;
                w = Arrays.copyOf(w, last + 1);
                w[last] = word;   //запишем искомое слово в массив
                count = Arrays.copyOf(count, last + 1);
                count[last] = 1; // укажем что частота повторений слова = 1

            }
        }
            for (int i = 0; i < w.length; i++) {
                System.out.println(w[i]+"="+count[i]);
            }
    }
}
