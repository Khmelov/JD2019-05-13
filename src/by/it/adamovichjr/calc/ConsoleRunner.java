package by.it.adamovichjr.calc;

import by.it.adamovichjr.calc.text.All_messages;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        ResourceManager manager = ResourceManager.INSTANCE;
        Scanner scanner = new Scanner(System.in);
        String line;

        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!(line=scanner.nextLine()).equals("end")){
            switch (line) {
                case "printvar":
                    printer.printvar(Var.getVars());
                    break;
                case "sortvar":
                    printer.sortvar();
                    break;
                case "ru":
                    manager.setLocale("ru","RU");
                    System.out.println(manager.get(All_messages.SET_LANGUAGE));
                    break;
                case "be":
                    manager.setLocale("be","BY");
                    System.out.println(manager.get(All_messages.SET_LANGUAGE));
                    break;
                case "en":
                    manager.setLocale("en","EN");
                    System.out.println(manager.get(All_messages.SET_LANGUAGE));
                    break;
                default:
                    try {
                        Var result = parser.calc(line);
                        printer.print(result);
                    } catch (CalcException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }

