package by.it.yakovets.jd01_03;

 class InOut {
    static double[] getArray(String line) {
        String line2 = line.trim();
        String[] strArray = line2.split(" ");
        double[] array = new double[strArray.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Double.parseDouble(strArray[i]);
        }
        System.out.println();
        return array;
    }

    static void printArray(double[] array) {
        for (double e : array) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    static void printArray(double[] array, String name, int columnCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-7.4f ", name, i, array[i]);
            if ((i + 1) % columnCount == 0 || (i + 1) == array.length)
                System.out.println();
        }
    }
}


