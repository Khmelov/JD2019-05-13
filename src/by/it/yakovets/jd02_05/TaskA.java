package by.it.yakovets.jd02_05;

import by.it.yakovets.jd02_05.names.Messages;
import by.it.yakovets.jd02_05.names.User;

import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TaskA {
    public static void main(String... args) {
        ResManager manager = ResManager.INSTANCE;
        if (args.length == 2) {
            String lang = args[0];
            String country = args[1];
            manager.setLocale(lang, country);

        }
        Scanner sc = new Scanner(System.in);
        String line;
        do {
            String welcome = manager.get(Messages.WELCOME);
            String question = manager.get(Messages.QUESTION);
            String userName = manager.get(User.NAME);
            System.out.println(welcome);
            System.out.println(question);
            System.out.println(userName);
            Date date = new Date();
            System.out.println(date.toString());
            line =sc.nextLine();
            switch (line) {
                case "ru":
                    manager.setLocale("ru","RU");
                    break;
                case "be":
                    manager.setLocale("be","BY");;
                    break;
                case "en":
                    manager.setLocale(Locale.getDefault());
                    break;
            }
        }

        while(!line.equals("end"));


}

}
