package by.it.guchek.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    //private static String [] sent= {};
    //private static int[] count = {};

    /*private static int poz(String predl){
        for (int i = 0; i < sent.length; i++) {
            if (sent[i].equals(predl))
                return i;
        }
        return -1; //если не нашли дальше в тексте ни одно такое слово вернуть -1
    }*/

    public static void main(String[] args) {
        String buffer;
        //String buffer = new String();
        String [] sent= {};
        int[] count = {};

        //StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯЁё[^?!.]]+"); //pettern описывающий все слова русского языка
                                                                //String [] mas = pattern.split("[а-яА-ЯЁё[^.?!]]+");
        Matcher matcher = pattern.matcher(Poem.text);

                                                                    //int[] countchar = new int[14];
                                                                    //String [] maspredl;

        while (matcher.find()) {

            String predl = matcher.group().replaceAll("[\\s:;.,-]+", " ").trim();
            //int k=poz(predl);
            //sent[i]=predl;                                                    //System.out.println(predl);
            int last = sent.length;
            sent = Arrays.copyOf(sent, last+1);
            sent[last] = predl;   //запишем искомое слово в массивArrays.copyOf()
           // System.out.println(sent[last]);
            count = Arrays.copyOf(count, last+1);
            count[last] = sent[last].length();

                                            //System.out.print(countchar[i]);
                                                               //maspredl[]=new String(predl);
        }
                                                                //System.out.println(i);
        //Arrays.sort(count);
       // Arrays.sort(count);
                                                                //Arrays.sort(maspredl);
        //for (int i1 = 0; i1 < count.length; i1++)  System.out.println(count);


        boolean swap;
        int last1=(sent.length-1);
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
            last1--; //за один проход самый большой элемент занял свое место в конце
        }
        while (swap); //как только перестановок не было - закончить цикл

        for (int x = 0; x < sent.length; x++) {
            System.out.printf("%s%n",sent[x]);
        }
        /*String d=new String();
        for (int i1 = 0; i1 < countchar.length; i1++) {
            matcher.reset();
            while (matcher.find()) {
                String predl = matcher.group().replaceAll("[\\s:;.,-]+", " ").trim();
                if (predl.length() == countchar[i1])
                    if (!d.equals(predl)){
                        d=predl;
                        System.out.printf("%s%n",predl);
                    } else {i1=i1+1;
                      break;}

            }
        }*/

    }
}