package by.it.lasotskaya.jd02_05;

import by.it.lasotskaya.jd02_05.names.Messages;
import by.it.lasotskaya.jd02_05.names.User;

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
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        try {
            s = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert s != null;
        switch (s) {
            case "ru":
                rm.setLocale(new Locale("ru", "RU"));
                break;
            case "be":
                rm.setLocale(new Locale("be", "BY"));
                break;
            case "en":
                rm.setLocale(new Locale("en", "EN"));
                break;
        }
        DateFormat dt = DateFormat.getDateInstance(DateFormat.FULL, Locale.forLanguageTag(s));
        System.out.println(rm.get(Messages.WELCOME));
        System.out.println(rm.get(Messages.QUESTION));
        System.out.println(rm.get(User.NAME));
        System.out.println(dt.format(date));
    }
}
