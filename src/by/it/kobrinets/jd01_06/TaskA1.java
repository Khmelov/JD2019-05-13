package by.it.kobrinets.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern compile = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher matcher = compile.matcher(text);
        while (matcher.find()){
            String word = matcher.group();
            System.out.println(word);
        }
    }
}
