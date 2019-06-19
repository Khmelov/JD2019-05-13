package by.it.trudnitski.jd01_06;

import java.util.StringTokenizer;

public class TaskB1 {
    public static void main(String[] args) {
        String res=null;

        String text=new String(Poem.text).trim();
        String del="УуЕеЫыАаОоЭэЯяИиЮю";
        StringTokenizer str = new StringTokenizer(text," -,.:!?\n");

        while(str.hasMoreTokens()){

            String text1=str.nextToken();
            String[]text2=Tokenizer.poem(text1);
            for (String element : text2) {
                if(element.endsWith("Ё")|element.endsWith("ё")|element.endsWith("У")|element.endsWith("у")
                        ||element.endsWith("е")||element.endsWith("ы")||element.endsWith("а")||element.endsWith("о")||
                        element.endsWith("э")||element.endsWith("я")||element.endsWith("и")||element.endsWith("ю")){
                    if (element.startsWith("ч")||element.startsWith("Ч")||element.startsWith("с")|element.startsWith("С")||
                            element.startsWith("м")||element.startsWith("М")||element.startsWith("т")||
                            element.startsWith("Т")||element.startsWith("б")||element.startsWith("Б")||
                            element.startsWith("ф")||element.startsWith("Ф")||element.startsWith("в")||
                            element.startsWith("В")||element.startsWith("п")||element.startsWith("П")||
                            element.startsWith("р")||element.startsWith("Р")||element.startsWith("л")||
                            element.startsWith("Л")||element.startsWith("д")||element.startsWith("Д")||
                            element.startsWith("ж")||element.startsWith("Ж")||element.startsWith("х")||
                            element.startsWith("Х")||element.startsWith("з")||element.startsWith("З")||
                            element.startsWith("щ")||element.startsWith("Щ")||element.startsWith("ш")||
                            element.startsWith("Ш")||element.startsWith("г")||element.startsWith("Г")||
                            element.startsWith("н")||element.startsWith("Н")||element.startsWith("к")||
                            element.startsWith("К")||element.startsWith("ц")||element.startsWith("Ц")||
                            element.startsWith("й")||element.startsWith("Й")){
                        res=element;
                    }
                }
            }
            System.out.println(res);

        }
    }
    public static String[] poem(String s){
        String[]arr = new String[s.length()];
        for (int i = 0; i <s.length() ; i++) {
            arr[i]=s.trim();
        }
        return arr;
    }
}