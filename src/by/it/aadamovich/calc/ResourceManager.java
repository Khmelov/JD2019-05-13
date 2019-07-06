package by.it.aadamovich.calc;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {

    INSTANCE;

    private ResourceBundle res;
    private Locale locale;

    ResourceManager() {
        setLocale(Locale.getDefault());
    }

    void setLocale(Locale locale) {
        this.locale = locale;
        res = ResourceBundle.getBundle(Patterns.BASENAME, locale);
    }

    void setLocale(String language, String country) {
        this.locale = createLocale(language, country);
        res = ResourceBundle.getBundle(Patterns.BASENAME, locale);
    }

    Locale createLocale(String language, String country) {
        return new Locale(language, country);
    }

    Locale getLocale() {
        return locale;
    }

    String getString(String key) {
        return res.getString(key);
    }
}
