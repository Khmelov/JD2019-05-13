package by.it.aadamovich.jd01_06;

public class TaskB2 {
    public static void main(String[] args) {

        String[] sentences = Poem.text.replaceAll("[.]{2,}", " ").split("[?!.]");

        for (int i = 0; i < sentences.length; i++) {

            sentences[i] = sentences[i].replaceAll("[^а-яА-ЯёЁ]+", " ").trim();

        }

        for (int i = 0; i < sentences.length - 1; i++) {
            for (int j = i + 1; j < sentences.length; j++) {
                if (sentences[i].length() > sentences[j].length()) {
                    String buffer = sentences[i];
                    sentences[i] = sentences[j];
                    sentences[j] = buffer;
                }
            }
        }

        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }
}


