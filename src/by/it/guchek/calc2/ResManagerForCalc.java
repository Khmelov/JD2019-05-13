package by.it.guchek.calc2;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResManagerForCalc {
    INSTANCE;

    private String basename = "by.it.guchek.jd02_05.resources.message";
    private Locale locale;
    private ResourceBundle bundle;

    ResManagerForCalc() {
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
        return this.locale=locale;
    }
}
