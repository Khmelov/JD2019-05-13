package by.it.dnevar.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern compile = Pattern.compile("[а-яёА-ЯЁ]{2,}");
        Matcher matcher = compile.matcher(text);
        while(matcher.find()){
            String word = matcher.group();
            check(word);
        }
    }

    private static void check(String word) {
        char [] gl = {'а','е','ё','и','о','у','ы','э','ю','я'};
        char [] sogl = {'б','в','г','д','ж','з','к','л','м','н','п','р','с','т','ф','х','ц','ч','ш','щ',
                'Б','В','Г','Д','Ж','З','К','Л','М','Н','П','Р','С','Т','Ф','Х','Ц','Ч','Ш','Щ'};
        char first = word.charAt(0);
        char last = word.charAt(word.length()-1);
        for (char c : sogl) {
            if(c==first){
                for (char c1 : gl) {
                    if(c1==last){
                        System.out.println(word);
                    }
                }
            }
        }
    }
}
