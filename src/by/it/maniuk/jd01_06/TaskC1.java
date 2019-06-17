package by.it.maniuk.jd01_06;


import java.util.Arrays;
import java.util.regex.Pattern;

public class TaskC1 {

    public static void main(String[] args) {
        Pattern all = Pattern.compile("[\\n]");
        String[] sentences = all.split(Poem.text);
        String max = sentences[0];
        for (String s : sentences) {
            if (max.length() < s.length()) {
                max = s;
            }
        }
        StringBuilder sb = new StringBuilder(max.length());
        for (String sentence : sentences) {
            int difference = max.length() - sentence.length();
            String[] lines = sentence.split("[ ]");
            int[] spaces = new int[lines.length - 1];
            Arrays.fill(spaces, (difference) / (lines.length - 1) + 1);
            for (int d = 0; d < difference % (lines.length - 1); d++) {
                spaces[d]++;
            }
            sb.delete(0, sb.length());
            for (int q = 0; q < lines.length; q++) {
                sb.append(lines[q]);
                if (q < spaces.length)
                    for (int k = 0; k < spaces[q]; k++) {
                        sb.append(' ');
                    }
            }
            System.out.println(sb.toString());
        }

        }
    }






