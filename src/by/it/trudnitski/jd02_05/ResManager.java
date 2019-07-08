package by.it.trudnitski.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public enum ResManager {
    INSTANCE;

    private String baseName="by.it.trudnitski.jd02_05.resourses.messages";
    private Locale locale;
    private ResourceBundle resourceBundle;
    private DateFormat dateFormat;


    ResManager(){
        Locale.setDefault(Locale.ENGLISH);
        dateFormat=DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault());
        setLocal(Locale.getDefault());

    }

    public void setLocal(Locale locale) {
        this.locale = locale;
        resourceBundle=ResourceBundle.getBundle(baseName,locale);
        dateFormat=DateFormat.getDateInstance(DateFormat.LONG, locale);
    }

    public void setLocale(String language, String country) {
        locale = new Locale(language, country);
        dateFormat = DateFormat.getDateInstance(DateFormat.LONG, locale);
        resourceBundle = ResourceBundle.getBundle(baseName, locale);
    }

    public String get(String key){
        return resourceBundle.getString(key);
    }

    public String getTime(Date key) {
        return dateFormat.format(key);
    }

}
