package by.it.buymistrov.jd02_05;

import by.it.buymistrov.jd02_05.names.Messages;
import by.it.buymistrov.jd02_05.names.User;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TaskB {
    public static void main(String... args) {
        ResManager manager = ResManager.INSTANCE;
        DateFormat dateFormat;
        Date date = new Date();
        Locale locale;
        Scanner sc = new Scanner(System.in);
        String command;
        System.out.println("Введите ru или be или en либо end для выхода");
        while (!(command = sc.nextLine()).equals("end")) {

            switch (command) {
                case ("ru"): {
                    locale = new Locale("ru", "RU");
                    manager.setLocale(locale);
                    dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
                    String welcome = manager.get(Messages.WELCOME);
                    String question = manager.get(Messages.QUESTION);
                    String userName = manager.get(User.NAME);
                    System.out.println(welcome);
                    System.out.println(question);
                    System.out.println(userName);
                    System.out.println(dateFormat.format(date));
                    break;
                }
                case ("be"): {
                    locale = new Locale("be", "BY");
                    manager.setLocale(locale);
                    dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
                    String welcome = manager.get(Messages.WELCOME);
                    String question = manager.get(Messages.QUESTION);
                    String userName = manager.get(User.NAME);
                    System.out.println(welcome);
                    System.out.println(question);
                    System.out.println(userName);
                    System.out.println(dateFormat.format(date));
                    break;
                }
                case ("en"): {
                    locale = new Locale("en", "EN");
                    manager.setLocale(locale);
                    dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
                    String welcome = manager.get(Messages.WELCOME);
                    String question = manager.get(Messages.QUESTION);
                    String userName = manager.get(User.NAME);
                    System.out.println(welcome);
                    System.out.println(question);
                    System.out.println(userName);
                    System.out.println(dateFormat.format(date));
                    break;
                }
                default:
                    System.out.println("Введите другой язык лиюо  end  для выхода");
                    break;
            }
        }
    }
}
