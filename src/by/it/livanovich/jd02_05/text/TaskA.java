package by.it.livanovich.jd02_05.text;

import by.it.livanovich.jd02_05.names.Data;
import by.it.livanovich.jd02_05.names.Message;
import by.it.livanovich.jd02_05.names.User;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Scanner;

public class TaskA {
    private static Manager manager=Manager.INSTANCE;
    public static void main(String[] args) {

        if (args.length==2){
            String language=args[0];
            String country=args[1];
            Locale locale=new Locale(language,country);
            manager.setLocale(locale);
        }
        Scanner sc=new Scanner(System.in);
        String line;
        while (!((line=sc.next()).equals("end"))) {
            if (line.equals("en")) {
                manager.setLocale(Locale.ENGLISH);
                printText();
            } else if (line.equals("ru")) {
                String language = "ru";
                String country = "RU";
                Locale locale = new Locale(language, country);
                manager.setLocale(locale);
                printText();

            } else if (line.equals("be")) {
                String language = "be";
                String country = "BY";
                Locale locale = new Locale(language, country);
                manager.setLocale(locale);
                printText();
            }

        }
    }
    static void printText (){
        String welcome = manager.get(Data.WELCOME);
        String question = manager.get(Message.QUESTION);
        String userName = manager.get(User.NAME);
        System.out.println(welcome);
        System.out.println(question);
        System.out.println(userName);
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(manager.getLocale());
        String f = today.format(formatter);
        System.out.println(f);
    }
}
