package by.it.yaskevich.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Report {
    private static int COLUMNS_COUNT = 7;
    private static int COLUMN_QUEUE = 6;
    private static int COLUMN_RECEIPTS = 7;
    private static int LINE_CASHIER = 1;
    private static int LINE_BUYER = 2;

    static void print(Cashier cashier, Buyer buyer) {
        StringBuilder text = new StringBuilder(1024);

        List<String> lines = new ArrayList<String>() {
            {
                add("Чек");
                add(cashier.getName());
                add(buyer.getName());
                add("--------------");
                buyer.goods.forEach(g -> add(g.getName() + " - " + g.getPrice()));
                add("--------------");
                add("Итого: " + Integer.toString(buyer.goods.stream().mapToInt(Good::getPrice).sum()));
            }
        };

        String empty = "              ";
        int lineIndex = 0;
        for (String line : lines) {
            for (int i = 1; i <= COLUMNS_COUNT; i++) {
                if (cashier.getNumber() == (i - 1)) {
                    text
                            .append("|")
                            .append(line)
                            .append(empty, 0, empty.length() - line.length() - (((lineIndex == LINE_CASHIER) || (lineIndex == LINE_BUYER)) ? 1 : 0));
                }
                else if ((lineIndex == 0) && ((i == COLUMN_QUEUE) || (i == COLUMN_RECEIPTS))) {
                    String temp = (i == COLUMN_QUEUE) ? Integer.toString(Queue.length()) : Integer.toString(Receipts.getValue());
                    if (!temp.isEmpty()) {
                        text
                                .append("|")
                                .append(temp)
                                .append(empty, 0, empty.length() - temp.length());
                    }
                }
                else {
                    text.append("|              ");
                }
            }
            text.append('\n');
            lineIndex++;
        }

        Printer.print(text.toString());
    }
}
