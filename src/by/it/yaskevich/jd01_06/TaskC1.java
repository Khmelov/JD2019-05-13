package by.it.yaskevich.jd01_06;

import java.util.Arrays;

public class TaskC1 {
    public static void main(String[] args) {
        String[] sentences = Poem.text.split("\n");

        int maxLength = getMaxLength(sentences);

        StringBuilder builder = new StringBuilder(maxLength);
        for (int i = 0; i < sentences.length; i++) {
            int difference = maxLength - sentences[i].length();
            if (difference == 0)
                continue;

            String[] strings = sentences[i].split("[ ]");

            int [] spaces = new int[strings.length - 1];
            Arrays.fill(spaces, difference / (strings.length - 1) + 1);
            for (int j = 0; j < difference % (strings.length - 1); j++) {
                spaces[j]++;
            }

            builder.delete(0, builder.length());
            for (int j = 0; j < strings.length; j++) {
                builder.append(strings[j]);
                if (j < spaces.length)
                for (int k = 0; k < spaces[j]; k++) {
                    builder.append(' ');
                }
            }
            sentences[i] = builder.toString();
        }
        printArray(sentences);
    }

    private static int getMaxLength(String[] sentences) {
        int maxLength = 0;
        for (String sentence : sentences) {
            if (maxLength < sentence.length())
                maxLength = sentence.length();
        }
        return maxLength;
    }

    private static void printArray(String[] sentences) {
        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }
}
