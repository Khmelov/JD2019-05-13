package by.it.aadamovich.jd01_04;

class Helper {

    static void sort(double[] arr) {
        int lastElement = arr.length - 1;
        boolean swap;
        do {
            swap = false;
            for (int i = 0; i < lastElement; i++) {
                if (arr[i] > arr[i + 1]) {
                    double buffer = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buffer;
                    swap = true;
                }
            }
            lastElement--;
        } while (swap);
    }
}
