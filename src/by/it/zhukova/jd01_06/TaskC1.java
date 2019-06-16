package by.it.zhukova.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        String poem = (Poem.text);
        String[] str = poem.split("\\n");
        int max = getMax(str);
        formated(str, max);
        print(str);
    }

    private static void print(String[] str) {
        String poem;
        StringBuilder result = new StringBuilder(str[0]);
        for (int i = 1; i < str.length; i++) {
            result = result.append('\n');
            result = result.append(str[i]);
        }
        poem=result.toString();
        System.out.println(poem);
    }

    private static void formated(String[] str, int max) {
        Pattern p2 = Pattern.compile("\\p{Blank}+");
        for (int i = 0; i < str.length; i++) {
     StringBuffer stringBuffer = new StringBuffer(str[i]);
     Matcher m2 = p2.matcher(stringBuffer);
            while (stringBuffer.length()<max) {
                int k = 0;
                while (m2.find(k)) {
                    stringBuffer = stringBuffer.insert(m2.start(), ' ');
                    k = m2.end() + 1;
                    if (stringBuffer.length() == max) break;
                }
            }
     str[i]=stringBuffer.toString();}
    }

    private static int getMax(String[] str) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < str.length; i++) {
            if (str[i].length()>max)
                max= str[i].length();
                   }
        return max;
    }
}

