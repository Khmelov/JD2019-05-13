package by.it.aadamovich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {

        String[] sentences = Poem.text.split("\\n");
        int max = sentences[0].length();
        for (int i = 1; i < sentences.length; i++) {
            if (sentences[i].length() > max) {
                max = sentences[i].length();
            }
        }

        Pattern p = Pattern.compile("[ ]+");

        for (int i = 0; i < sentences.length; i++) {

            int diff = max - sentences[i].length();
            StringBuilder stringBuilder = new StringBuilder(sentences[i]);
            Matcher m = p.matcher(stringBuilder);

            while (diff > 0) {
                int start = 1;

                while (m.find(start)){
                    if (diff == 0) {
                        break;
                    }

                    stringBuilder.insert(m.start(), " ");
                    diff--;
                    start = m.end() + 1;
                }
            }
            sentences[i] = stringBuilder.toString();
        }
        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }
}
