package by.it.dilkevich.calc;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResManager {


    static ResourceBundle resourceBundle;

    public ResManager(Locale locale) {

        resourceBundle = ResourceBundle.getBundle("by.it.dilkevich.calc.resources.messages",locale);
    }

    static String getName(String name){

        return resourceBundle.getString(name);
    }
}
