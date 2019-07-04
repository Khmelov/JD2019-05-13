package by.it.aadamovich.calc;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {

    INSTANCE;

    private ResourceBundle res;

    ResourceManager() {
        setLocale(Locale.getDefault());
    }

    void setLocale(Locale locale) {
        res = ResourceBundle.getBundle(Patterns.BASENAME, locale);
    }

    String getString(String key) {
        return res.getString(key);
    }
}
