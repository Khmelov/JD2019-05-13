package by.it.dilkevich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        printTextAscending(Poem.text);
    }
    private static void printTextAscending(String text) {
        text = text.replace("\n", " ");
        text = text.replace("...", ".");

        StringBuilder sb = new StringBuilder(text);
        Pattern pattern1 = Pattern.compile("[!,\\-+=:]");
        Matcher matcher1 = pattern1.matcher(sb);
        while (matcher1.find()){
            int start = matcher1.start();
            int end = matcher1.end();

            sb.replace(start,end, " ");
        }

        String result = sb.toString();
        result = result.replace("   ", " ");
        result = result.replace("  ", " ");
        String [] masText = result.split("\\.\\p{Blank}");
         masText = masSort(masText);
        sb.delete(0, sb.length());
        masText[11] = masText[11].replace(".", "");
        for (int i = 0; i < masText.length; i++) {
            if (i != 4){
                masText[i] = masText[i].trim();
                sb.append(masText[i]).append("\n");
            }
        }
        sb.append(masText[4]);
        String result2 = sb.toString();
        System.out.println(result2);

    }

    private static String[] masSort(String[] masText) {

        boolean swap = false;
        int lastItem = masText.length - 1;
        do {
            swap = false;
            for (int i = 0; i < lastItem; i++) {
                if (masText[i].length() > masText[i + 1].length()) {
                    String temp = masText[i];
                    masText[i] = masText[i + 1];
                    masText[i + 1] = temp;
                    swap = true;

                }
            }
        }
        while (swap == true);

    return masText;
    }
}
