package by.it.aadamovich.jd02_05;

import by.it.aadamovich.jd02_05.names.ResData;

import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {

        ResManager manager = ResManager.INSTANCE;
        if (args.length == 2) {
            manager.changeResource(args[0], args[1]);
        }

        Date date = new Date();
        Scanner sc = new Scanner(System.in);
        String line;

        while (!(line = sc.nextLine()).equals("end")) {
            switch (line) {
                case "en":
                    manager.changeResource(Locale.getDefault());
                    System.out.println(manager.getString(ResData.CHANGE_LANGUAGE));
                    break;
                case "ru":
                    manager.changeResource("ru", "RU");
                    System.out.println(manager.getString(ResData.CHANGE_LANGUAGE));
                    break;
                case "be":
                    manager.changeResource("be", "BY");
                    System.out.println(manager.getString(ResData.CHANGE_LANGUAGE));
                    break;
                default:
                    System.out.println(manager.getString(ResData.UNKNOWN));
            }
        }

        System.out.println(manager.getString(ResData.WELCOME));
        System.out.println(manager.getString(ResData.QUESTION));
        System.out.println(manager.getString(ResData.NAME));
        System.out.println(manager.getTime(date));
    }
}
