package by.it.yakovets.jd01_06;

public class TaskB2 {
    public static void main(String[] args) {

        String[] strArray = Poem.text.split("[.!?]+");

        for (int i = 0; i < strArray.length; i++) {
            System.out.println(strArray[i]);

        }
    }


}
