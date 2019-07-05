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

    public void setLocale(Locale locale) {
        this.locale = locale;
        bundle = ResourceBundle.getBundle(basename, locale);
    }

    public String get(String key) {
        return bundle.getString(key);
    }

    public Locale getLocale() {

        return this.locale;
    }
}
