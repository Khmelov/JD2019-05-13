package by.it.lasotskaya.jd01_06;



public class TaskB2 {
    public static void main(String[] args) {
        String[] a = Poem.text.split("[.]\\n");
      splitAndSortText(a);

    }
    private static void splitAndSortText(String[] a) {
        int i;
        for (i = 0; i < a.length; i++) {
            a[i] = a[i].replaceAll("[^А-Яа-яЁё]+", " ");
            a[i] = a[i].trim();

        }
        boolean swap;
        int last = a.length - 1;
        do {
            swap = false;
            for (i = 0; i < last; i++) {
                if (a[i].length() > a[i + 1].length()) {
                    String temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swap = true;
                }
            }
            last--;
        } while (swap);
        for (String s : a) {
            System.out.print(s + "\n");
            }

        }}














