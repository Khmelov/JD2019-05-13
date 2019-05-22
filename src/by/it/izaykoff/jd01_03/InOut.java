package by.it.izaykoff.jd01_03;

 class InOut {
    static  double [] getArray (String line){

        String[] strArray = line.split(" ");
        double[] array = new double[strArray.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Double.parseDouble(strArray[i]);

        }

        return array;
    }

    static void printArray(double[] array){
        for (double e : array) {
            System.out.println(e + " ");

        }
        System.out.println();
    }

    static void printArray(double[] array,String name, int colCount){
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-7.3f ",name, i, array[1] );
            if((i + 1) % colCount == 0){
                System.out.println();
            }
            System.out.println();
        }
    }
}
