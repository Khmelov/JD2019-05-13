package by.it.zhukova.jd01_04;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);
    }
    static void buildOneDimArray(String line){

        double[] arr = InOut.getArray(line);
        InOut.printArray(arr,"V",5);
        double first = arr[0];
        double last = arr[arr.length-1];
        System.out.println(first+" "+last);
        double[] sort = Sort(arr);

        int infirst = binarySearch(sort, first);
        int inlast = binarySearch(sort, last);

        System.out.println("Index of first element="+infirst);
        System.out.println("Index of last element="+inlast);
    }
  //  private static double[ ] merge(double[ ] part1, double[ ] part2){    }
      static int binarySearch(double[ ] array, double value) {
        int l = 0;
        int r = array.length-1;
        while ( l <= r){
            int m = (l+r)/2;
            double mid = array[m];
            if (mid < value) l=m+1;
            else if (mid > value) r=m-1;
            else return m;
        }
        return -(l+1);
      }
    private static double[] Sort(double[] arr) {
        double m=0;
        boolean swap;
        int last = arr.length - 1;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if (arr[i] > arr[i + 1]) {
                    m = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = m;
                    swap = true;
                }
            }
            last--;
        } while (swap);
        //Arrays.sort(arr);
        System.out.println("Отсортированный массив:");
        InOut.printArray(arr,"V",4);
        return arr;

    }
}
