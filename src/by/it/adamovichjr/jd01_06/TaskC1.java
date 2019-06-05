package by.it.adamovichjr.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {

        String text = Poem.text;
        String[] line = text.split("\\n");
        int maxLine = line[0].length();
        for (int i = 1; i < line.length; i++) {
            if(line[i].length() > maxLine) {
                maxLine = line[i].length();
            }
        }
        StringBuilder finaly = bildText(line,maxLine);
        System.out.println(finaly);

    }
    private static StringBuilder bildText(String[]mas,int maxLineLenght){
        StringBuilder words = new StringBuilder();
        StringBuilder buffer = new StringBuilder();
        Pattern space = Pattern.compile("[^\\s][ ]+[^\\s]");

        for (int i = 0; i < mas.length; i++) {
            mas[i] = mas[i].trim();
            buffer.append(mas[i]);
            Matcher m = space.matcher(buffer);

            while (buffer.length() < maxLineLenght){
                int start = 0;
                while (m.find(start)){
                    if(buffer.length() == maxLineLenght){break;}
                    String s = m.group();
                    int find = m.start();
                    buffer.insert(find+1,s.charAt(1));
                    start = m.end();
                }

            }
            words.append(buffer);
            words.append("\n");
            buffer.delete(0,buffer.length());
        }
        return words;
    }
}
