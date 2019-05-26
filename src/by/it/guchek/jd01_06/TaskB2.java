package by.it.guchek.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        //StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯЁё[^?!.]]+"); //pettern описывающий все слова русского языка от 4-х символов
        //String [] mas = pattern.split("[а-яА-ЯЁё[^.?!]]+");
        Matcher matcher = pattern.matcher(Poem.text);
        int i = 0;
        int[] countchar = new int[14];

        while (matcher.find()) {

            String predl = matcher.group().replaceAll("[\\s:;.,-]+", " ").trim();
            System.out.println(predl);
            countchar[i] = predl.length();
            //System.out.print(countchar[i]);
            i++;
        }

        System.out.println(i);

        Arrays.sort(countchar);

        //for (int i1 = 0; i1 < countchar.length; i1++)  System.out.println(countchar[i1]);


        for (int i1 = 0; i1 < countchar.length; i1++) {
            matcher.reset();
            while (matcher.find()) {
                String predl = matcher.group().replaceAll("[\\s:;.,-]+", " ").trim();
                if (predl.length() == countchar[i1]){
                    System.out.println(predl);
                break;}
            }
        }
    }
}