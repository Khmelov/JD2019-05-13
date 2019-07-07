package by.it.adamovichjr.calc;

import by.it.adamovichjr.calc.report.ChoseReport;
import by.it.adamovichjr.calc.report.Director;
import by.it.adamovichjr.calc.text.All_messages;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {

        ChoseReport.ChoseOrNotReport(); //Начало отсчета работы программы начинается после выбора типа отчета
        if (ChoseReport.needReport) {
            Director.DIRECTOR.putTime(ResourceManager.INSTANCE.get(All_messages.START_PROGRAM));
        }
        Scanner scanner = new Scanner(System.in);
        String line;

        Parser parser = new Parser();
        Printer printer = new Printer();


        while (!(line = scanner.nextLine()).equals("end")) {
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
                    resetLocale("ru", "RU");
                    break;
                case "be":
                    resetLocale("be", "BY");
                    break;
                case "en":
                    resetLocale("en", "EN");
                    break;
                default:
                    try {
                        Var result = parser.calc(line);

                        printer.print(result);
                    } catch (CalcException e) {
                        SingeltonLogger.LOGGER.writeLogInFile(e);
                        if (ChoseReport.needReport) {
                            Director.DIRECTOR.putExceptionToDirector(e, line, ResourceManager.INSTANCE.getTime());
                        }
                        System.out.println(e.getMessage());
                    }
            }
        }
        if (ChoseReport.needReport) {
            Director.DIRECTOR.putTime(ResourceManager.INSTANCE.get(All_messages.FINISH_PROGRAM));
            System.out.println(Director.DIRECTOR.BuildReport());
        }
    }

    private static void resetLocale(String language, String country) {
        ResourceManager.INSTANCE.setLocale(language, country);
        System.out.println(ResourceManager.INSTANCE.get(All_messages.SET_LANGUAGE));
    }
}

