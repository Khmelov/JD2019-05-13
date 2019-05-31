package by.it.maniuk.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class taskB2 {


    public static void main(String[] args) {

        split(Poem.text);

    }


    public static void split(String text) {

        String textGenerate;
        String string;
        Pattern compl = Pattern.compile("[^а-яА-ЯёЁ.]+");
        Matcher matcher = compl.matcher(text);
        Pattern compl2 = Pattern.compile("[- ,\\n]+");
        Matcher matcher2 = compl2.matcher(text);
        string = matcher2.replaceAll(" ");
        string = string.trim();
        String[] strArrayF = string.trim().split("\\.");
        int[] array = new int[strArrayF.length];
        for (int i = 0; i <strArrayF.length ; i++)
            array[i] = i;

        textGenerate = matcher.replaceAll(" ");
        textGenerate = textGenerate.trim();

        String[] strArray = textGenerate.trim().split("\\.");

       // for (int i = 0; i < strArray.length; i++) {
            for (int q = 0; q < strArray.length; q++) {
                for (int j = 0; j < strArray.length - 1 - q; j++) {
                    if (strArray[j].length() > strArray[j + 1].length()) {
                        String str = strArray[j];
                        strArray[j] = strArray[j + 1];
                        strArray[j + 1] = str;
                        int ind = array[j];
                        array[j] = array[j+1];
                        array[j+1] = ind;
                        }
                    }
                }
        for (int i = 2; i < strArrayF.length; i++) {
            if (strArray[i].length()!=strArrayF[i].length()){
            String s = strArrayF[array[i]];
            System.out.println(s.trim());}


        }


    }
}
