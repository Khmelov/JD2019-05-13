package by.it.dnevar.jd02_05;

import by.it.dnevar.jd02_05.names.Messages;
import by.it.dnevar.jd02_05.names.User;

import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TaskB {

    private static Date date = new Date();

    public static void main(String[] args) {
        ResManager manager = ResManager.INSTANCE;
        Scanner sc=new Scanner(System.in);
        String line;
        while(!(line = sc.nextLine()).equals("end")){
            if(line.equals("ru")){
                manager.setLocale(new Locale("ru","RU"));
                printMessages(manager);
            }else if(line.equals("be")){
                manager.setLocale(new Locale("be","BY"));
                printMessages(manager);
            }else if(line.equals("en")){
                manager.setLocale(Locale.getDefault());
                printMessages(manager);
            }
        }



        if (args.length == 2) {
            String lang=args[0];
            String country=args[1];
            Locale locale = new Locale(lang,country);
            manager.setLocale(locale);
        }

        printMessages(manager);


    }

    private static void printMessages(ResManager manager) {
        String welcome = manager.get(Messages.WELCOME);
        String question = manager.get(Messages.QUESTION);
        String userName = manager.get(User.NAME);
        System.out.println(welcome);
        System.out.println(question);
        System.out.println(userName);
        System.out.println(ResManager.INSTANCE.getTime(date));
    }
}
