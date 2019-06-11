package by.it.buymistrov.jd01_06;

import java.util.Random;

public class TaskC2 {
    public static String slow(String text) {

        String[] words = getWords(text);
        String resultText = "";

        Random random = new Random(0);
        while (resultText.length() < 100_000) {
            int rand = random.nextInt(words.length);
            resultText += (" " + words[rand]);
        }


        return resultText.trim();
    }

    public static String[] getWords(String text) {


        return text.replace("\n", " ").split(" ");

    }


    public static String fast(String text) {
        String[] words = getWords(text);

        StringBuilder sb = new StringBuilder();

        Random random = new Random(0);
        while (sb.length() < 100_000) {
            int rand = random.nextInt(words.length);
            if (sb.length() > 0)
                sb.append(" ");
            sb.append(words[rand]);
        }

        return sb.toString();

    }


    public static void main(String[] args) {

        long start = System.nanoTime();
        String resultText = slow(Poem.text);
        long end = System.nanoTime();
        long resultTime = end - start;
        System.out.println(resultText);
        System.out.println(resultTime/1000);


        long start2 = System.nanoTime();
        String resultTextFast = fast(Poem.text);
        long end2 = System.nanoTime();
        long resultTime2 = end2 - start2;
        System.out.println(resultTextFast);
        System.out.println(resultTime2/1000);


    }
}
