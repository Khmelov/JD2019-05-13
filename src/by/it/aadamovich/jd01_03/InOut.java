package by.it.aadamovich.jd01_03;

class InOut {
    static double[] getArray(String line) {

        String[] arrayString = line.trim().split(" ");
        double[] arrayDouble = new double[arrayString.length];
        for (int i = 0; i < arrayDouble.length; i++) {
            arrayDouble[i] = Double.parseDouble(arrayString[i]);
        }
        return arrayDouble;
    }

    static void printArray(double[] arr) {
        for (double v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-7.3f ", name, i, arr[i]);
            if ((i + 1) % columnCount == 0 || i == arr.length - 1) System.out.println();
        }
        System.out.println();
    }

    static void printArrayVector(double[] arr, String name) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-7.1f ", name, i, arr[i]);
        }
        System.out.println('\n');
    }

    static void printArrayMatrix(double[][] arr, String name) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.printf("%s[%1d,%d]=%-7.1f ", name, i, j, arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}

