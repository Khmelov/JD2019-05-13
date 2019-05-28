package by.it.dilkevich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        printTextAlign(Poem.text);
    }

    private static void printTextAlign(String text) {
        StringBuilder sb = new StringBuilder(text);
        String[] mas = text.split("\\n");
        int [] countOfSpaces = new int[mas.length];
        Pattern pattern = Pattern.compile("\\s");

        int maxLenght = 0;
        int neededSpaces = 0;

        for (int i = 0; i < mas.length; i++) {
            if(mas[i].length() > maxLenght)
                maxLenght = mas[i].length();
        }

        for (int i = 0; i < mas.length; i++) {
            Matcher matcher = pattern.matcher(mas[i]);
            while (matcher.find()){
                countOfSpaces[i]++;
            }
        }

        for (int i = 0; i < countOfSpaces.length; i++) {
            Matcher matcher = pattern.matcher(mas[i]);
            while (matcher.find() && countOfSpaces[i] != 0){
                int end = matcher.end();
                int start = matcher.start();
                sb = sb.append(mas[i]).insert(start, "  ");
                countOfSpaces[i]--;

            }

        }
        System.out.println(sb);
    }}
