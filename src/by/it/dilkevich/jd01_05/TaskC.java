package by.it.dilkevich.jd01_05;

public class TaskC {

    public static void main(String[] args) {
        double[] mas = new double[27];
        int count = 1;
        System.out.println("A");
        for (double x = 5.33; x < 9; x = x + 0.1) {
            if(count == 28)
                break;
            else {
                if (count%6 == 0)
                    System.out.println();
                    mas[count-1] = Math.cbrt(x * x + 4.5);
                    count++;
                System.out.printf("A[ %-2d ] = %5.5f    ", count-1, mas[count-2]);

            }

        }
    }
}

