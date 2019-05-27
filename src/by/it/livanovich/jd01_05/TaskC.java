package by.it.livanovich.jd01_05;

public class TaskC {
    public static void main(String[] args) {
        createMas ();


    }

    public static void createMas() {
        double x;
        double z;
        double [] a=new double [25];
        for (x=5.33; x<=9; x=x+0.3){
           z=Math.cbrt(x*x+4.5);

            }
        }

    static void printMas(double[ ] a, String name, int columnCount){
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%s[% -3d]=%-7.4f ",name,i,a[i]);
            if ((i+1)%columnCount==0 || i+1==a.length)
                System.out.println();
        }
    }
}
