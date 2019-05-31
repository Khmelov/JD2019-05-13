package by.it.dnevar.jd01_06;

import java.time.Duration;
import java.time.Instant;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {
    public static void main(String[] args) {
        String text = Poem.text;

        Instant start1 = Instant.now();
        slow(text);
        Instant end1 = Instant.now();
        System.out.println("Total time: " + Duration.between(start1,end1));

        Instant start2 = Instant.now();
        fast(text);
        Instant end2 = Instant.now();
        System.out.println("Total time: " + Duration.between(start2,end2));


    }

    private static String slow (String text){
        String buffer = "";
        String[] arrBuff = text.split("[^а-яА-ЯёЁ]+");
        int j = 0;
        while (buffer.length()<100000) {
            if(j == arrBuff.length-1){
                buffer=buffer.concat(arrBuff[j]).concat(" ");
                j=0;
            }else{
                buffer=buffer.concat(arrBuff[j]).concat(" ");
                j++;
            }
        }
        System.out.println("String size: "+ buffer.length());
        return buffer;
    }

    private static String fast (String text){
        StringBuilder buffer = new StringBuilder("");
        Pattern compile = Pattern.compile("[а-яёА-ЯЁ]+");
        Matcher matcher = compile.matcher(text);

        while (buffer.length() < 100000) {
            int start = 0;
            while (matcher.find(start)){
                if(buffer.length()>100000){
                    break;
                }
                buffer.append(matcher.group());
                buffer.append(" ");
                start = matcher.end();
            }
        }
        System.out.println("String size: "+ buffer.length());
        String newText = buffer.toString();
        return newText;
    }
}
