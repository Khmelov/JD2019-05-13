package by.it.zhukova.jd02_05;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public enum ResManager {
    INSTANCE;

    private String basename = "by.it.zhukova.jd02_05.resources.str";
    private Locale locale;
    private ResourceBundle bundle;

    ResManager() {
        try {
            Locale.setDefault(Locale.ENGLISH);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setLocale(Locale.ENGLISH);
        getDate(Locale.ENGLISH);
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        bundle = ResourceBundle.getBundle(basename, locale);
    }
    public void changeResource(Locale locale) {
        bundle = ResourceBundle.getBundle(basename, locale);
    }

    public String get(String key) {
        return bundle.getString(key);
    }
    public String getDate (Locale locale){
        LocalDate date = LocalDate.now();
        Date moment =new Date();
        String format = DateFormat.getDateInstance(DateFormat.MEDIUM, locale).format(moment);
        return format;
    }

}
