package by.it.dilkevich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        printTextAlign(Poem.text);
    }

    private static void printTextAlign(String text) {
        StringBuilder sb = new StringBuilder(text);
        Pattern pattern = Pattern.compile("[А-ЯЁ].+");
        Matcher matcher = pattern.matcher(sb);
        Matcher matcher1 = pattern.matcher(sb);
        StringBuilder s = new StringBuilder("");

        int maxLenght = 0;
        int tabCount = 0;
        int neededTabCount = 0;
        int start = 0;
        int middle =0;
        int end =0;

        while (matcher.find()){
            if(matcher.group().length() > maxLenght)
               maxLenght = matcher.group().length();
        }
        while (matcher1.find()){
            Pattern pattern2 = Pattern.compile(" ");
            Matcher matcher2 = pattern2.matcher(matcher1.group());
            while (matcher2.find()){
                ++tabCount;
            }
            Matcher matcher3 = pattern2.matcher(matcher1.group());
            neededTabCount = maxLenght  - matcher1.group().length();
            if(tabCount > neededTabCount){
                middle = 1;
                while (matcher3.find() && maxLenght != (tabCount+matcher1.group().length())){
                    sb = sb.insert(matcher3.end(), " ");
                    tabCount++;
                }
            }
            if(tabCount < neededTabCount && neededTabCount%tabCount == 0){
                int temp = neededTabCount / tabCount;
                while (matcher3.find() && maxLenght != (tabCount+matcher1.group().length())){
                    for (int i = 0; i < temp; i++) {
                        sb = sb.insert(matcher3.end(), " ");
                        tabCount++;
                    }
                }
            }
            if(tabCount < neededTabCount && neededTabCount%tabCount != 0){
                int temp = (neededTabCount-1) / tabCount;
                int tempP = temp + 1;
                while (matcher3.find() && maxLenght != (tabCount+matcher1.group().length())){
                    if(tempP !=0){
                    for (int i = 0; i < tempP; i++) {
                        sb = sb.insert(matcher3.end(), "  ");
                        tempP--;
                    }
                    }
                    if(tempP == 0){
                    for (int i = 0; i < temp; i++) {
                        sb = sb.insert(matcher3.end(), "  ");
                        tabCount++;
                    }
                    }
                }
            }


            tabCount = 0;
            neededTabCount = 0;
        }
        System.out.println(sb);
    }


}
