package by.it.tbabich.jd02_05;

import by.it.tbabich.jd02_05.names.ResData;

import java.util.Locale;

public class TaskA {
    public static void main(String[] args) {
        ResManager manager = ResManager.INSTANCE;
        if (args.length == 2){
            String lang = args[0];
            String country = args[1];
            Locale locale = new Locale(lang, country);
            manager.setLocale(locale);
        }

        String welcome = manager.get(ResData.WELCOME);
        String question = manager.get(ResData.QUESTION);
        String username = manager.get(ResData.NAME);
        System.out.println(welcome);
        System.out.println(question);
        System.out.println(username);
    }
}
