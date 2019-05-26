package by.it.yakimovich.jd01_03;


public class InOut {
       public static double[ ] getArray(String line){
           String[] strArray= line.split(" ");
           double [] res=new double[strArray.length];
           for (int i = 0; i < strArray.length; i++) {
               res[i]=Double.parseDouble(strArray[i]);
           }
           return res;
       }


      static void printArray(double[] arr) {
          for (double elem : arr) {
           System.out.println(elem + " ");
          }

      }

    public static void printArray(double[ ] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[%-2s]=%3.2f  ",name,i,arr[i]);
            if (((i+1)%columnCount==0)||(i+1)==arr.length) {
                System.out.println( );
            }

        }

}
   }

