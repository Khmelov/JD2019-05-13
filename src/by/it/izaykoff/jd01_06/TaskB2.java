package by.it.izaykoff.jd01_06;

public class TaskB2 {
    public static void main(String[] args) {
        String poema = Poem.text;

        poema = poema.replaceAll("[^а-яА-ЯёЁ\\.!]"," ");
        String[] text = poema.split("[\\.!]");
        for (int i = 0; i < text.length; i++) {
            text[i] = text[i].replaceAll("[\\.!]+"," ");
            text[i] = text[i].replaceAll("[ ]{2,}"," ");
            text[i] = text[i].trim();
        }


        for (int i = 0; i < text.length; i++) {
            for (int j = 0; j < text.length; j++) {
                if (text[i].length() < text[j].length()){
                    String buffer = text[i];
                    text[i] = text[j];
                    text[j] = buffer;
                }
            }
        }
        for (String s : text) {
            System.out.println(s);
        }
    }





//    public static void main(String[] args) {
//
//        String text = Poem.text;
//        text = text.replaceAll("[.!?]{2,}"," ");
//        String[]words = text.split("[.!?]");
//        for (int i = 0; i < words.length; i++) {
//            words[i] = words[i].replaceAll("[^а-яА-ЯёЁ ]"," ");
//            words[i] = words[i].replaceAll("[ ]{2,}"," ");
//            words[i] = words[i].trim();
//        }
//        for (int i = 0; i < words.length; i++) {
//            for (int j = 0; j < words.length; j++) {
//                if(words[i].length() < words[j].length()){
//                    String buffer = words[i];
//                    words[i] = words[j];
//                    words[j] = buffer;
//                }
//            }
//        }
//        for (String el : words) {
//            System.out.println(el);
//        }
//    }

}
