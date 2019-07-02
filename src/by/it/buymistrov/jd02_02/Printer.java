package by.it.buymistrov.jd02_02;

class Printer {
    private static int amount = 0;


    static void print(Cashier cashier, Buyer buyer) {

        StringBuilder out = new StringBuilder();

        int buyerAmount = 0;

        for (String s : buyer.getGood()) {
            buyerAmount += Goods.getPrice(s);
        }

        amount +=buyerAmount;



        out.append("___________________________________________________________________________________________________________________________");
        out.append("\n");
        out.append("Cashier1       ").append("Cashier2       ").append("Cashier3       ").append("Cashier4       ").append("Cashier5       ").append("Queue ").append("  TotalCash ");
        if (cashier.getNumber() == 0) {
            out.append("\n");
            out.append(buyer.getName()).append("                                                                   ").append(Queue.length()).append("         ").append(amount).append("\n");
            for (String s : buyer.getGood()) {
                out.append(s).append(" - ").append(Goods.getPrice(s)).append("\n");
            }
            out.append("Total-").append(buyerAmount).append("\n");
        } else if (cashier.getNumber() == 1) {
            out.append("\n");
            out.append("               ").append(buyer.getName()).append("                                                    ").append(Queue.length()).append("         ").append(amount).append("\n");
            for (String s : buyer.getGood()) {
                out.append("               ").append(s).append(" - ").append(Goods.getPrice(s)).append("\n");
            }
            out.append("               ").append("Total-").append(buyerAmount).append("\n");
        } else if (cashier.getNumber() == 2) {
            out.append("\n");
            out.append("                              ").append(buyer.getName()).append("                                     ").append(Queue.length()).append("         ").append(amount).append("\n");
            for (String s : buyer.getGood()) {
                out.append("                              ").append(s).append(" - ").append(Goods.getPrice(s)).append("\n");
            }
            out.append("                              ").append("Total-").append(buyerAmount).append("\n");
        } else if (cashier.getNumber() == 3) {
            out.append("\n");
            out.append("                                             ").append(buyer.getName()).append("                      ").append(Queue.length()).append("         ").append(amount).append("\n");
            for (String s : buyer.getGood()) {
                out.append("                                             ").append(s).append(" - ").append(Goods.getPrice(s)).append("\n");
            }
            out.append("                                             ").append("Total-").append(buyerAmount).append("\n");
        } else if (cashier.getNumber() == 4) {
            out.append("\n");
            out.append("                                                            ").append(buyer.getName()).append("       ").append(Queue.length()).append("         ").append(amount).append("\n");
            for (String s : buyer.getGood()) {
                out.append("                                                            ").append(s).append(" - ").append(Goods.getPrice(s)).append("\n");
            }
            out.append("                                                            ").append("Total-").append(buyerAmount).append("\n");
        }
        out.append("___________________________________________________________________________________________________________________________");

        System.out.println(out.toString());
    }
}