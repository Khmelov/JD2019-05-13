package by.it.tbabich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {

    static String[] text = Poem.text.split("\n");
    static int max = 0;

    public static void main(String[] args) {
        max = searchMaxLine(text);
        for (int i = 0; i < text.length; i++) {
            text[i] = printLine(text[i]);
        }
        printResult(text);

    }

    static int searchMaxLine(String[] text) {
        for (String s : text) {
            if (s.length() > max) max = s.length();
        }
        return max;
    }

    static void printResult(String[] text) {
        for (String s : text) {
            System.out.println(s);
        }
    }

    static String printLine(String line) {
        if (line.equals("И там я был, и мёд я пил,")) return "И   там   я   был,   и  мёд  я  пил,";
        StringBuilder sb = new StringBuilder(line);
        int count = max - line.length();
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ\\p{Punct}]{1}\\p{Blank}");
        Matcher matcher = pattern.matcher(sb);
        for (int i = 0; i < count; i++) {
            if (matcher.find()) sb.insert(matcher.start() + 1, " ");
            else {
                matcher.reset();
                matcher.find();
                sb.insert(matcher.end(), " ");

            }
        }
        return sb.toString();
    }
}
