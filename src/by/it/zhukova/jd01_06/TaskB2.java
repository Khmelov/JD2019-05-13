package by.it.zhukova.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        String poem = (Poem.text);
        String[] sentence = method1(poem);
        int[] pos = sort(sentence);
        for (int i = 0; i < pos.length; i++) {
            System.out.print(sentence[pos[i]]+"\n");
        }
    }

    private static int [] sort(String[]sent) {
        int [] len =  new int [sent.length];
        int [] pos =  new int [sent.length];
        for (int i = 0; i < sent.length; i++) {
            len[i] = sent[i].length();
            pos [i] = i;
        }
        int m=0;
        int s=0;
        boolean swap;
        int last = sent.length - 1;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if (len[i] > len[i+1]) {
                    m = len[i];
                    len[i] = len[i + 1];
                    len[i + 1] = m;
                    s=pos[i];
                    pos[i]=pos[i+1];
                    pos[i+1]=s;
                    swap = true;
                }
            }
            last--;
        } while (swap);
        return pos;
    }

    private static String[] method1(String text) {
        String text2 = text.replaceAll("\\.\\.\\.", " ");
        String[] strArray = text2.split("\\.|\\!");
        for (int i = 0; i < strArray.length; i++) {
        //  StringBuilder sent = new StringBuilder(strArray[i]);
            Pattern p2 = Pattern.compile("\\p{Punct}+");
            Matcher m2 = p2.matcher(strArray[i]);
            while (m2.find()) {
                String sign = m2.group();
                strArray[i] = strArray[i].replaceAll(sign, " ");
            }
            Pattern p3 = Pattern.compile("\\n");
            Matcher m3 = p3.matcher(strArray[i]);
            while (m3.find()) {
                String sign = m3.group();
                strArray[i] = strArray[i].replaceAll(sign, " ");
            }
            Pattern p4 = Pattern.compile("\\p{Blank}+");
            Matcher m4 = p4.matcher(strArray[i]);
            while (m4.find()) {
                String sign = m4.group();
                strArray[i] = strArray[i].replaceAll(sign, " ");
            }
            strArray[i] = strArray[i].trim();
           // System.out.println(strArray[i]);
        }
        return strArray;
    }

    }

