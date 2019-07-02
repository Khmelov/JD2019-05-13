package by.it.aadamovich.jd02_02;

import java.util.List;

class Cheque {

    private static final char LINE_VERT = '\u2551';
    private static final char LINE_HOR = '\u2550';
    private static final int COLUMN_QUANTITY = 7;
    private static final int COLUMN_LENGTH = 13;

    private static final String upPart = createChequePart('\u2554', '\u2566', '\u2557');
    private static final String middlePart = createChequePart('\u2560', '\u256c', '\u2563');
    private static final String lowPart = createChequePart('\u255a', '\u2569', '\u255d');

    private static String createChequePart(char start, char middle, char end) {
        StringBuilder sb = new StringBuilder();
        sb.append(start);
        for (int i = 0; i < COLUMN_QUANTITY; i++) {
            for (int j = 0; j < COLUMN_LENGTH; j++) {
                sb.append(LINE_HOR);
            }
            if (i < COLUMN_QUANTITY - 1) sb.append(middle);
        }
        sb.append(end);
        return sb.toString();
    }

    String printCheque(List<String> basket, int number) {

        StringBuilder sb = new StringBuilder();
        String format = String.format("\n%1$c%2$11s1 %1$c%2$11s2 %1$c%2$11s3 %1$c%2$11s4" +
                        " %1$c%2$11s5 %1$c%3$12s %1$c%4$11s%1$c\n",
                LINE_VERT, "Cashier N", "Queue size", "Market profit");
        sb.append(upPart).append(format).append(middlePart).append("\n");

        String emptyCell = String.format("%c%13s", LINE_VERT, " ");
        String goodsWithPrice;
        int totalCheque = 0;
        int price;
        for (int i = 0; i < basket.size() + 1; i++) {
            if (i < basket.size()) {
                price = Goods.getPrice(basket.get(i));
                totalCheque += price;
                goodsWithPrice = basket.get(i) + "=" + price;
            } else {
                goodsWithPrice = "Total: " + totalCheque;
            }
            for (int j = 0; j < 7; j++) {
                if (j == number - 1) {
                    sb.append(String.format("%c%11s  ", LINE_VERT, goodsWithPrice));
                } else if (i == basket.size() && j == 5) {
                    sb.append(String.format("%c%11d  ", LINE_VERT, Queue.getQueueSize()));
                } else if (i == basket.size() && j == 6) {
                    sb.append(String.format("%c%11d  ", LINE_VERT, Goods.increaseProfit(totalCheque)));
                } else {
                    sb.append(emptyCell);
                }
            }
            sb.append(LINE_VERT).append('\n');
        }
        sb.append(lowPart);
        return sb.toString();
    }
}
