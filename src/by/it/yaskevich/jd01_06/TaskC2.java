package by.it.yaskevich.jd01_06;

public class TaskC2 {
    private static final int MAX_LENGTH_TEXT = 100_000;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String slowText = slow(Poem.text);
        long time = (System.nanoTime() - startTime) / 1000000;
        System.out.printf("Time=%d Text=%s...\n", time, slowText.substring(0, 24));

        startTime = System.nanoTime();
        String fastText = fast(Poem.text);
        time = (System.nanoTime() - startTime) / 1000000;
        System.out.printf("Time=%d Text=%s...\n", time, fastText.substring(0, 24));

    }

    private static String slow(String text) {
        String result = "";
        String[] words = text.split("[^а-яА-ЯёЁ]+");

        infinity: while (true) {
            for (String word : words) {
                result = result + (word + " ");
                if (result.length() > MAX_LENGTH_TEXT)
                    break infinity;
            }
        }

        return result;
    }

    private static String fast(String text) {
        StringBuilder result = new StringBuilder();
        String[] words = text.split("[^а-яА-ЯёЁ]+");

        infinity: while (true) {
            for (String word : words) {
                result.append(word).append(" ");
                if (result.length() > MAX_LENGTH_TEXT)
                    break infinity;
            }
        }

        return result.toString();
    }
}
