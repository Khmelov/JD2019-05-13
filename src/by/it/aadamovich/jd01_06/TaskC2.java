package by.it.aadamovich.jd01_06;

public class TaskC2 {
    public static void main(String[] args) {

        long startSlow = System.nanoTime();
        System.out.println(slow(Poem.text));
        long finishSlow = (System.nanoTime() - startSlow) / 1000000;
        System.out.println("Время работы метода slow: " + finishSlow);

        long startFast = System.nanoTime();
        System.out.println(fast(Poem.text));
        long finishFast = (System.nanoTime() - startFast) / 1000000;
        System.out.println("Время работы метода fast: " + finishFast);
    }

    private static String slow(String text) {

        String[] words = text.split("[^а-яА-ЯёЁ]+");
        String string = "";

        do {
            for (String word : words) {
                string = string.concat(word).concat(" ");
            }
        } while (string.length() < 100000);
        return string;
    }

    private static String fast(String text) {

        String[] words = text.split("[^а-яА-ЯёЁ]+");
        StringBuilder sc = new StringBuilder();

        do {
            for (String word : words) {
                sc.append(word).append(" ");
            }
        } while (sc.length() < 100000);
        return sc.toString();
    }
}
