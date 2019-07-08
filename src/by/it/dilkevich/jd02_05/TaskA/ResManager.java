package by.it.dilkevich.jd02_05.TaskA;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResManager {

    Locale locale;
    String resPath = "by.it.dilkevich.jd02_05.TaskA.resources.messages";
    ResourceBundle resourceBundle;

    public ResManager(String lang, String country) {

        locale = new Locale(lang, country);
    }

    public ResManager() {
        setLocale("en", "UK");
    }

    public ResourceBundle getResBundle() {
        return resourceBundle;
    }
    public void setLocale(String lang, String countr){
        locale = new Locale(lang, countr);
        resourceBundle = ResourceBundle.getBundle(resPath, locale);
    }

}
