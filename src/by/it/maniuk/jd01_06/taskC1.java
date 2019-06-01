package by.it.maniuk.jd01_06;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class taskC1 {
   static StringBuilder sb;
    public static void main(String[] args) {


        Pattern all = Pattern.compile("[\\n]");
        Matcher matcherAll = all.matcher(Poem.text);

        String[] words = all.split(Poem.text);
       String max = words[0];
        for (String s : words) {
            if (max.length() < s.length()) {
                max = s;
            }

        }


        for (String word : words) {
            for (int j = 0; j < word.length() - 1; j++) {
                sb = new StringBuilder(word);
                for (int k = 0; k < sb.length(); k++) {
                    while (sb.length() - 1 != max.length()) {
                        if (sb.charAt(k) == ' ') {

                            sb.insert(k, "!!!");


                        }
                    }
                }
                System.out.println(sb.toString());
            }

        }
        System.out.println(max);
        System.out.println(max.length());
        }

    }

