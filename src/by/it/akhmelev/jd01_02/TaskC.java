package by.it.akhmelev.jd01_02;

public class TaskC {

    static int[][] step3(int[][] array) {
        int max = getMax(array);

        boolean[] delRow = new boolean[array.length];
        boolean[] delCol = new boolean[array[0].length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == max) {
                    delRow[i] = true;
                    delCol[j] = true;
                }
            }
        }

        int ir = array.length;
        for (boolean del : delRow) if (del) ir--;
        int jr = array[0].length;
        for (boolean del : delCol) if (del) jr--;

        int[][] res = new int[ir][jr];

        int indexRow = 0;
        for (int i = 0; i < array.length; i++) {
            if (!delRow[i]) {
                int indexCol = 0;
                for (int j = 0; j < array[i].length; j++) {
                    if (!delCol[j]) {
                        res[indexRow][indexCol] = array[i][j];
                        indexCol++;
                    }
                }
                indexRow++;
            }
        }

        for (int[] row : res) {
            for (int e : row) {
                System.out.print(e + " ");
            }
            System.out.println();
        }

        return res;
    }

    private static int getMax(int[][] array) {
        int max = Integer.MIN_VALUE;
        for (int[] row : array) {
            for (int e : row) {
                if (max < e)
                    max = e;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] m4 = {{1, -2, -2, 6}, {-1, 2, -2, 2}, {-2, -2, -6, -2}, {1, 2, -2, 6}};
        step3(m4);
    }


}
