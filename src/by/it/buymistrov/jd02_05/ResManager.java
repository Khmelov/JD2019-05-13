package by.it.buymistrov.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResManager {

    INSTANCE;

    private ResourceBundle bundle;

    public void setLocale(Locale locale) {
        String basename = "by.it.buymistrov.jd02_05.resources.messages";
        bundle = ResourceBundle.getBundle(basename, locale);
    }

    public String get(String key) {
        return bundle.getString(key);
    }

}
