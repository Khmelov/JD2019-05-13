package by.it.dilkevich.jd02_05.TaskB;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {

        String line;

        do {

            line = getLine();
            if (line.equals("chosed"))
                break;
            ResManager resManager = setLocale(line);
            ResourceBundle resourceBundle = resManager.getResBundle();
            printText(resManager, resourceBundle);
        }
        while (!false);

    }

    private static void printText(ResManager resManager, ResourceBundle resourceBundle) {
        String hello = resourceBundle.getString("message.welcome");
        String question = resourceBundle.getString("message.question");
        String name = resourceBundle.getString("user.name");
        String correctDate = resManager.getCorrectDate();

        System.out.println(correctDate);
        System.out.println(hello);
        System.out.println(question);
        System.out.println(name);
        System.out.println();
    }

    private static ResManager setLocale(String line) {
        String lang = "";
        String country = "";

        switch (line){

            case "1": {
                lang = null;
                country = null;
                break;
            }
            case "2": {
                lang  = "ru";
                country = "RU";
                break;
            }
            case "3": {
                lang = "be";
                country = "BY";
                break;
            }
            default:
                System.out.println("Not exepted");
         }
        ResManager resManager = new ResManager();

        if (lang != null){

            resManager.setLocale(lang, country);
        }
        return resManager;
    }

    private static String getLine() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose language");
        System.out.println("Enter: 1 - EN  2 - RU  3 - BY");
        return scanner.nextLine();
    }

}
