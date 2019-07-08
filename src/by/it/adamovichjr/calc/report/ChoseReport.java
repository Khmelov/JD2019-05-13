package by.it.adamovichjr.calc.report;

import by.it.adamovichjr.calc.ResourceManager;
import by.it.adamovichjr.calc.text.All_messages;

import java.util.Scanner;

public class ChoseReport {
    public static boolean needReport = false;
    private static boolean answerForReport = false;

    public static void ChoseOrNotReport() {

        Scanner reportScaner = new Scanner(System.in);
        String line;
        while (!answerForReport) {
            System.out.println(ResourceManager.INSTANCE.get(All_messages.CHOSE_REPORT));
            line = reportScaner.nextLine();
            switch (line) {
                case "2":
                    ChoseReportForDirector(new ShortReportBuilder());
                    break;
                case "1":
                    ChoseReportForDirector(new FullReportBuilder());
                    break;
                case "0":
                    answerForReport = true;
                    System.out.println(ResourceManager.INSTANCE.get(All_messages.CHOSE_WITHOUT_REPORT));
                    break;
                default:
                    System.out.println(ResourceManager.INSTANCE.get(All_messages.WRONG_CHOSE_REPORT));
            }
        }
    }

    private static void ChoseReportForDirector(ReportBuilder reportBuilder) {

        Director.DIRECTOR.SetBuilder(reportBuilder);
        needReport = true;
        answerForReport = true;
        System.out.println(ResourceManager.INSTANCE.get(All_messages.CHOSE_REPORT_COMPLIETE));
    }
}
