package by.it.dilkevich.calc;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws CalcException, IOException {

        Scanner scanner = new Scanner(System.in);
        String inputLine;
        SessionCounter.setNewSession();
        Parser parser = new Parser();
        Printer printer = new Printer();
        ResManager resManager = new ResManager(Locale.getDefault());
        Report.startSession = new Date().toString();
        OperationsSaver.saveNewSession();

        while (!((inputLine = scanner.nextLine()).equals("end"))) {

            OperationsSaver.saveInputOperatonsFile(inputLine);

            try {

                if (inputLine.equals("ru")) {
                    System.out.println("RU language selected");
                    resManager = new ResManager(new Locale("ru", "RU"));
                }
                else if (inputLine.equals("be")) {
                    System.out.println("BY language selected");
                    resManager = new ResManager(new Locale("be", "BY"));
                }
                else if (inputLine.equals("en")) {
                    System.out.println("EN language selected");
                    resManager = new ResManager(new Locale("",""));
                }

                else if(inputLine.equals("short report")){
                    AbstractReportBuilder abstractReportBuilder = new ShortReportBuilder();
                    ReportBuilderDirector director = new ReportBuilderDirector();
                    director.setReportBuilder(abstractReportBuilder);
                    director.createReport();
                }
                else if(inputLine.equals("full report")){
                    AbstractReportBuilder abstractReportBuilder = new FullReportBuilder();
                    ReportBuilderDirector director = new ReportBuilderDirector();
                    director.setReportBuilder(abstractReportBuilder);
                    director.createReport();
                }

                else if (inputLine.equals("printvar")) {

                    printer.printVar();
                }
                else if (inputLine.equals("sortvar")) {

                    printer.printSortVar();
                }
                else {
                    Var result = parser.calc(inputLine);
                    printer.print(result);
                }


            } catch (CalcException e) {

                System.out.println(e.getMessage());
            }
        }
        Report.endSession = new Date().toString();
        OperationsSaver.saveEndSession();

    }



}
