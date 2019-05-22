package by.it.akhmelev.jd01_04;

class InOut {

    static double[] getArray(String line) {
        //1 2 3 8 123
        String[] strArray = line.trim().split(" ");
        double[] array = new double[strArray.length];
        for (int i = 0; i < array.length; i++) {
            array[i]=Double.parseDouble(strArray[i]);
        }
        return array;
    }

    static  void printArray(double[] array){
        for (double e : array) {
            System.out.print(e+" ");
        }
        System.out.println();
    }

    static void  printArray(double[] array, String name, int colCount){
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-7.3f ",name,i,array[i]);
            if ((i+1)%colCount==0)
                System.out.println();
        }
        System.out.println();
    }


}
