package by.it.guchek.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        //StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯЁё[^.?!]+]+"); //pettern описывающий все слова русского языка от 4-х символов
        //String [] mas = pattern.split("[а-яА-ЯЁё[^.?!]]+");

        Matcher matcher = pattern.matcher(Poem.text);
        int i=0;

        while (matcher.find()) {

            //String predl = matcher.group();

            String predl = matcher.group().replaceAll("[:;.,-]+"," ");
            predl.trim();

            System.out.println(i+" "+predl);
            i++;
            //System.out.println();
        }
        //System.out.println();
    }
}
