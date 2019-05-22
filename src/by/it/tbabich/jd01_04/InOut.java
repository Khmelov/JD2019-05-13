package by.it.tbabich.jd01_04;


public class InOut {

    /**
     * Получение массива double из строки символов
     * @param line Строка символов, разделенных пробелом
     */
    static double[] getArray(String line) {
        line = line.trim();
        String[] arrayString = line.split(" ");
        double[] outArray = new double[arrayString.length];
        for (int i = 0; i < arrayString.length; i++) {
            outArray[i] = Double.parseDouble(arrayString[i]);
        }
        return outArray;
    }

    /**
     * Вывод на экран элементов массива
     * @param arr Одномерный массив
     * */
    static void printArray(double[] arr) {
        for (double e : arr
        ) {
            System.out.print(e + " ");
        }
    }

    /**
     * Форматированный вывод на экран элементов массива
     * @param arr Одномерный массив
     * @param name Имя массива для вывода на печать
     * @param columnCount Количество элементов массива в одной строке при выводе
     * */
    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-5.15f ", name, i, arr[i]);
            if ((i + 1) % columnCount == 0) System.out.println();
        }
    }
}
