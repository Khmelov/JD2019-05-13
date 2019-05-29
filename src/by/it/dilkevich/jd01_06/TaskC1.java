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

        for (int i = 0; i < mas.length; i++) {
            String [] mas1 = mas[i].split(" ");
            int length = 0;
            for (int i1 = 0; i1 < mas1.length; i1++) {
                length += mas1[i1].length();
            }
            while (length <maxLenght){
                for (int j = 0; j < mas1.length-1; j++) {
                    mas1[j] = mas1[j].concat(" ");
                    length = length + 1;
                    if(length == maxLenght)
                        break;
                }
            }
            mas[i] = "";
            for (int j = 0; j < mas1.length; j++) {

                mas[i] = mas[i].concat(mas1[j]);
            }

            }

        for (String s :
             mas) {
            System.out.println(s);

        }
        }

    }
