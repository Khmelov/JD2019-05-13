package by.it.dilkevich.jd02_05.TaskB;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResManager {

    private Locale locale;
    private ResourceBundle resourceBundle;

    private DateClass date = new DateClass();
    private String correctDate;


    ResManager() {
        setLocale("", "");
        date.setDateLocale("en");
        correctDate = date.getDateFormat();
    }


    ResourceBundle getResBundle() {
        return resourceBundle;
    }

    void setLocale(String lang, String countr){

        locale = new Locale(lang, countr);
        String resPath = "by.it.dilkevich.jd02_05.TaskB.resources.messages";
        resourceBundle = ResourceBundle.getBundle(resPath, locale);
        date.setDateLocale(lang);
        correctDate = date.getDateFormat();
    }

    String getCorrectDate() {
        return correctDate;
    }

}
