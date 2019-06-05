package by.it.dilkevich.jd01_04;

public class InOut {
    /**
     * Метода преобразует сторку в массив Double
     * @param line Входная строка
     * @return Возвращает масси Double
     */

    static double[ ] getArray(String line){

        String tempMas [] = line.trim().split(" ");
        double [] mas = new double[tempMas.length];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = Double.parseDouble(tempMas[i]);
        }
        return mas;
    }

    /**
     * Метод печатает каждый элемент массива в одну строку
     * @param arr входящий массив типа Double
     */
   public static void printArray(double[ ] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    /**
     * Выводит в консоль имя массива и элементы массива заданным количесвом строк
     * @param arr входящий массив типа Double
     * @param name входящее имя массива
     * @param columnCount входящее количество строк
     */
    static void printArray(double[ ] arr, String name, int columnCount){
        System.out.print(name);
        System.out.println();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("V[%-2d]=%-10.3f", i, arr[i]);

            count++;
            if(count%columnCount == 0) {
                System.out.println();
                count = 0;
            }
        }
    }
}
