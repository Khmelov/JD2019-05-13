package by.it.trudnitski.jd01_06;

public class TaskB2 {
    public static void main(String[] args) {
        

        StringBuilder sb= new StringBuilder(Poem.text);
        String text=sb.toString();
        text = text.replaceAll("[.!?]{2,}"," ");
        String[]text1=text.split("[.?!]");
        for (int i = 0; i < text1.length; i++) {
            text1[i]=text1[i].replaceAll("[^а-яА-ЯёЁ]"," ");
            text1[i]=text1[i].replaceAll("[ ]{2,}", " ");
            text1[i]=text1[i].trim();
        }


        for (int i = 0; i < text1.length; i++) {
            for (int j = 0; j <text1.length ; j++) {
                if(text1[i].length() < text1[j].length()){
                    String res = text1[i];
                    text1[i] = text1[j];
                    text1[j] = res;
                }
            }
        }

        for (String element : text1) {
            System.out.println(element);
        }
        

    }


}
