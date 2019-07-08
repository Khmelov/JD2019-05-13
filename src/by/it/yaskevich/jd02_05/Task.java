package by.it.yaskevich.jd02_05;

import java.text.DateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        ResourcesManager manager = ResourcesManager.INSTANCE;
        if (args.length == 2) {
            manager.setLocale(new Locale(args[0], args[1]));
        }
        System.out.println(manager.getString(Resources.WELCOME));
        System.out.println(manager.getString(Resources.QUESTION));
        System.out.println(manager.getString(Resources.NAME));

        Scanner scanner = new Scanner(System.in);

        String rawData;
        while (!(rawData = scanner.nextLine()).equals("end")) {
            manager.setLocale(getLocaleByCommand(rawData));
            printTodayDate(getTodayDateString());
        }
    }

    private static void printTodayDate(String dateString) {
        ResourcesManager manager = ResourcesManager.INSTANCE;
        System.out.println(manager.getString(Messages.TODAY) + " " + dateString);
    }

    private static String getTodayDateString() {
        ResourcesManager manager = ResourcesManager.INSTANCE;
        DateFormat dateInstance = DateFormat.getDateInstance(DateFormat.LONG, manager.getLocale());
        return dateInstance.format(Date.from(Instant.now()));
    }

    private static Locale getLocaleByCommand(String rawData) {
        switch (rawData) {
            case "ru": {
                return new Locale("ru", "RU");
            }
            case "be": {
                return new Locale("be", "BY");
            }
            case "en":
            default: {
                return Locale.ENGLISH;
            }
        }
    }
}
