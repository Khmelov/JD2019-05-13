package by.it.izaykoff.jd02_05;

import by.it.izaykoff.jd02_05.names.Messages;
import by.it.izaykoff.jd02_05.names.User;

import java.text.DateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        ResManager manager = ResManager.INSTANCE;
//        if (args.length == 2){
//            String lang = args[0];
//            String country = args[1];
//            manager.setLocale(new Locale(lang,country));
//        }

        Scanner scan = new Scanner(System.in);
        String reader;
        while (!(reader = scan.nextLine()).equals("end")){
            manager.setLocale(getYourLocale(reader));
            String welcome = manager.get(Messages.WELCOME);
            String question = manager.get(Messages.QUESTION);
            String userName = manager.get(User.NAME);
            String date = manager.get(Messages.DATA);
            System.out.println(welcome);
            System.out.println(date + getDate());
            System.out.println(question);
            System.out.println(userName);
        }



    }

    private static String getDate() {
        ResManager manager = ResManager.INSTANCE;
        DateFormat dateInstance = DateFormat.getDateInstance(DateFormat.LONG, manager.getLocale());
        return dateInstance.format(Date.from(Instant.now()));
    }
    private static Locale getYourLocale(String read) {
        switch (read) {
            case "ru": {
                return new Locale("ru", "RU");
            }
            case "be": {
                return new Locale("be", "BY");
            }
            case "en":
            default: {
                return Locale.ENGLISH;
            }
        }
    }


}
