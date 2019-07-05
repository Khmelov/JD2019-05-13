package by.it.tbabich.calc;

import by.it.tbabich.jd02_05.names.ConsoleCommands;
import by.it.tbabich.jd02_05.names.Countries;
import by.it.tbabich.jd02_05.names.Languages;
import by.it.tbabich.jd02_05.names.Messages;

import java.util.Locale;


class Settings {

    static final ResManager manager = ResManager.INSTANCE;

    public void initSetting(String[] args) {
        if (args.length == 2) {
            String lang = args[0];
            String country = args[1];
            Locale locale = new Locale(lang, country);
            manager.setLocale(locale);
        }
    }

    public static boolean isSetLanguage(String expression) {
        boolean isSetLanguage = false;
        switch (expression) {
            case ConsoleCommands.SET_LANGUAGE_RU:
                Settings.manager.setLocale(new Locale(Languages.RU, Countries.RU));
                isSetLanguage = true;
                System.out.println(manager.get(Messages.SET_LANGUAGE));
                break;
            case ConsoleCommands.SET_LANGUAGE_EN:
                Settings.manager.setLocale(new Locale(Languages.EN, Countries.EN));
                isSetLanguage = true;
                System.out.println(manager.get(Messages.SET_LANGUAGE));
                break;
            case ConsoleCommands.SET_LANGUAGE_BE:
                Settings.manager.setLocale(new Locale(Languages.BE, Countries.BY));
                isSetLanguage = true;
                System.out.println(manager.get(Messages.SET_LANGUAGE));
                break;
        }
        return isSetLanguage;
    }
}
