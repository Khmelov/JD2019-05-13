package by.it.buymistrov.jd01_06;

import java.util.Arrays;
import java.util.Comparator;

public class TaskB2 {

    public static String[] trimProbel(String text) {



        String[] text1 = text
                .replace("...", " ")
                .replace("\n", " ")
                .replace(".", "\t")
                .replaceAll("[\\p{Punct}]+", " ")
                .replaceAll(" +", " ")
                .split("\t");

        for (int i = 0; i < text1.length; i++) {
            text1[i] = text1[i].trim();
        }
        return text1;
    }

    static class SortByCost implements Comparator<String> {
        public int compare(String a, String b) {
//            System.out.println("chto-nibud");
            return (a.length() < b.length())?-1:1;
        }
    }



    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
       String[] stroka =  trimProbel(Poem.text);



       Arrays.sort(stroka, new SortByCost());

//       String [] sroka2 = new String[stroka.length];
//
//       System.arraycopy();


        for (int i = 0; i < stroka.length; i++) {
            System.out.println(stroka[i]);
        }

    }
}
