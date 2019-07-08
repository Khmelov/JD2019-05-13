package by.it.buymistrov.calc;

import java.util.*;


public class ConsoleRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression;
        Parser parser = new Parser();
        Printer printer = new Printer();
        ResManager manager = ResManager.INSTANCE;
        while (!(expression = scanner.nextLine()).equals(Patterns.END)) {
            Var var;
            switch (expression) {
                case Patterns.PRINTVAR: {
                    Set<Map.Entry<String, Var>> setv = Var.getVars().entrySet();
                    for (Map.Entry<String, Var> me : setv) {
                        System.out.println(me.getKey() + " = " + me.getValue());
                    }
                    break;
                }
                case Patterns.SORTVAR: {
                    TreeSet<String> set = new TreeSet<>();
                    Set<Map.Entry<String, Var>> setv = Var.getVars().entrySet();
                    for (Map.Entry<String, Var> me : setv) {
                        set.add(me.getKey());
                    }
                    for (String s : set) {
                        System.out.println(s + " = " + Var.getVars().get(s));
                    }
                    break;
                }
                case Patterns.EN:
                    manager.setLocale(new Locale("en", "EN"));
                    break;
                case Patterns.BE:
                    manager.setLocale(new Locale("be", "BY"));
                    break;
                case Patterns.RU:
                    manager.setLocale(new Locale("ru", "RU"));
                    break;
                default:
                    try {
                        var = parser.calc(expression);
                        printer.print(var);
                    } catch (CalcException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }
}
