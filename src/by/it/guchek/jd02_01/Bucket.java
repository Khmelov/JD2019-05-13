package by.it.guchek.jd02_01;

public class Bucket {

    public static void goodsInBacket() {

        for (int i = 0; i < RandCount.randFrTo(1, 4); i++) {

            String newGood = Goods.getRandGood();
            System.out.printf("                 %s%n", newGood);


        }
    }
}
