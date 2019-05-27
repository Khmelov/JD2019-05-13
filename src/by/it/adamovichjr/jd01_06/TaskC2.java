package by.it.adamovichjr.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {
    public static void main(String[] args) {

        long start = System.nanoTime();
        String newText = slow(Poem.text);
        long finish = System.nanoTime() - start;
        System.out.println(finish);

        Long fastStart = System.nanoTime();
        String fastText = fast(Poem.text);
        Long fastFinish = System.nanoTime() - fastStart;
        System.out.println(fastFinish);


    }
    private static String slow(String text){
        String[] mas = text.split("[^а-яА-ЯёЁ]+");
        String bigText =" ";
        while (bigText.length() < 100000)
            for (int i = 0; i < mas.length; i++) {
                if(bigText.length() > 100000)
                    break;
                bigText = bigText.concat(" ").concat(mas[i]);
            }
        return bigText;
    }
    private static String fast(String text){
        StringBuilder sb = new StringBuilder(" ");
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(text);
        while (sb.length() < 100000){
            int start = 0;
            while (matcher.find(start)) {
                if (sb.length() > 100000)
                    break;
                String w = matcher.group();
                sb.append(" ");
                sb.append(w);
                start = matcher.end();
            }
        }
        String finalTexst = sb.toString();
        return finalTexst;
    }
}
