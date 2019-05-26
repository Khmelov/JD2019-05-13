package by.it.guchek.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        //StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯЁё]+"); //pettern описывающий все слова русского языка
        Matcher matcher = pattern.matcher(Poem.text);

        String str = "БбВвГгДджЖжЗзКкЛлМмНнПпРрСсТтФфХхЦцЧчШшЩщЙй";
        char [] ch = str.toCharArray();
        String str1 ="АаОоЭэИиУуЫыЕеЁёЮюЯя";
        char [] ch2 = str1.toCharArray();

        while (matcher.find()) {
            String word = matcher.group();
            int start = matcher.start();
            int grlen = matcher.group().length();
            int count = 0;           //счетчик совпадений букв с условием 1-первая 2- и последняя


            for (int i = 0; i <ch.length ; i++) {
                char c = matcher.group().charAt(0);
                if (c==ch[i])
                    //System.out.println(word);
                count ++;
            }
            for (int i = 0; i <ch2.length ; i++) {
                char c2 = matcher.group().charAt(grlen-1);
                if (c2==ch2[i])
                    //System.out.println(word);
                count ++;
            }
            if (count==2)
                System.out.println(word);
        }
    }

}
