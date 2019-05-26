package by.it.guchek.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯЁё[^\\n]]+");
        Matcher matcher = pattern.matcher(Poem.text);
        int [] lengStr = {};
        int i=0;
        while (matcher.find ())
        {
            String str = matcher.group();
            System.out.println(str);
            lengStr[i]=str.length();
            i++;
        }
        Arrays.sort(lengStr);
        int max=lengStr[lengStr.length-1];
        int min=lengStr[0];
    }
}