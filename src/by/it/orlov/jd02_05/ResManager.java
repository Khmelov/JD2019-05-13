package by.it.orlov.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResManager {

    private ResourceBundle resB;
    private DateClass dateDefLang = new DateClass();
    private String dateNow;
    private Locale locale;
    ResManager() {
        setLocale("", "");
        dateDefLang.setdatelocale("en");
        dateNow = dateDefLang.dateFormat();
    }


    ResourceBundle getResBundle() {
        return resB;
    }

    void setLocale(String lang, String countr){
        locale = new Locale(lang, countr);
        String resPath = "by.it.orlov.jd02_05.resources.messages";
        resB = ResourceBundle.getBundle(resPath, locale);
        dateDefLang.setdatelocale(lang);
        dateNow = dateDefLang.dateFormat();
    }

    String getDateNow() {
        return dateNow;
    }

}
