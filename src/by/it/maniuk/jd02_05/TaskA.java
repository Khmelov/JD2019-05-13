package by.it.maniuk.jd02_05;


import by.it.maniuk.jd02_05.names.Messages;
import by.it.maniuk.jd02_05.names.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Locale;

public class TaskA {
    public static void main(String... args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ResManager manager = ResManager.INSTANCE;
        Date data = new Date();
        String s;
        if (args.length == 2) {
            manager.setLocale(args[0],  args[1]);
            String welcome = manager.get(Messages.WELCOME);
            String question = manager.get(Messages.QUESTION);
            String userName = manager.get(User.NAME);
            System.out.println(ResManager.INSTANCE.getTime(data));
            System.out.println(welcome);
            System.out.println(question);
            System.out.println(userName);
        }


        while (!(s=bf.readLine()).equals("end")){
            switch (s){
                case "ru":
                   manager.setLocale("ru","RU");
                    break;
                case "be":
                    manager.setLocale("be","BY");
                    break;
                case "en":
                    manager.setLocale(Locale.getDefault());
                    break;

            }

            String welcome = manager.get(Messages.WELCOME);
            String question = manager.get(Messages.QUESTION);
            String userName = manager.get(User.NAME);
            System.out.println(ResManager.INSTANCE.getTime(data));
            System.out.println(welcome);
            System.out.println(question);
            System.out.println(userName);

        }

}}
