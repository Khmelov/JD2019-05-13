package by.it.orlov.jd01_06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        String text = Poem.text;
        text = text.replace("...","");
        text = text.replaceAll("([^а-яА-ЯЁё\\.!?]+)"," ");
        Matcher matcher = Pattern.compile("([^.!?]+)").matcher(text);
        String[] poem = new String[13];
        int i = 0;
        while(matcher.find()){
            poem[i] = matcher.group().trim();
            i++;
        }
            Arrays.sort(poem, new comp());

        for (String element : poem) {
            System.out.print(element+"\n");
        }
    }
}
class comp implements Comparator<String> {
    public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
    }
}
