package by.it.orlov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {

        String t = Poem.text;
        String[] str = t.split("\\n");
        int o = str[0].length();
        for (int i = 1; i < str.length; i++) {
            if(str[i].length() > o) {
                o = str[i].length();
            }
        }
        System.out.println(checker(o, str));

    }
    private static StringBuilder checker(int o, String[] str){
        Pattern target = Pattern.compile("[^\\s][ ]+[^\\s]");
        StringBuilder chen = new StringBuilder();
        StringBuilder sub = new StringBuilder();

        for (String s : str) {
            chen.append(s.trim());
            Matcher match = target.matcher(chen);

            while (chen.length() < o) {
                int beg = 0;
                while (match.find(beg)) {
                    if (chen.length() == o) {
                        break;
                    }
                    String gr = match.group();
                    int spot = match.start();
                    chen.insert(spot + 1, gr.charAt(1));
                    beg = match.end();
                }

            }
            sub.append(chen);
            sub.append("\n");
            chen.delete(0, chen.length());
        }
        return sub;
    }
}
