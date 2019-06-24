package by.it.buymistrov.calc;

import java.util.*;


public class ConsoleRunner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String expression;
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(expression = scanner.nextLine()).equals("end")) {
            Var var = null;
            try {
                var = parser.calc(expression);
                printer.print(var);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }


            if (expression.equals(("printvar"))) {

                Set<Map.Entry<String, Var>> setv = Var.getVars().entrySet();
                for (Map.Entry<String, Var> me : setv) {
                    System.out.println(me.getKey() + " = " + me.getValue());

                }

            }

            if (expression.equals(("sortvar"))) {
                TreeSet<String> set = new TreeSet<>();

                Set<Map.Entry<String, Var>> setv = Var.getVars().entrySet();
                for (Map.Entry<String, Var> me : setv) {
                    set.add(me.getKey());
                }

                for (String s : set) {
                    System.out.println(s + " = " + Var.getVars().get(s));

                }


            }


        }
    }
}
