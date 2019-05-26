package by.it.trudnitski.jd01_03;

public class InOut {

    static double[] getArray(String line){
        String line2 = line.trim();
        String[] strArray = line2.trim().split(" ");

        double[] array = new double [strArray.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Double.parseDouble(strArray[i]);
        }
        return array;
    }

    static void printArray(double[] array){
        for (double element : array) {
            System.out.print(element+" ");
        }
        System.out.println();
    }


    static void printArray(double[] array, String name, int colCount){
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-7.3f ", name, i, array[i]);
            if((i+1)%colCount==0||i+1==array.length);
            System.out.println();
        }

    }

}
