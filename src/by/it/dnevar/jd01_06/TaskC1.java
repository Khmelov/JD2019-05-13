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
            int numSpaceToInsert = maxSentenceLength - sentences[i].length();
            int numSpaceInSentence = 0;
            Pattern space = Pattern.compile("\\s");
            Matcher spaceMatcher = space.matcher(sentences[i]);
            while(spaceMatcher.find()){
                numSpaceInSentence++;
            }
            int maxSpace = (int) Math.ceil(numSpaceToInsert/numSpaceInSentence);
            String spacesNew = "";
            for (int j = 0; j < maxSpace; j++) {
                spacesNew += " ";
            }
            Pattern spaceNew = Pattern.compile("\\s");
            Matcher spaceMatcherNew = spaceNew.matcher(sentences[i]);
            StringBuffer stringBuffer = new StringBuffer();
            int countAddedSpaces = 0;

            while(spaceMatcherNew.find()){
                if(numSpaceToInsert-countAddedSpaces<spacesNew.length()) {
                    spacesNew = spacesNew.substring(0, spacesNew.length() - 1);
                }
                spaceMatcherNew.appendReplacement(stringBuffer, spacesNew);
                countAddedSpaces += spacesNew.length();
            }
            spaceMatcherNew.appendTail(stringBuffer);
            System.out.println(stringBuffer.toString());
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
