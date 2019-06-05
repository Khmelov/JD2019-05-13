package by.it.lasotskaya.jd01_03;

 class InOut {
    /** Method getArray(line) is to get the array from the line,
     * mas one-dimensional array
     * @return double mas.
     */
    static  double[] getArray(String line){
      String [] stringMas = line.split(" ");
      double []mas = new double[stringMas.length];
      for (int i = 0; i<stringMas.length; i++ ){
          mas[i]=Double.parseDouble(stringMas[i]);
      }
      return mas;
    }
    /** Method printArray(arr) is to print the array as is,
     * @param arr is one-dimensional array has type double
     */
    static  void printArray(double[]arr){

        for (double el:arr){
            System.out.print(el + " ");
        }
        System.out.println();
    }
    /**
     * Method printArray (double[]arr, String name, int columnCount) to print array using printf,
     *
     * arr is one-dimensional array,
     */
    static  void printArray(double[]arr, String name, int columnCount){
        int column=0;
        for (int i = 0; i <arr.length ; i++) {
            System.out.printf("%s[% -3d] = %-4.1f", name,i, arr[i]);
            column++;
        }
if (0==column%columnCount){
    System.out.println();
}
        }
    }

