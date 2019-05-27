package by.it.yakimovich.jd01_06;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {

              String text = Poem.text;
                String[] wordArray = text.split("[\\s,.:!?]+");
                Pattern pattern1 = Pattern.compile("[БПВФДТЗСЖШЧЦЩГКХМНЛР]+");
                Pattern pattern2 = Pattern.compile("[аоэиуыеёюя]+");
                for (String word : wordArray) {
                    Matcher matcher1 = pattern1.matcher(word);
                    int start=matcher1.start();
                    Matcher matcher2 = pattern2.matcher(word);
                    int end=matcher2.end();


                                           System.out.println(word);
                    }
                }
            }



