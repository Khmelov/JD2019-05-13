package by.it.lasotskaya.jd02_05;

import by.it.lasotskaya.jd02_05.names.Messages;
import by.it.lasotskaya.jd02_05.names.User;

import java.util.Locale;

public class TaskA {
    public static void main(String... args) {
        ResManager manager = ResManager.INSTANCE;
        if (args.length == 2) {
            String lang=args[0];
            String country=args[1];
            Locale locale = new Locale(lang,country);
            manager.setLocale(locale);
        }

        String welcome = manager.get(Messages.WELCOME);
        String question = manager.get(Messages.QUESTION);
        String userName = manager.get(User.NAME);
        System.out.println(welcome);
        System.out.println(question);
        System.out.println(userName);


    }
}
