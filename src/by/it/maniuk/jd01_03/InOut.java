package by.it.maniuk.jd01_03;

public class InOut {

    static double[] getArray(String line){

        line.split(" ");
        String[] strArray = line.trim().split(" ");
        double[] res = new double[strArray.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = Double.parseDouble(strArray[i]);
        }
        return  res;
    }

    static  void  printArray (double[] arr){
        for (double e: arr) {
            System.out.println(e + " ");
        }
        System.out.println();
    }

    static void  printArray(double[] arr, String name, int colCount){
        for (int i = 0; i <arr.length; i++) {
            System.out.printf("%s[% -3d] = %-7.3f ",name,i,arr[i]);
            if ((i+1)%colCount ==0 || i+1 == arr.length)
                System.out.println();
        }
    }
}
