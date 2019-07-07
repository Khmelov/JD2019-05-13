package by.it.adamovichjr.calc;

import by.it.adamovichjr.calc.report.Director;
import by.it.adamovichjr.calc.report.FullReportBuilder;
import by.it.adamovichjr.calc.report.ShortReportBuilder;
import by.it.adamovichjr.calc.text.All_messages;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Director director = Director.DIRECTOR;
        Director.DIRECTOR.putTime("Program start at: ");
        ResourceManager manager = ResourceManager.INSTANCE;
        switch (args[0]){
            case "0":
                director.SetBuilder(new ShortReportBuilder());
                break;
            case "1":
                director.SetBuilder(new FullReportBuilder());
        }
        Scanner scanner = new Scanner(System.in);
        String line;

        Parser parser = new Parser();
        Printer printer = new Printer();


        while (!(line=scanner.nextLine()).equals("end")){
            SingeltonLogger.LOGGER.writeLogInFile(line);
            Director.DIRECTOR.putEventToDirector(line);
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
                        SingeltonLogger.LOGGER.writeLogInFile(e);
                        Director.DIRECTOR.putExceptionToDirector(e,line,ResourceManager.INSTANCE.getTime());
                        System.out.println(e.getMessage());
                    }
                }
            }
        Director.DIRECTOR.putTime("Program finish at: ");
        System.out.println(Director.DIRECTOR.BuildReport());
    }
    }

