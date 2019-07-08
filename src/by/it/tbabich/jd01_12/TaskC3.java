package by.it.tbabich.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC3 {

    private static Pattern pattern;
    private static Matcher matcher;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        ArrayList<String> symbols = new ArrayList<>();
        pattern = Pattern.compile("[(){}\\[\\]]{1}");
        matcher = pattern.matcher(line);
        while (matcher.find()) {
            symbols.add(matcher.group());
        }
        System.out.println(isCorrect(symbols));
    }

    private static boolean isCorrect(ArrayList<String> symbols) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < symbols.size(); i++) {
            sb.append(symbols.get(i));
        }
        System.out.println(sb.toString());
        clear(sb, "\\{}");
        clear(sb, "\\[]");
        clear(sb, "\\(\\)");
        System.out.println(sb);
        return sb.toString().equals("");
    }

    private static void clear(StringBuilder sb, String s) {
        pattern = Pattern.compile(s);
        matcher = pattern.matcher(sb);
        while (matcher.find()) {
            int index = sb.indexOf(matcher.group());
            sb.replace(index, index + 2, "");
            matcher.reset();
        }
    }
}
