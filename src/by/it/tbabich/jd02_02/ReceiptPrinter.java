package by.it.tbabich.jd02_02;

import java.util.List;

class ReceiptPrinter {

    private int numberCashbox;

    public ReceiptPrinter(int numberCashbox) {
        this.numberCashbox = numberCashbox;
    }

    private void printTop() {
        System.out.println("==========================================================================================================================================");
        System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%15s|%15s|\n", "Касса 1", "Касса 2", "Касса 3", "Касса 4", "Касса 5", "Длина Очереди", "Общая выручка");
        System.out.println("==========================================================================================================================================");
    }

    private void printBottom() {
        System.out.println("==========================================================================================================================================");
    }

    public void printCheck(List<Product> productList) {
        double amount = 0;
        printTop();
        for (Product product : productList) {
            switch (numberCashbox) {
                case 1:
                    System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%15s|%15s|\n", product, "", "", "", "", "", "");
                    break;
                case 2:
                    System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%15s|%15s|\n", "", product, "", "", "", "", "");
                    break;
                case 3:
                    System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%15s|%15s|\n", "", "", product, "", "", "", "");
                    break;
                case 4:
                    System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%15s|%15s|\n", "", "", "", product, "", "", "");
                    break;
                case 5:
                    System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%15s|%15s|\n", "", "", "", "", product, "", "");
                    break;
            }
            amount += product.getCost();
        }
        Dispatcher.addTotal(amount);
        String amountString = String.format("%.2f", amount);
        String totalString = String.format("%.2f byn", Dispatcher.getTotal());
        int queueSize = PensionersQueue.getQueueSize() + Queue.getQueueSize();
        switch (numberCashbox) {
            case 1:
                System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%15d|%15s|\n", "Итого - " + amountString + " byn", "", "", "", "", queueSize, totalString);
                break;
            case 2:
                System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%15d|%15s|\n", "", "Итого - " + amountString + " byn", "", "", "", queueSize, totalString);
                break;
            case 3:
                System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%15d|%15s|\n", "", "", "Итого - " + amountString + " byn", "", "", queueSize, totalString);
                break;
            case 4:
                System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%15d|%15s|\n", "", "", "", "Итого - " + amountString + " byn", "", queueSize, totalString);
                break;
            case 5:
                System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%15d|%15s|\n", "", "", "", "", "Итого - " + amountString + " byn", queueSize, totalString);
                break;
        }
        printBottom();
    }
}
