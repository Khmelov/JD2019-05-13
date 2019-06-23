package by.it.guchek.jd01_15;

import java.io.*;


public class TaskA {

    private static String getPath(Class<?> aClass) {
        String root = System.getProperty("user.dir");
        String name = aClass.getName();
        String simpleName = aClass.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);
        path = root + separator + "src" + separator + path;
        return path;
    }

    static String fileName = getPath(TaskA.class)+"matrix.txt";

    public static void main(String[] args) {

        int[][] arrRand = new int[6][4];

        boolean minEx = false;
        boolean maxEx = false;

        do {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 4; j++) {

                    arrRand[i][j] = -15 + (int) (Math.random() * (31));
                    if (arrRand[i][j] == -15) minEx = true;
                    if (arrRand[i][j] == 15) maxEx = true;
                    //System.out.print(arrRand[i][j] + " ");

                }
            }
            //System.out.println();

        }
        while (!minEx || !maxEx);

        writeMatrOutFile(arrRand);

        try (BufferedReader readMatrInCons = new BufferedReader(new FileReader(fileName))){

            for (; ; ) {
                String line = readMatrInCons.readLine();
                if (line == null)
                    break;
                System.out.println(line);}
            /*while (!(readMatrInCons.read()==-1)){
                String line = readMatrInCons.readLine();
                System.out.println(line);
            }*/

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeMatrOutFile(int[][] arrRand) {
        File fileForMatrix = new File(getPath(TaskA.class)+"matrix.txt");

        try (
                PrintWriter prWrInFile = new PrintWriter(
                        new FileWriter(fileForMatrix))
        ) {
            for (int[] row : arrRand) {
                for (int colElem : row) {

                    prWrInFile.printf("%3d ",colElem);
                }

                prWrInFile.println();
            }

    } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
