package by.it.zhukova.jd02_05;

import by.it.zhukova.jd02_05.names.Messages;
import by.it.zhukova.jd02_05.names.User;

import java.util.Locale;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        ResManager manager = ResManager.INSTANCE;
        if (args.length == 2) {
            String lang=args[0];
            String country=args[1];
            Locale locale = new Locale(lang,country);
            manager.setLocale(locale);
            String date = manager.getDate(locale);
            System.out.println(date);
        }
        printConsol(manager);
        System.out.println("You can change language ru be en:");
        Scanner scanner = new Scanner(System.in);
        String lang=scanner.nextLine();
        String country = "";
        switch (lang) {
            case "ru":
                country = "RU";
                break;
            case "be":
                country = "BY";
                break;
            default:
                lang = "en";
                country = "US";
        }
        Locale locale = new Locale(lang,country);
        manager.setLocale(locale);
        String date = manager.getDate(locale);
        System.out.println(date);
        printConsol(manager);

    }

    private static void printConsol(ResManager manager) {
        String welcome = manager.get(Messages.WELCOME);
        String question = manager.get(Messages.QUESTION);
        String userName = manager.get(User.NAME);
        System.out.println(welcome);
        System.out.println(question);
        System.out.println(userName);
    }
}
