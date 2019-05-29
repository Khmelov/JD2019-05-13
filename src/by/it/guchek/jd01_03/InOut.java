package by.it.guchek.jd01_03;

public class InOut {

    public static double [] getArray(String line) {  //Метод будет возвращать массив т.к. статический. На вход - строка line
                                              //line.trim() удаляет пробельные симоволы
                                              //line.split(" ") Метод возвращает из строки массив из символов,
                                              // разделенных пробелам. т.е. каждый кусок до пробела

        String[] strArr = line.trim().split(" ");
        double[] res = new double[strArr.length]; // определили массив размером (длинной) нашего массива строк
                                                  // Перебираем массив и заполняем его фактическими значениями
        for (int i = 0; i < strArr.length; i++) {
            res[i] = Double.parseDouble(strArr[i]);
        }
        return res;
    }

    static void printArray(double[] arr){    //Метод значение не возващает, т.к. он void
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+" ");

        }
        System.out.println();
    }

    public static void printArray(double[ ] arr, String name, int columnCount){

        for (int i = 0; i < arr.length; i++) {
            //V[1]=12.1234
            System.out.printf("%s[% -3d]=%-7.4f ", name, i, arr[i]);
            if ((i+1)%columnCount==0 || (i+1)==arr.length)
            System.out.println();

        }
    }
}
