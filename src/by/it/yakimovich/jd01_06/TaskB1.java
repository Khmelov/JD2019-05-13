package by.it.yakimovich.jd01_06;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        String text = Poem.text;
        printText(text);
    }

    private static void printText(String text){
                String[] wordArray = text.split("[\\s,.:!?]+");
                for (int i = 0; i <wordArray.length ; i++) {
                    if (wordArray[i].startsWith("б")|(wordArray[i].startsWith("Б"))|
                            wordArray[i].startsWith("в")|(wordArray[i].startsWith("В"))|
                            wordArray[i].startsWith("г")|(wordArray[i].startsWith("Г"))|
                            wordArray[i].startsWith("д")|(wordArray[i].startsWith("Д"))|
                            wordArray[i].startsWith("ж")|(wordArray[i].startsWith("Ж"))|
                            wordArray[i].startsWith("з")|(wordArray[i].startsWith("З"))|
                            wordArray[i].startsWith("й")|(wordArray[i].startsWith("Й"))|
                            wordArray[i].startsWith("к")|(wordArray[i].startsWith("К"))|
                            wordArray[i].startsWith("л")|(wordArray[i].startsWith("Л"))|
                            wordArray[i].startsWith("м")|(wordArray[i].startsWith("М"))|
                            wordArray[i].startsWith("н")|(wordArray[i].startsWith("Н"))|
                            wordArray[i].startsWith("п")|(wordArray[i].startsWith("П"))|
                            wordArray[i].startsWith("р")|(wordArray[i].startsWith("Р"))|
                            wordArray[i].startsWith("с")|(wordArray[i].startsWith("С"))|
                            wordArray[i].startsWith("т")|(wordArray[i].startsWith("Т"))|
                            wordArray[i].startsWith("ф")|(wordArray[i].startsWith("Ф"))|
                            wordArray[i].startsWith("х")|(wordArray[i].startsWith("Х"))|
                            wordArray[i].startsWith("ц")|(wordArray[i].startsWith("Ц"))|
                            wordArray[i].startsWith("ч")|(wordArray[i].startsWith("Ч"))|
                            wordArray[i].startsWith("ш")|(wordArray[i].startsWith("Ш"))|
                            wordArray[i].startsWith("щ")|(wordArray[i].startsWith("Щ")))

                    if (wordArray[i].endsWith("а")|(wordArray[i].endsWith("е"))|
                            wordArray[i].endsWith("и")|wordArray[i].endsWith("ё")|
                            wordArray[i].endsWith("о")|wordArray[i].endsWith("у")|
                            wordArray[i].endsWith("ы")|(wordArray[i].endsWith("э"))|
                            wordArray[i].endsWith("ю")|(wordArray[i].endsWith("я")))

                     {
                         System.out.println(wordArray[i]);

                    }

        }

            }}



