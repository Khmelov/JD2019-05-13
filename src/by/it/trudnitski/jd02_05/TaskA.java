package by.it.trudnitski.jd02_05;

import by.it.trudnitski.jd02_05.names.Messages;
import by.it.trudnitski.jd02_05.names.USer;

import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        ResManager resManager = ResManager.INSTANCE;
        Date date=new Date();
        if (args.length == 2) {
            String lang = args[0];
            String country = args[1];
            Locale locale = new Locale(lang, country);
            resManager.setLocal(locale);
        }
        String welcome = resManager.get(Messages.WELCOME);
        String question = resManager.get(Messages.QUESTION);
        String userName = resManager.get(USer.NAME);
        System.out.println(welcome);
        System.out.println(question);
        System.out.println(userName);

        Scanner sc = new Scanner(System.in);
        String line;
        while (!(line=sc.nextLine()).equals("end")){
            switch (line){
                case "ru":
                    resManager.setLocale("ru","RU");
                    System.out.println(resManager.get(Messages.LANGUAGE));
                    System.out.println(resManager.get(Messages.WELCOME));
                    System.out.println(resManager.get(Messages.QUESTION));
                    System.out.println(resManager.get(USer.NAME));
                    System.out.println(ResManager.INSTANCE.getTime(date));
                    break;
                case "be":
                    resManager.setLocale("be","BY");
                    System.out.println(resManager.get(Messages.LANGUAGE));
                    System.out.println(resManager.get(Messages.WELCOME));
                    System.out.println(resManager.get(Messages.QUESTION));
                    System.out.println(resManager.get(USer.NAME));
                    System.out.println(ResManager.INSTANCE.getTime(date));
                    break;
                case "en":
                    resManager.setLocale("en","EN");
                    System.out.println(resManager.get(Messages.LANGUAGE));
                    System.out.println(resManager.get(Messages.WELCOME));
                    System.out.println(resManager.get(Messages.QUESTION));
                    System.out.println(resManager.get(USer.NAME));
                    System.out.println(ResManager.INSTANCE.getTime(date));
                    break;
            }
        }



    }
}
