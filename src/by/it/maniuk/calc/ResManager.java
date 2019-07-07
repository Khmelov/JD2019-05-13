package by.it.maniuk.calc;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResManager {
    INSTANCE;

    private String basename = "by.it.maniuk.calc.resources.messages";
    private Locale locale;
    private ResourceBundle bundle;

    ResManager() {
        setLocale(Locale.ENGLISH);
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        bundle = ResourceBundle.getBundle(basename, locale);
    }

    public String get(String key) {
       // key = key.replace("ERROR:", "");
        return bundle.getString(key);
    }


}
