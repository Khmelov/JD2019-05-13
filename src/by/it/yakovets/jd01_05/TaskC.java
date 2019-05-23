package by.it.yakovets.jd01_05;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step7();
    }


    static void step7() {
        double l = (9 - 5.33) / 25;
        int i = 0;
        double[] mas = new double[25];
        for (double x = 5.33; x <= 9; x += l) {
            mas[i] = cbrt(pow(x, 2) + 4.5);
            i++;
        }
        int sr = 0;
        System.out.println("Массив A[]");
        for (int i1 = 0; i1 < mas.length; i1++) {
            if (mas[i1] > 3.5) {
                sr++;
            }
            System.out.printf("%s[% 3d]=%6.5f ", "A", i1, mas[i1]);
            if ((i1 + 1) % 5 == 0 || i1 == mas.length - 1) {
                System.out.println();
            }
        }
        double[] masb = new double[sr];
        int bb = 0;
        for (int i1 = 0; i1 < mas.length; i1++) {
            if (mas[i1] > 3.5) {
                masb[bb] = mas[i1];
                bb++;
            }
        }
        System.out.println("Массив B[] из элементов массива А>3.5");
        double sumb = 0;
        for (int i1 = 0; i1 < masb.length; i1++) {
            sumb = sumb + masb[i1];
            System.out.printf("%s[% 3d]=%6.5f ", "B", i1, masb[i1]);
            if ((i1 + 1) % 5 == 0 || i1 == masb.length - 1) {
                System.out.println();
            }
        }
        double n = masb.length;

        double srGeo = pow(sumb, (1 / n));
        System.out.println(srGeo);
    }
}

