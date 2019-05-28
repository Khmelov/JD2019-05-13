package by.it.izaykoff.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {


    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-яёЁ]{2,}");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()){
            String words = matcher.group();
            checkWords(words);
        }

    }

    private static void checkWords(String word){
        char[] soglLet = new char[]{'б','в','г','д','ж','з','й','к','л','м','н','п','р','с','т','ф','х','ц','ч','ш','щ',
                'Б','В','Г','Д','Ж','З','Й','К','Л','М','Н','П','Р','С','Т','Ф','Х','Ц','Ч','Ш','Щ'};
        char[] glastLet = new char[]{'а', 'о', 'и', 'е', 'ё', 'э', 'ы', 'у', 'ю', 'я'};
        char first = word.charAt(0);
        char last = word.charAt(word.length()-1);
        for (char c : soglLet) {
            if (c == first){
                for (char ch : glastLet) {
                    if (ch == last){
                        System.out.println(word);
                    }
                }
            }
        }
    }



}