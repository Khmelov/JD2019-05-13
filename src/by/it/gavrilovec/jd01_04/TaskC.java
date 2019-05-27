package by.it.gavrilovec.jd01_04;


import java.util.Scanner;

public class TaskC {

       private static int binarySearch(double[ ] array, double value){
        int lowBorder=0;
        int highBorder=array.length-1;
        int index=0;
           for (;array[index]!=value;) {
              if(array[index]>value) highBorder=index;
               if(array[index]<value) lowBorder=index;
               index=(highBorder+lowBorder)/2;
              if(array[highBorder]==value) index=highBorder;
           }
     return   index;
    }

    private static double[ ] merge(double[] arr1, double[] arr2){
        double[] arr=new double[arr1.length+arr2.length];
        int counterArr1=0;
        int counterArr2=0;
        for (int i = 0; i <arr.length ; i++) {

            if(counterArr1==arr1.length) {
                arr[i]=arr2[counterArr2];
                counterArr2++;
                continue;
            }
            if(counterArr2==arr2.length) {
                arr[i]=arr1[counterArr1];
                counterArr1++;
                continue;
            }
            if(arr1[counterArr1]<arr2[counterArr2]){
                arr[i]=arr1[counterArr1];
                counterArr1++;
                }
            else{
                arr[i]=arr2[counterArr2];
                counterArr2++;
            }
        }
        return arr;
    }

    private static double[] div(double[] arr){
        double [] newArr1;
        double [] newArr2;
        if(arr.length==1) return arr;

        else{

            if(arr.length%2==1) {
                newArr1=new double [arr.length/2+1];
            }
            else{
                 newArr1=new double [arr.length/2];
            }
            newArr2=new double [arr.length/2];
            System.arraycopy(arr,0,newArr1,0,newArr1.length);
            System.arraycopy(arr,newArr1.length,newArr2,0,newArr2.length);
        }

        return merge(div(newArr1),div(newArr2));
    }


    private static void mergeSort(double[] array){
      System.arraycopy(div(array),0,array,0,array.length);

    }

    private static void buildOneDimArray(String line){
        double[] arr=InOut.getArray(line);
        InOut.printArray(arr,"V",5);
        double first=arr[0];
        double last=arr[arr.length-1];
        mergeSort(arr);
        InOut.printArray(arr,"V",4);
        System.out.println("Index of first element="+binarySearch(arr,first));
        System.out.println("Index of last element="+binarySearch(arr,last));
    }


    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String s=scan.nextLine();
        buildOneDimArray(s);
    }
}
