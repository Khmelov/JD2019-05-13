package by.it.adamovichjr.calc;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;
    private String baseName = "by.it.adamovichjr.calc.resource.all_messages";
    private Locale locale;
    private ResourceBundle bundle;



    ResourceManager() {
        setLocale(Locale.getDefault());
    }

    public void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle(baseName, locale);
    }

    public void setLocale(String language, String country) {
        locale = new Locale(language, country);
        bundle = ResourceBundle.getBundle(baseName, locale);
    }

    public String get(String key) {
        return bundle.getString(key);
    }
}
