package by.it.dnevar.jd01_15;

public class TaskA {
    public static void main(String[] args) {

        int[][] array = new int[6][4];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] =(int)(-15 + Math.random()*31);
            }
        }

    }
}
