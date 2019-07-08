package by.it.tbabich.jd02_05;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import by.it.tbabich.jd02_05.names.*;

class TaskB {

    private static ResManager manager;
    private static ZonedDateTime zonedDateTime;

    public static void main(String[] args) {
        manager = ResManager.INSTANCE;
        if (args.length == 2) {
            String lang = args[0];
            String country = args[1];
            Locale locale = new Locale(lang, country);
            manager.setLocale(locale);
        }
        hello();
        console(manager);
        return;

    }

    private static void hello() {
        String welcome = manager.get(ResData.WELCOME);
        String question = manager.get(ResData.QUESTION);
        String username = manager.get(ResData.NAME);
        System.out.println(welcome);
        System.out.println(question);
        System.out.println(username);
    }

    private static void console(ResManager manager) {
        Scanner sc = new Scanner(System.in);
        String line = "";
        while (!line.equals(ConsoleCommands.END)) {
            line = sc.nextLine();
            switch (line) {
                case ConsoleCommands.SET_LANGUAGE_EN:
                    manager.setLocale(new Locale(Languages.EN, Countries.EN));
                    System.out.println(manager.get(Messages.SET_LANGUAGE));
                    break;
                case ConsoleCommands.SET_LANGUAGE_RU:
                    manager.setLocale(new Locale(Languages.RU, Countries.RU));
                    System.out.println(manager.get(Messages.SET_LANGUAGE));
                    break;
                case ConsoleCommands.SET_LANGUAGE_BE:
                    manager.setLocale(new Locale(Languages.BE, Countries.BY));
                    System.out.println(manager.get(Messages.SET_LANGUAGE));
                    break;
                case ConsoleCommands.PRINT_DATE:
                    printDate();
                    break;
            }
        }
    }

    private static void printDate() {
        System.out.println(manager.get(Messages.DATE));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Patterns.DATETIME_FORMAT, manager.getLocale());
        zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime.format(formatter));
    }
}
