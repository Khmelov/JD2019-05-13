package by.it.zhukova.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern p2 = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher m2 = p2.matcher(text);
while (m2.find()){
    int pos = m2.start();
    text.setCharAt(pos+3, '#');
    int len = m2.end()-m2.start(); // вычисляем длину слова
    if (len >= 7) text.setCharAt(pos+6, '#');//для слов длиной от 7 букв
}
        System.out.println(text);
    }
}
