package by.it.buymistrov.jd01_05;


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

        double n = (double  ) 1/masNew.length;


        double geom = Math.pow(proizv, n );
        System.out.println();
        System.out.println("Среднее геометрическое массива В = " + geom);


    }


    public static void main(String[] args) {


        step1();
    }

}
