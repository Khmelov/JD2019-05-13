package by.it.yakimovich.jd01_06;


import java.util.Arrays;
import java.util.Comparator;


public class TaskB2 {
    public static void main(String[] args) {
    String poem=Poem.text;
    Comparator<String> stringLengthComparator = new StringLengthSort();
    poem=poem.replaceAll("\\.{3}"," ");
    String[] sentences=poem.split("[\\.!]");
            for (int i = 0; i <sentences.length ; i++) {
            sentences[i]=sentences[i].replaceAll("[\\,\\.\\-!\\n:]"," ");
            sentences[i]=sentences[i].trim();
            sentences[i]=sentences[i].replaceAll("( )+", " ");
            }

        Arrays.sort(sentences, stringLengthComparator);
        for(String str : sentences){
            System.out.print(str+"\n");
        }

        }
    static class StringLengthSort implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if(o1.length() > o2.length()){
                return 1;
            }else{
                if(o1.length() < o2.length()){
                    return -1;
                }else{
                    return 0;
                }
            }
        }
    }

}
