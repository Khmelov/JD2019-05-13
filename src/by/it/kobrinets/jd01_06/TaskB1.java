package by.it.kobrinets.jd01_06;

public class TaskB1 {

    public static void main(String[] args) {
        String text = (Poem.text);
        check(text);
    }

    private static void check(String text) {
        String[] array = text.split("[ \\-.,:!\n]");
        for (String s : array) {
            if (s.length() > 1) {
                if (((s.startsWith("б")) || (s.startsWith("Б")) ||
                        (s.startsWith("в")) || (s.startsWith("В")) ||
                        (s.startsWith("г")) || (s.startsWith("Г")) ||
                        (s.startsWith("д")) || (s.startsWith("Д")) ||
                        (s.startsWith("ж")) || (s.startsWith("Ж")) ||
                        (s.startsWith("з")) || (s.startsWith("З")) ||
                        (s.startsWith("й")) || (s.startsWith("Й")) ||
                        (s.startsWith("к")) || (s.startsWith("К")) ||
                        (s.startsWith("л")) || (s.startsWith("Л")) ||
                        (s.startsWith("м")) || (s.startsWith("М")) ||
                        (s.startsWith("н")) || (s.startsWith("Н")) ||
                        (s.startsWith("п")) || (s.startsWith("П")) ||
                        (s.startsWith("р")) || (s.startsWith("Р")) ||
                        (s.startsWith("с")) || (s.startsWith("С")) ||
                        (s.startsWith("т")) || (s.startsWith("Т")) ||
                        (s.startsWith("ф")) || (s.startsWith("Ф")) ||
                        (s.startsWith("х")) || (s.startsWith("Х")) ||
                        (s.startsWith("ц")) || (s.startsWith("Ц")) ||
                        (s.startsWith("ч")) || (s.startsWith("Ч")) ||
                        (s.startsWith("ш")) || (s.startsWith("Ш")) ||
                        (s.startsWith("щ")) || (s.startsWith("Щ")))
                        & ((s.endsWith("у")) ||
                        (s.endsWith("е")) ||
                        (s.endsWith("а")) ||
                        (s.endsWith("ы")) ||
                        (s.endsWith("о")) ||
                        (s.endsWith("э")) ||
                        (s.endsWith("я")) ||
                        (s.endsWith("и")) ||
                        (s.endsWith("ю")) ||
                        (s.endsWith("ё"))))
                    System.out.println(s);
            }
        }
    }
}


