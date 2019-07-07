package by.it.orlov.jd02_05;

import java.util.ResourceBundle;
import java.util.Scanner;

public class Task {

    public static void main(String[] args) {

        String line;
        do {

            line = getLine();
            if (line.equals("change"))
                break;
            ResManager resManager = setLocale(line);
            ResourceBundle resourceBundle = resManager.getResBundle();
            printText(resManager, resourceBundle);
        }
        while (true);

    }

    private static void printText(ResManager ResManager, ResourceBundle resourceBundle) {
        String welc = resourceBundle.getString("message.welcome");
        String ques = resourceBundle.getString("message.q");
        String myName = resourceBundle.getString("user.name");
        String date = ResManager.getDateNow();

        System.out.println(date + "\n"
                + welc + "\n"
                + ques + "\n"
                + myName + "\n");
    }

    private static ResManager setLocale(String line) {
        String language = "", locale = "";
        switch (line){

            case "e": {
                language = null;
                locale = null;
                break;
            }
            case "r": {
                language  = "ru";
                locale = "RU";
                break;
            }
            case "b": {
                language = "be";
                locale = "BY";
                break;
            }
            default:
                System.out.println("Not Found");
         }
        ResManager resM = new ResManager();

        if (language != null){

            resM.setLocale(language, locale);
        }
        return resM;
    }

    private static String getLine() {
        Scanner s = new Scanner(System.in);
        System.out.println("You can change language here\n" +
                "Enter: e - EN  r - RU  b - BY");
        return s.nextLine();
    }

}
