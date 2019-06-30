package by.it.guchek.jd02_02;

import java.util.HashMap;
import java.util.Map;

class Bucket {

    private static Map<Integer, Object> goodsThisBuyer = new HashMap<>();
    private static Map<String, Object> goodsThisBuyerForCount = new HashMap<>();

    static synchronized void goodsInBacket(String nameBuyer) {
        int g=0;

        for (int i = 0; i < RandCount.randFrTo(1, 4); i++) {
            g=i;
            Object newGood = Goods.getRandGood();
            System.out.printf("%s положил в корзину %s%n",nameBuyer,newGood);
            //Goods.getRandGood();
            goodsThisBuyer.put(g,newGood);
            //System.out.println("В корзине у "+ nameBuyer+" "+goodsThisBuyer.get(g));
        }

        goodsThisBuyerForCount.put(nameBuyer,goodsThisBuyer);//закрепим корзину за покупателем
        //System.out.println(goodsThisBuyerForCount.size());

        for (int j = 0; j <g+1 ; j++) {

            goodsThisBuyerForCount.put(nameBuyer,goodsThisBuyer);

            System.out.println("В корзине у "+ nameBuyer+" "+goodsThisBuyer.get(j));

        }

    }

}
