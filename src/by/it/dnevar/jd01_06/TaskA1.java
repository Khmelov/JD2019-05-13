package by.it.dnevar.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern compile = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher matcher = compile.matcher(text);
        while (matcher.find()){
            int pos = matcher.start();
            text.setCharAt(pos+3,'#');
            int length = matcher.end()-matcher.start();
            if(length>=7){
                text.setCharAt(pos+6,'#');
            }
        }
        System.out.println(text);
    }
}
