package by.it.guchek.jd02_05;

import by.it.guchek.jd02_05.names.Message;
import by.it.guchek.jd02_05.names.User;

import java.util.Locale;

public class TaskA {

    /*public static void main(String[ ] args) {
        ResManager manager = ResManager.INSTANCE;
        System.out.println(manager.get("message.welcom"));
        manager.setLocale(new Locale("be","BY"));
        System.out.println(manager.get("message.welcom"));
    }*/

    public static void main(String ... args) {
        ResManager manager = ResManager.INSTANCE;
        if (args.length == 2) {
            String lang=args[0];
            String country=args[1];
            Locale locale = new Locale(lang,country);
            manager.setLocale(locale);
        }

        String question = manager.get(Message.QUESTION);
        String welcome = manager.get(Message.WELCOME);
        String userName = manager.get(User.NAME);
        System.out.println(welcome);
        System.out.println(question);
        System.out.println(userName);


    }

}
