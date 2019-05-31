package by.it.dnevar.jd01_03;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        double[] array = InOut.getArray("1 2 3 4 123 2 2 3 3 4 4");
        InOut.printArray(array);
        InOut.printArray(array,"A",3);
        double max = Helper.findMin(array);
        double min = Helper.findMax(array);
        double[][] array1 = {{1,2,3,4},{3,1,4,8},{5,3,5,6},{8,6,4,3}};
        double[] array2 = {1,2,3,4};
        double [] res1 = Helper.mul(array1,array2);
        double [][] res2 = Helper.mul(array1,array1);
    }
}
