package by.it.buymistrov.jd01_05;


import java.util.Arrays;

public class TaskC {
    private static void step1() {


        // массив а

        int t = (int) Math.round((9 - 5.33) / 0.09);
        double[] mas = new double[t];

        System.out.println("Массив A[]");

        int i = 0;
        for (double x = 5.33; x <= 9; x += 0.09) {

            mas[i] = Math.cbrt((x * x) + 4.5);
            System.out.printf("%s[% -3d]=%-15f ", "A", i, mas[i]);
            if ((i + 1) % 5 == 0)
                System.out.println();
            i++;

        }
        System.out.println();
        int j = mas.length;

        // размер нового
        for (double ma : mas) {
            if (ma > 3.5)
                j--;

        }

        //массив В
        double[] masNew = new double[mas.length - j];
        int k = 0;
        for (double ma : mas) {
            if (ma > 3.5) {
                masNew[k] = ma;
                k++;
            }

        }

        double proizv = 1;
        System.out.println();
        System.out.println("Массив B[]");
        for (int i1 = 0; i1 < masNew.length; i1++) {
            proizv = proizv * masNew[i1];
            System.out.printf("%s[% -3d]=%-15f ", "B", i1, masNew[i1]);
            if ((i1 + 1) % 5 == 0)
                System.out.println();
        }


        // среднее геометрическое

        double n = (double) 1 / masNew.length;


        double geom = Math.pow(proizv, n);
        System.out.println();
        System.out.println("Среднее геометрическое массива В = " + geom);


    }


    private static void step2() {
        double[] a = new double[30];

        for (int i = 0; i < a.length; i++) {
            a[i] = Math.round(103 + (Math.random() * 347));
        }


        int j = 0;
        int g = 0;
        System.out.println("╔═══════════════╦═══════════════╦═══════════════╦═══════════════╦═══════════════╗");
        System.out.println("║ Massive А(i)  ║               ║               ║               ║               ║");
        System.out.println("╠═══════════════╬═══════════════╬═══════════════╬═══════════════╬═══════════════╣");

        for (int i = 0; i < a.length; i++) {
            System.out.print("║");
            System.out.printf(" %s[% -3d]=%-4.1f  ", "A", i, a[i]);


            if (((i + 1) % 5 == 0) && (g < 5)) {
                System.out.println("║");
                System.out.println("╠═══════════════╬═══════════════╬═══════════════╬═══════════════╬═══════════════╣");
                g++;
            } else if (((i + 1) % 5 == 0) && (g >= 5)) {
                System.out.println("║");

            }


        }
        System.out.println("╚═══════════════╩═══════════════╩═══════════════╩═══════════════╩═══════════════╝");


        for (int i = 0; i < a.length; i++) {
            if (a[i] * 0.1 > i)
                j++;

        }

        System.out.println();

        int t = 0;
        double[] b = new double[j];

        for (int i = 0; i < a.length; i++) {
            if (a[i] * 0.1 > i) {
                b[t] = a[i];
                t++;
            }

        }

        Arrays.sort(b);

        int h = b.length / 2;
        System.out.println("╔═══════════════╦═══════════════╗");
        System.out.println("║ Massive B(i)  ║               ║");
        for (int i = 0; i < h; i++) {
            System.out.println("╠═══════════════╬═══════════════╣");
            System.out.printf("║ %s[% -3d]=%-4.1f  ║ %s[% -3d]=%-4.1f  ║%n", "B", i, b[i], "B", h + i, b[h + 1]);

        }
        System.out.println("╚═══════════════╩═══════════════╝");


    }


    public static void main(String[] args) {


        step1();
        step2();
    }

}
