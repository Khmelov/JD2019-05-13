package by.it.yakimovich.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String [] array={};
    private static int [] counter={};

    private static int pos(String word){
        for (int i = 0; i <array.length ; i++) {
            if (array[i].equals(word))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Pattern pattern=Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher=pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            int p = pos(word);
            if (p >= 0) {
                counter[p]++;
        }
else{
    int last= array.length;
    array= Arrays.copyOf(array,last+1);
    array[last]=word;
    counter=Arrays.copyOf(counter,last+1);
    counter[last]=1;
}}
            for (int i = 0; i <array.length ; i++) {
                System.out.println(array[i]+"="+counter[i]);
            }
            }
}
