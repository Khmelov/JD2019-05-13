package by.it.yakovets.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        String text = Poem.text;
        text=text.replaceAll("\\.{3}"," ");
        String[] strArray = text.split("[.}?^]+");
        for (int i = 0; i < strArray.length; i++) {
            strArray[i] = strArray[i].trim();
            strArray[i] = strArray[i].replaceAll("[,-;!:\n]", " ");
            strArray[i] = strArray[i].replaceAll(" {2,}", " ");

        }
        for (int i = 0; i < strArray.length - 1; i++) {
            for (int j = i + 1; j < strArray.length; j++) {
                if (strArray[i].length() > strArray[j].length()) {
                    String m = strArray[i];
                    strArray[i] = strArray[j];
                    strArray[j] = m;
                }
            }
        }
        for (int i = 0; i < strArray.length; i++) {
            System.out.print(strArray[i]+"\n");
        }
    }
}