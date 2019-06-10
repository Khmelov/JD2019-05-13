package by.it.buymistrov.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {

        StringBuilder text = new StringBuilder(Poem.text);
        String[] sentences = text.toString().split("\n");
//        for (int i = 0; i < sentences.length; i++) {
//            System.out.println(sentences[i]);
//        }


        int max = 0;
        for (String sentence : sentences) {
            if (sentence.length() > max)
                max = sentence.length();
        }

        Pattern compile = Pattern.compile(" +");

        for (String sentence : sentences) {
            StringBuffer sb = new StringBuffer(sentence);

            Matcher matcher = compile.matcher(sb);

            int delta = max - sentence.length();


            int matcherStart = 0;
            for (int i = 0; i < delta; i++) {


                if (!matcher.find(matcherStart)) {
//

//                    System.out.println("reset");


                    matcher = compile.matcher(sb);
                    matcher.find();


                }
                matcherStart = matcher.end();
//                System.out.println("insert" + " "+ matcherStart);

                sb.insert(matcherStart, " ");
                matcherStart++;


            }
            System.out.println(sb);

        }


    }
}
