package by.it.akhmelev.jd01_02;

public class TaskB {
    public static void main(String[] args) {
        step1();
    }

    private static void step1() {
        for (int i = 1; i <= 25; i++) {
            System.out.print(i+" ");
            if (i%5==0)
                System.out.println();
        }
    }
}
