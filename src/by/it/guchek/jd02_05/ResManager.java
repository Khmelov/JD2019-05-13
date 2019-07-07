package by.it.guchek.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResManager {
    INSTANCE;

    private String basename = "by.it.guchek.jd02_05.resources.message";
    private Locale locale;
    private ResourceBundle bundle;

    ResManager() {
        Locale.setDefault(Locale.ENGLISH);
        bundle = ResourceBundle.getBundle(basename, Locale.getDefault());
    }

    public Locale setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle(basename, locale);
        return this.locale = locale;
    }

    public String get(String key) {
        return bundle.getString(key);
    }

    public Locale getLocale() {
        return this.locale;
    }
}
