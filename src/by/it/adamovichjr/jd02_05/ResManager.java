package by.it.adamovichjr.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public enum ResManager {
    EXAMPLE;
    private String baseName = "by.it.adamovichjr.jd02_05.resource.message";
    private Locale locale;
    private ResourceBundle bundle;
    private DateFormat df;


    ResManager() {
        Locale.setDefault(Locale.ENGLISH);
        df = DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault());
        setLocale(Locale.getDefault());
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        df = DateFormat.getDateInstance(DateFormat.LONG, locale);
        bundle = ResourceBundle.getBundle(baseName, locale);
    }

    public void setLocale(String language, String country) {
        locale = new Locale(language, country);
        df = DateFormat.getDateInstance(DateFormat.LONG, locale);
        bundle = ResourceBundle.getBundle(baseName, locale);
    }

    public String get(String key) {
        return bundle.getString(key);
    }

    public String getTime(Date date) {
        return df.format(date);
    }
}
