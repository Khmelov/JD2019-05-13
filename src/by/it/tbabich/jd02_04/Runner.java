package by.it.tbabich.jd02_04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\([^()]*\\)");
        Matcher matcher = pattern.matcher("D=((C-0.15)-20)/(7-5)");
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
