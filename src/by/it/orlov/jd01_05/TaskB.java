package by.it.orlov.jd01_05;

public class TaskB {
    public static void main(String[] args) {
        task1();
        task2();
    }
    public static void task1() {
        float sum = 0;
        for (float a = 0; a <= 2; a += 0.2) {
            for (int x = 0; x <=6; x++) {
                sum += Math.pow(7, a) - Math.cos(x);
            }
            System.out.printf("При a=%3.2f Сумма y = %-12.5e\n", a, sum);
            sum = 0;
        }
    }

    public static void task2(){
        float a = 0;
        double beta = 0;
        for(double x = -5.5; x < 2; x+=0.5){
            if((x/2 > -2) && (x/2 <= (-1))) {
                beta = Math.sin(Math.pow(x,2));
                a += Math.log10(Math.abs(beta+2.74));
                print(x, a);
            } else if((x/2 > -1) && (x/2 < 0.2)){
                beta = Math.cos(Math.pow(x,2));
                a += Math.log10(Math.abs(beta+2.74));
                print(x, a);
            } else if(x/2 == 0.2) {
                beta = 1/Math.tan(Math.pow(x,2));
                a += Math.log10(Math.abs(beta+2.74));
                print(x, a);
            }else{
                System.out.printf("При x/2=%f вычисления не определены\n", x/2);
            }

        }


    }

    public static void print(double x, double a ){
        System.out.printf("При x/2=%3.2f a =%f\n", x/2,a);
    }
}

