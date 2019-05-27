package by.it.trudnitski;

import by.it.trudnitski.jd01_06.Poem;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String[]words={};
    private static int[]counts={};

    public static void main(String[] args) {
        Pattern compile = Pattern.compile("[а-яА-ЯёЁ]+");
      //  Matcher matcher = compile.matcher(Poem.);
       // while(matcher.find()){
         //  String word = matcher.group();
           //process(word);
        }
       // printResult();
    //}

    private static void process(String word) {
        for (int i = 0; i <words.length ; i++) {
            if(words[i].equals(word)){
                counts[i]++;
                return;
            }
        }
        Arrays.copyOf(words,words.length);
        words[words.length-1]=word;
        Arrays.copyOf(counts,counts.length);
       // counts[counts.length-1]=count;

    }

    private static void printResult() {
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s=%d\n",words[i],counts[i]);
        }
    }
}
