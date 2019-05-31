package by.it.yaskevich.jd01_06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        Pattern patternReplace = Pattern.compile("[.]{2,}");
        String text = patternReplace.matcher(Poem.text).replaceAll(" ");

        patternReplace = Pattern.compile("[^а-яА-ЯёЁ.]+");

        String[] sentences = text.split("[.!]+");
        for (int i = 0; i < sentences.length; i++) {
            sentences[i] = patternReplace.matcher(sentences[i]).replaceAll(" ").trim();
        }

        Arrays.sort(sentences, new Comparator<String>() {
            @Override
            public int compare(String sentence1, String sentence2) {
                return sentence1.length() - sentence2.length();
            }
        });

        printArray(sentences);
    }

    private static void printArray(String[] sentences) {
        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }
}
