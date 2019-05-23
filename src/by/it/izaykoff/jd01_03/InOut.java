package by.it.izaykoff.jd01_03;

/**
 * @author izakoff
 */
 public class InOut {
     /**
      *  @param line входные параметры
      */
   public static  double [] getArray (String line){

        String[] strArray = line.split(" ");
        double[] array = new double[strArray.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Double.parseDouble(strArray[i]);

        }

        return array;
    }
    /**
     *  @param array входной массив
     */
   public static void printArray(double[] array){
        for (double e : array) {
            System.out.print(e + " ");

        }
        System.out.println();
    }
    /**
     *  @param array входной двойной массив
     */
   public static void printArray(double[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
         System.out.println();
        }
    }
     /**
      *  @param array входной массив
      *  @param name имя на экране
      *  @param colCount число столбцов
      */
   public static void printArray(double[] array,String name, int colCount){
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-7.3f ",name, i, array[i] );
            if((i + 1) % colCount == 0){
                System.out.println();
            }
        }
        System.out.println();
    }
}
