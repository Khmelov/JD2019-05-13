package by.it.voitehovich.jd01_03;
import java.util.Scanner;
public class InOut {
    static Scanner sc=new Scanner(System.in);
    /**
     * @param line входная строка чисел вводимая с клавиатуры
     * @see Scanner
     * @return массив элементов типа double
     */
    static double[ ] getArray(String line){
        line = line.trim();
        String[] strArr = line.split(" ");
        double []res = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            res[i] = Double.parseDouble(strArr[i]);
        }
        return  res;
    }
    /**
     * @param arr входной массив double
     * выводит его элементы в одну строку через пробел
     */
    static void printArray(double[ ] arr){
        for (double element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    /**
     * @param arr входной массив double
     * @param name строка перед номером элемента массива при выводе
     * @param columnCount определяет количество столбцов при форматированном выводе элементов массива на экран
     * @see java.io.PrintStream
     * выводит его элементы в одну строку через пробел
     */
    static void printArray(double[ ] arr, String name, int columnCount){

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f ", name, i, arr[i]);
            if((i+1) % columnCount == 0 || i+1 == arr.length) {
                System.out.println();
            }
        }

    }

    /**
     *
     * @return возвращает двухмерный массив double динамического размера
     * Ввод размерности и значений элементов через
     * @see Scanner
     */
    static double[][] setArray(){

        int m,n;
        System.out.print("Введите размерность матрицы [M]x[N]:");
        System.out.println("M=");
        m = sc.nextInt();
        System.out.println("N=");
        n = sc.nextInt();
        double [][] mas = new double[m][n];
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("Введите[% -3d][% -3d] элемент матрицы:%n", i+1, j+1);
                mas[i][j] = sc.nextDouble();
            }
        }
        return mas;
    }
    /**
     *
     * @return возвращает массив double динамического размера
     * Ввод размерности и значений элементов через
     * @see Scanner
     */
    static double[] setArrayVector(){

        int m;
        System.out.print("Введите размерность матрицы [M]:");
        System.out.println("M=");
        m = sc.nextInt();
        double [] mas = new double[m];
        for (int i = 0; i < m ; i++) {
                System.out.printf("Введите[% -3d] элемент матрицы:%n", i+1);
                mas[i] = sc.nextDouble();
            }
        return mas;
        }


    /**
     * @param mas входной двумерный массив double
     * @param name строка имя элемента
     * @return возвращает массив  double динамического размера
     * Ввод размерности и значений элементов через
     * @see Scanner
     */
    static void printArray2D(double [][] mas, String name){
        for (int i = 0; i <mas.length ; i++) {
            for (int j = 0; j <mas[0].length; j++) {
                System.out.printf("%s[% -3d][% -3d]=%-6.2f%n",name, i +1 , j + 1 , mas[i][j]);
            }
            
        }
        }
    }


