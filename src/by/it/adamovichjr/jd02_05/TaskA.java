package by.it.adamovichjr.jd02_05;

import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        ResManager manager = ResManager.EXAMPLE;
        Date date = new Date();
        if(args.length ==2){
            manager.setLocale(args[0],args[1]);

        }
        Scanner sc = new Scanner(System.in);
        String line;
        while (!(line=sc.nextLine()).equals("end")){
            switch (line){
                case "ru":
                    manager.setLocale("ru","RU");
                    System.out.println(manager.get(Messages.LANGUAGE));
                    break;
                case "be":
                    manager.setLocale("be","BY");
                    System.out.println(manager.get(Messages.LANGUAGE));
                    break;
                case "en":
                    manager.setLocale(Locale.getDefault());
                    System.out.println(manager.get(Messages.LANGUAGE));
                    break;

            }
        }
        System.out.println(manager.get(Messages.HELLO));
        System.out.println(manager.get(Messages.USER_NAME));
        System.out.println(manager.get(Messages.QUESTION));
        System.out.println(date);


    }
}
