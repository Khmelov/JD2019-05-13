package by.it.dnevar.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    private static String[] sentences = new String[0];
    private static int[] senLen = new int[0];

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern compile = Pattern.compile("[^\\n]+");
        Matcher matcher = compile.matcher(text);

        while (matcher.find()){
            String sentence = matcher.group();
            sentences= Arrays.copyOf(sentences,sentences.length+1);
            sentences[sentences.length-1]=sentence;
        }

        int maxSentenceLength = getMaxSentenceLength(sentences);



        for (int i = 0; i < sentences.length; i++) {
            StringBuilder buff = new StringBuilder(sentences[i]);
            Pattern space = Pattern.compile("[\\s]+");

            while(buff.length() < maxSentenceLength){
                int start = 0;
                Matcher spaceMatcher = space.matcher(buff);

                while(spaceMatcher.find(start)){

                    if(buff.length() == maxSentenceLength) {
                        break;
                    }
                    buff.insert(spaceMatcher.start()+1," ");
                    start = spaceMatcher.end()+1;
                }
            }
            System.out.println(buff);
            buff.delete(0,buff.length());

        }
    }

    private static int getMaxSentenceLength(String[] array){
        int maxSentenceLength = 0;
        for (int i = 0; i < sentences.length; i++) {
            if(sentences[i].length()>maxSentenceLength){
                maxSentenceLength = sentences[i].length();
            }
        }
        return maxSentenceLength;
    }
}
