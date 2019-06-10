package by.it.adamovichjr.jd01_06;


public class TaskB2 {

    public static void main(String[] args) {

        String text = Poem.text;
        text = text.replaceAll("[.!?]{2,}"," ");
        String[]words = text.split("[.!?]");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[^а-яА-ЯёЁ ]"," ");
            words[i] = words[i].replaceAll("[ ]{2,}"," ");
            words[i] = words[i].trim();
        }
        for (int i = 0; i < words.length-1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if(words[i].length() > words[j].length()){
                    String buffer = words[i];
                    words[i] = words[j];
                    words[j] = buffer;
                }
            }
        }
        for (String el : words) {
            System.out.println(el);
        }
    }
}
