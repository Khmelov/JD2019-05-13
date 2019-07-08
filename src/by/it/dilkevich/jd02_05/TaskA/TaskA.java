package by.it.dilkevich.jd02_05.TaskA;

import java.util.Locale;
import java.util.ResourceBundle;

public class TaskA {

    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);
        ResManager resManager = new ResManager();

        if (args.length == 2){

            String lang = args[0];
            String country = args[1];
            resManager.setLocale(lang, country);
        }

        ResourceBundle resourceBundle = resManager.getResBundle();

        String hello = resourceBundle.getString("message.welcome");
        String question = resourceBundle.getString("message.question");
        String name = resourceBundle.getString("user.name");

        System.out.println(hello);
        System.out.println(question);
        System.out.println(name);
    }

}
