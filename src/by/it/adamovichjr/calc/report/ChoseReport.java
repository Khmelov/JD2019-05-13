package by.it.adamovichjr.calc.report;

import by.it.adamovichjr.calc.ResourceManager;
import by.it.adamovichjr.calc.text.All_messages;

import java.util.Scanner;

public class ChoseReport {
    public static boolean needReport = false;

    public static void ChoseOrNotreport(){

        Scanner reportScaner = new Scanner(System.in);
        String line;
        boolean answerForReport = false;
        while (!answerForReport){
            System.out.println(ResourceManager.INSTANCE.get(All_messages.CHOSE_REPORT));
            line = reportScaner.nextLine();
            switch (line){
                case "2":
                    Director.DIRECTOR.SetBuilder(new ShortReportBuilder());
                    needReport = true;
                    answerForReport =true;
                    System.out.println(ResourceManager.INSTANCE.get(All_messages.CHOSE_REPORT_COMPLIETE));
                    break;
                case "1":
                    Director.DIRECTOR.SetBuilder(new FullReportBuilder());
                    needReport = true;
                    answerForReport =true;
                    System.out.println(ResourceManager.INSTANCE.get(All_messages.CHOSE_REPORT_COMPLIETE));
                    break;
                case "0":
                    answerForReport = true;
                    break;
                default:
                    System.out.println(ResourceManager.INSTANCE.get(All_messages.WRONG_CHOSE_REPORT));
            }
        }

    }
}
