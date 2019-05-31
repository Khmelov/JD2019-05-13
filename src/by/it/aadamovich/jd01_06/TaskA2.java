package by.it.aadamovich.jd01_06;

public class TaskA2 {
    public static void main(String[] args) {

        String[] words = Poem.text.trim().split("[^а-яА-ЯёЁ]+");
        for (String word : words) {
            if (word.equals("empty")) {
                continue;
            }
            int count = 0;
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word)) {
                    count++;
                    words[i] = "empty";
                }
            }
            System.out.printf("%s=%d%n", word, count);
        }
    }
}
