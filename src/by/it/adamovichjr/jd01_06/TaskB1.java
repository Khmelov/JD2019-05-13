package by.it.adamovichjr.jd01_06;

public class TaskB1 {

    public static void main(String[] args) {
        String text = Poem.text;
        text = text.replaceAll("[^а-яА-ЯёЁ ]", " ");
        String[] words = text.split("[ ]+");
        test(words);

    }

    private static void test(String[]mas){
        String soglasn = "у е ы а о э я и ю ё У Е Ы А О Э Я И Ю Ё";
        for (int i = 0; i < mas.length; i++) {

            String first = String.valueOf(mas[i].charAt(0));
            String last = String.valueOf(mas[i].charAt(mas[i].length() - 1));
            if (soglasn.contains(first) != true && soglasn.contains(last))
                System.out.println(mas[i]);
        }
    }
}
