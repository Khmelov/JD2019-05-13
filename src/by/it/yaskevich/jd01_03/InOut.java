package by.it.yaskevich.jd01_03;

class InOut {
    static double[ ] getArray(String line) {
        String[] elements = line.trim().split(" ");
        double[] array = new double[elements.length];
        for (int i = 0; i < elements.length; i++) {
            array[i] = Double.parseDouble(elements[i]);
        }
        return array;
    }

    static void printArray(double[] array) {
        for (double item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    static void printArray(double[] array, String name, int colCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-7.3f ", name, i, array[i]);
            if (((i + 1) % colCount == 0) || (i == array.length - 1))
                System.out.println();
        }
    }
}
