package by.it.yakovets.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public enum ResManager {
    INSTANCE;

    private String basename = "by.it.yakovets.jd02_05.resources.messages";
    private Locale locale;
    private ResourceBundle bundle;
    private DateFormat df;

    ResManager() {
        Locale.setDefault(Locale.ENGLISH);
        df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault());
        setLocale(Locale.ENGLISH);

    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        df = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
        bundle = ResourceBundle.getBundle(basename, locale);
    }

    public void setLocale(String lang, String country) {
        this.locale = new Locale(lang, country);
        df = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
        bundle = ResourceBundle.getBundle(basename, locale);
    }

    public String get(String key) {
        return bundle.getString(key);
    }

    public String getDate(Date date) {
        return df.format(date);
    }
}