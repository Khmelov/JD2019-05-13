
package by.it.zhukova.jd01_04;
public class InOut {
    /**@author — Zhukova Irina;
   *  @version — 1.00;
   *  @param  line - строка чисел для преобразования в массив;
   *  @return res - одномерный массив переменных типа double;
     */
    static double[ ] getArray(String line) {
        String line2 = line.trim();
        String[] strArray = line2.split(" ");
        double [ ] res = new double[strArray.length];
        for (int i = 0; i < res.length; i++) {
          res [i] = Double.parseDouble(strArray[i]);

        }
    return res;
    }
    /**@author — Zhukova Irina;
     *  @version — 1.00;
     *  @param  arr - одномерный массив переменных типа double;
     */
    static void printArray(double[ ] arr){
               for (double v : arr) {
        System.out.print (v + " ");
       }
        System.out.println();
    }
    /**@author — Zhukova Irina;
     *  @version — 1.00;
     *  @param  arr - одномерный массив переменных типа double;
     * @param cols - число столбцов для вывода массива;
     * @param name - имя выводимого массива;
     */
    static void printArray(double[ ] arr, String name, int cols){
        int col = 0;
        for (int i = 0; i < arr.length; i++) {

            System.out.printf("%s[% -3d]=%-7.2f ", name, i ,arr[i]);
            col++;
            if ((col%cols==0) || (i== arr.length-1))
                System.out.println();
        }
    }


}
