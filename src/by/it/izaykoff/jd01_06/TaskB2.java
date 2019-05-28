package by.it.izaykoff.jd01_06;

public class TaskB2 {
    public static void main(String[] args) {
        String poema = Poem.text;

        poema = poema.replaceAll("[^а-яА-ЯёЁ.!]"," ");
        poema = poema.replaceAll("[.]{2,}"," ");

        String[] text = poema.split("[.!]");
        for (int i = 0; i < text.length; i++) {
            text[i] = text[i].replaceAll("[.!]+"," ");
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

}
