package by.it.adamovichjr.calc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;
    private String baseName = "by.it.adamovichjr.calc.resource.all_messages";
    private Locale locale;
    private ResourceBundle bundle;
    private DateFormat df;




    ResourceManager() {
        setLocale(Locale.getDefault());
        df = DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault());
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        bundle = ResourceBundle.getBundle(baseName, locale);
        df = DateFormat.getDateInstance(DateFormat.LONG, locale);
    }

    public void setLocale(String language, String country) {
        locale = new Locale(language, country);
        bundle = ResourceBundle.getBundle(baseName, locale);
        df = DateFormat.getDateInstance(DateFormat.LONG, locale);
    }

    public String get(String key) {
        return bundle.getString(key);
    }

    public String getTime() {
        Date date = new Date();
        return String.format(("%s %tT"), df.format(date), date);
    }

}
