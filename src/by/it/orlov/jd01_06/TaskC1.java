package by.it.orlov.jd01_06;

public class TaskC1 {
    public static void main(String[] args) {
        String t = Poem.text;
        String[] rows = t.split("\\n");
        int o = 0;
        for (int i = 0; i < rows.length; i++) {
            String[] word = rows[i].split(" ");
            int spaces = rows[i].length() - rows[i].replace(" ", "").length();
            int s = 36-rows[i].length();
            for (int i1 = 0; i1 < word.length; i1++) {
                System.out.print(word[i]);

            }

        }
    }
}
