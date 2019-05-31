package by.it.dnevar.jd01_06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {

    private static String[] sentences = new String[0];

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern compile = Pattern.compile("[^.!?]+");
        Matcher matcher = compile.matcher(text);
        while(matcher.find()){
            String sentence = text.substring(matcher.start(), matcher.end());
            check(sentence);
            sortAndPrint(sentences);
        }
    }

    private static void sortAndPrint(String[] sentences) {
        String buffer;
        for (int i = 0; i < sentences.length-1; i++) {
            for (int j = 0; j < sentences.length-i-1; j++) {
                if(sentences[j].length()>sentences[j+1].length()){
                    buffer=sentences[j];
                    sentences[j]=sentences[j+1];
                    sentences[j+1]=buffer;
                }
            }

        }
        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }

    private static void check(String sentence) {
        sentence = sentence.replaceAll("[^а-яёА-ЯЁ]+"," ");
        sentence = sentence.trim();

        sentences= Arrays.copyOf(sentences,sentences.length+1);
        sentences[sentences.length-1]=sentence;
    }
}
