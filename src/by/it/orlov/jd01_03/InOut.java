package by.it.orlov.jd01_03;

class InOut {

    static double[] getArray(String line) {
        String[] s_array = line.trim().split(" ");
        double[] res = new double[s_array.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = Double.parseDouble(s_array[i]);
        }
        return res;
    }

    static void printArray(double[] array) {
        for (double e : array) {
            System.out.print(e + " ");
        }
    }

    static void printArray(double[] array, String name, int colCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%7.3f ",name, i, array[i]);
            if ((i+1)%colCount==0){
                System.out.println();
            }
        }
        System.out.println();
    }
}