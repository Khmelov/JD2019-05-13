package by.it.yakovets.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        String text = Poem.text;
        String[] strArray = text.split("\n");
        int max = strArray[0].length();
        int[] countlength = new int[strArray.length];
        int[] countspace = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            if (max < strArray[i].length()) {
                max = strArray[i].length();
            }
        }
        for (int i = 0; i < countlength.length; i++) {
            countlength[i] = max - strArray[i].length();
            countspace[i] = strArray[i].length() - strArray[i].replaceAll(" ", "").length();
            System.out.println("строка № " + i + " Разница длины " + countlength[i] + " " + "Пробелы " + countspace[i]);
            StringBuilder str = new StringBuilder(strArray[i]);
            Pattern compile = Pattern.compile("\\s");
            Matcher matcher = compile.matcher(str);
            int r = countlength[i] / countspace[i];
//            for (int j = 0; j < r; j++) {
//
//                while (matcher.find()) {
//                    str.replace()
//
//
//                    }
//
//                }
            System.out.println(str);
            }
        }
    }



