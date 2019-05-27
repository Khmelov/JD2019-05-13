package by.it.dilkevich.jd01_03;

public class Runner {
    public static void main(String[] args) {
        //InOut.getArray("1 1 1 1 3 4 5 6 7 8 9 9");
        //int [][]mas = {{5, 4, 6, 2}, {5, 4, 6, 2}};
        //InOut.printArray(mas, "Dima", 3);
        String line = "4 5 6 7 8 4 3 6 7 8";
        double mas[] = InOut.getArray(line);
        InOut.printArray(mas);
        System.out.println();
        InOut.printArray(mas, "v", 4);
        Helper.sort(mas);
        InOut.printArray(mas);
        System.out.println();
        System.out.println(Helper.findMax(mas));
        System.out.println(Helper.findMin(mas));

    }

}
