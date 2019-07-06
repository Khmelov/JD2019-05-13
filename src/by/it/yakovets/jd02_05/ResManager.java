package by.it.yakovets.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResManager {
    INSTANCE;

    private String basename = "by.it.yakovets.jd02_05.resources.messages";
    private Locale locale;
    private ResourceBundle bundle;

    ResManager() {
        Locale.setDefault(Locale.ENGLISH);
        setLocale(Locale.ENGLISH);
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        bundle = ResourceBundle.getBundle(basename, locale);
    }
    public void setLocale(String lang, String country) {
        this.locale = new Locale(lang, country);
        bundle = ResourceBundle.getBundle(basename, locale);
    }

    public String get(String key) {
        return bundle.getString(key);
    }

}