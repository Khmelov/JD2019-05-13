package by.it.aadamovich.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public enum ResManager {
    INSTANCE;

    private ResourceBundle res;
    private final String basename = "by.it.aadamovich.jd02_05.resources.messages";
    private Locale locale;
    private DateFormat df;

    ResManager() {
        Locale.setDefault(Locale.ENGLISH);
        df = DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault());
        changeResource(Locale.getDefault());
    }

    public void changeResource(String language, String country) {
        locale = new Locale(language,country);
        df = DateFormat.getDateInstance(DateFormat.LONG, locale);
        res = ResourceBundle.getBundle(basename, locale);
    }

    public void changeResource(Locale locale) {
        this.locale = locale;
        df = DateFormat.getDateInstance(DateFormat.LONG, locale);
        res = ResourceBundle.getBundle(basename, locale);
    }

    public String getString(String key) {
        return res.getString(key);
    }

    public String getTime(Date date) {
        return df.format(date);
    }
}