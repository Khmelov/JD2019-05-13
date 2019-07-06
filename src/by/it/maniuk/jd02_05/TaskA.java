package by.it.maniuk.jd02_05;

import by.it.maniuk.jd02_05.ResManager;
import by.it.maniuk.jd02_05.names.Messages;
import by.it.maniuk.jd02_05.names.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class TaskA {
    public static void main(String... args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Locale locale;
        String s;
        String lang = "en";
        String country = "EN";

        while (!(s = bf.readLine()).equals ("end")){
            if (s.equals("ru")) {
                lang = "ru";
                country = "RU";

            }
            if (s.equals("be")) {
                lang = "be";
                country = "BY";

            }
            if (s.equals("en")) {
                Locale.setDefault(Locale.ENGLISH);

            }
           
            ResManager manager = ResManager.INSTANCE;
            locale = new Locale(lang, country);



            manager.setLocale(locale);

            String welcome = manager.get(Messages.WELCOME);
            String question = manager.get(Messages.QUESTION);
            String userName = manager.get(User.NAME);
            System.out.println(welcome);
            System.out.println(question);
            System.out.println(userName);

        }
    }
}
