package by.it.kobrinets.jd01_06;

public class TaskB2 {
    public static void main(String[] args) {

        String text = (Poem.text).replaceAll("\\.{3}", " ");
        String[] array = text.split("[.?^]+");
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i].trim();
            array[i] = array[i].replaceAll("[,-;!:\n]", " ");
            array[i] = array[i].replaceAll(" {2,}", " ");
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].length() < (array[i].length())) {
                    String temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        for (String s : array) {
            System.out.println(s);
        }
    }


}
