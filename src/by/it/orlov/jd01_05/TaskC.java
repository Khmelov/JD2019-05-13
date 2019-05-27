package by.it.orlov.jd01_05;

public class TaskC {
    public static void main(String[] args) {
        task1();
    }
    static public void task1(){
        double[] mas = new double[20+(int)(Math.random()*20)];
        int i = 0, new_mas = 0;

        for (double x = 5.33; x <= 9.0; x+=(9-5.33)/mas.length) {
            if(i == mas.length-1){
                mas[i] = Math.cbrt(Math.pow(x,2)+4.5);
                new_mas++;
                break;
            }
            mas[i] = Math.cbrt(Math.pow(x,2)+4.5);
            if (mas[i]>3.5){
                new_mas++;
            }
            i++;
        }
        for (int s = 0; s<mas.length; s++) {
            if((s+1)%5==0&&s!=0){
                System.out.printf("B[%3d] = %10.8f\n",s,mas[s]);
                continue;
            }
            System.out.printf("B[%3d] = %10.8f",s,mas[s]);
        }
        double[] n = new double[new_mas];
        i = 0;
        for (int j = 0; j < n.length; j++) {
            for (int k = 0; k < mas.length; k++) {
                if(mas[k]>3.5){
                    n[j]=mas[k];
                    j++;
                    i++;
                    continue;
                }
            }
        }
        double avg = 1;
        for ( int f = 0; f < i; f++) {
            avg*=n[f];
        }
        avg = Math.pow(avg, 1.0/i);
        System.out.println("\n------------------------------------------------------------");
        for (int s = 0; s<n.length; s++) {
            if((s+1)%5==0&&s!=0){
                System.out.printf("A[%3d] = %8.10f\n",s,n[s]);
                continue;
            }
            System.out.printf("B[%3d] = %10.8f",s,n[s]);
        }
        System.out.println("\n" + avg);

    }

}
