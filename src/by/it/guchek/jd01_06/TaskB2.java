package by.it.guchek.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {

    public static void main(String[] args) {
        String buffer;
        String [] sent= {};
        int[] count = {};

        StringBuilder sb = new StringBuilder(Poem.text);
        int h=sb.lastIndexOf("...");
        StringBuilder p=sb.replace(767, 770, " " );
        //System.out.println(h);
        Pattern pattern = Pattern.compile("[а-яА-ЯЁё[^?!.]]+"); //pettern описывающий все слова русского языка
        Matcher matcher = pattern.matcher(p);

                                                                    //int[] countchar = new int[14];
                                                                    //String [] maspredl;

        while (matcher.find()) {
            //String h =matcher.replaceAll("\\.3"," ");
            String predl = matcher.group().replaceAll("[\\s:;.,-]+", " ").trim();
            int last = sent.length;
            sent = Arrays.copyOf(sent, last+1);
            sent[last] = predl;   //запишем искомое предложение в массив предложений
            //System.out.println(sent[last]);
            count = Arrays.copyOf(count, last+1);
            count[last] = sent[last].length();
        }

        boolean swap;
        int last1=(sent.length-1);            //СОРТИРОВКА СТРОК МАССИВА ПО ДЛИНЕ
        do {
            swap = false;   //устанавливаем булевский маркер
            for (int i = 0; i <last1; i++) {
                if (sent[i].length() > sent[i+1].length()) {
                    buffer=sent[i];
                    sent[i]=sent[i+1];
                    sent[i+1]=buffer;
                    swap=true;  //была хотя бы одна перестановка
                }
            }
            last1--; //за один проход самый длинный элемент занял свое место в конце
        }
        while (swap); //как только перестановок не было - закончить цикл

        for (int x = 0; x < sent.length; x++) {
            System.out.printf("%s%n",sent[x]);
        }
    }
}