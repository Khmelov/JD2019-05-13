package by.it.adamovichjr.jd01_03;

public class InOut {
    public static double[] getArray(String line){
        line = line.trim();
        String[] line2 = line.split(" ");
        double[] array = new double[line2.length];
        for (int i = 0; i < line2.length; i++) {
            array[i] = Double.parseDouble(line2[i]);
        }
        return array;
    }

    public static void printArray(double[] arr){
        for (double v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    public static void printArray(double[] arr, String name, int columCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.3f ",name,i,arr[i]);
            if ((i+1)%columCount == 0 || i +1 == arr.length)
                System.out.println();
        }
    }
}
