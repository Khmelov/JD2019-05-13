package by.it.aadamovich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher m = p.matcher(sb);

        while (m.find()) {
            int position = m.start();
            sb.setCharAt(position + 3, '#');
            if (m.group().length() >= 7) {
                sb.setCharAt(position + 6, '#');
            }
        }
        System.out.println(sb);
    }
}
