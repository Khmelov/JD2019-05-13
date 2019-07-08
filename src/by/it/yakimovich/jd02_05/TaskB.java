package by.it.yakimovich.jd02_05;

import by.it.yakimovich.jd02_05.names.Messages;
import by.it.yakimovich.jd02_05.names.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class TaskB {
    public static void main(String[] args) {
        ResManager rm = ResManager.INSTANCE;

        Date date = new Date();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String lang = null;

        try {
            lang = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert lang != null;

        switch (lang) {
            case "ru":
                rm.setLocale(new Locale("ru", "RU"));
                break;
            case "be":
                rm.setLocale(new Locale("be", "BY"));
                break;
            case "en":
                rm.setLocale(new Locale("en", "EN"));
                break;
            default:
                rm.setLocale(new Locale("ru","RU"));
                break;
        }
        DateFormat currentDate = DateFormat.getDateInstance(DateFormat.FULL, Locale.forLanguageTag(lang));
        System.out.println(rm.get(Messages.WELCOME));
        System.out.println(rm.get(Messages.QUESTION));
        System.out.println(rm.get(User.NAME));
        System.out.println(currentDate.format(date));
    }
}

